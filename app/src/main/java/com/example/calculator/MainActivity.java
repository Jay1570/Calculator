package com.example.calculator;

import android.icu.text.DecimalFormat;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView result,solution;
    int i=0;
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
        switch(btext){
            case "C":
                if(cal.length()>0) {
                    cal = cal.substring(0, cal.length() - 1);
                }
                solution.setText(cal);
                break;
            case "AC":
                solution.setText("");
                result.setText("0");
                break;
            case "=":
                solution.setText(result.getText());
                break;
            default:
                cal+=btext;
                solution.setText(cal);
        }
        result.setText(getresult(cal));
    }


    String getresult(String d){
        double result = 0;
        try {
            String[] operands=d.split("\\+|-|\\*|/");
            String[] operators=d.split("\\d*\\.?\\d+");
            Double num1=Double.parseDouble(operands[0]);
            Double num2=Double.parseDouble(operands[1]);
            switch (operators[1]) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    result = num1 / num2;
                    break;
            }
            if(result%1==0){
                DecimalFormat f = new DecimalFormat("0");
                return f.format(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return String.valueOf(result);
    }
}