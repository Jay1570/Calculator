package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.VisibleForTesting;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    public TextView result,solution;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result=findViewById(R.id.result_tv);
        solution=findViewById(R.id.solution_tv);
        aid(R.id.clear);
        aid(R.id.b_open);
        aid(R.id.b_close);
        aid(R.id.division);
        aid(R.id.multiplication);
        aid(R.id.minus);
        aid(R.id.plus);
        aid(R.id.equal);
        aid(R.id.dot);
        aid(R.id.clearall);
        aid(R.id.button0);
        aid(R.id.button1);
        aid(R.id.button2);
        aid(R.id.button3);
        aid(R.id.button4);
        aid(R.id.button5);
        aid(R.id.button6);
        aid(R.id.button7);
        aid(R.id.button8);
        aid(R.id.button9);
    }
    void aid(int id)
    {
        MaterialButton b=findViewById(id);
        b.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        MaterialButton b=(MaterialButton) v;
        String btext=b.getText().toString();
        String cal=solution.getText().toString();
        if(btext.equals("AC")){
            solution.setText("");
            result.setText("0");
            return;
        }
        if(btext.equals("=")){
            solution.setText(result.getText());
            return;
        }
        if(btext.equals("C")){
            if(cal.length()>0)
                cal=cal.substring(0,cal.length()-1);
        }
        else{
            cal=cal+btext;
        }
        String result1=getResult(cal);
        if(!result1.equals("Err"))
            result.setText(result1);
        solution.setText(cal);
    }

    @VisibleForTesting
    public static String getResult(String d){
        Stack<Double> e1 = new Stack<>();
        double op1, op2, r = 0;
        StringBuilder temp = new StringBuilder();
        Stack<Character> st=new Stack<>();
        char []in= d.toCharArray();
        char []post=new char[in.length*2];
        int j=0;
        for(char c:in){
            switch (c) {
                case '(' -> st.push(c);
                case '+', '-', '*', '/' -> {
                    while (!st.isEmpty() && st.priority((char)st.getTop()) >= st.priority(c)) {
                        post[j++] = ' ';
                        post[j++] = (char)st.pop();
                    }
                    post[j++] = ' ';
                    st.push(c);
                }
                case ')' -> {
                    while ((char)st.getTop() != '(') {
                        post[j++] = ' ';
                        post[j++] = (char)st.pop();
                    }
                    post[j++] = ' ';
                    st.pop();
                }
                default -> post[j++] = c;
            }
        }
        while(!(st.isEmpty())) {
            post[j++] = ' ';
            post[j++] = (char)st.pop();
        }
        try {
            for (char c : post) {
                switch (c) {
                    case '*' -> {
                        op2 = (double) e1.pop();
                        op1 = (double)e1.pop();
                        r = op1 * op2;
                        e1.push(r);
                    }
                    case '/' -> {
                        op2 = (double)e1.pop();
                        op1 = (double)e1.pop();
                        r = op1 / op2;
                        e1.push(r);
                    }
                    case '+' -> {
                        op2 = (double) e1.pop();
                        op1 = (double)e1.pop();
                        r = op1 + op2;
                        e1.push(r);
                    }
                    case '-' -> {
                        op2 = (double)e1.pop();
                        op1 = (double)e1.pop();
                        r = op1 - op2;
                        e1.push(r);
                    }
                    case ' ' -> {
                        if (!temp.toString().isEmpty()) {
                            e1.push(Double.parseDouble(temp.toString()));
                        }
                        temp = new StringBuilder();
                    }
                    default -> temp.append(c);
                }
            }
            return String.valueOf(r);
        }
        catch (Exception e){
            return "Err";
        }
    }
}