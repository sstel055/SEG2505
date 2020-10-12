package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.util.*;

import static java.lang.Double.NaN;

public class MainActivity extends AppCompatActivity {
    private enum  Operator {none, add, minus, multiply, divide}
    private double num1 = 0, num2 = 0;
    private Operator optr = Operator.none;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void numClick(View view) {
        TextView resultView = (TextView)findViewById(R.id.resultEdit);
        if (resultView.getText().toString() == "ERROR") {
            resultView.setText("");
        }
        int id = view.getId();
        switch (id){
            case R.id.btn00:
                resultView.setText(resultView.getText() + "0");
                break;
            case R.id.btn01:
                resultView.setText(resultView.getText() + "1");
                break;
            case R.id.btn02:
                resultView.setText(resultView.getText() + "2");
                break;
            case R.id.btn03:
                resultView.setText(resultView.getText() + "3");
                break;
            case R.id.btn04:
                resultView.setText(resultView.getText() + "4");
                break;
            case R.id.btn05:
                resultView.setText(resultView.getText() + "5");
                break;
            case R.id.btn06:
                resultView.setText(resultView.getText() + "6");
                break;
            case R.id.btn07:
                resultView.setText(resultView.getText() + "7");
                break;
            case R.id.btn08:
                resultView.setText(resultView.getText() + "8");
                break;
            case R.id.btn09:
                resultView.setText(resultView.getText() + "9");
                break;
            case R.id.btnDot:
                resultView.setText(resultView.getText() + ".");
                break;
            default:
                resultView.setText("ERROR");
                break;
        }
    }

    public void operatorClick(View view) {
        int id = view.getId();
        TextView resultView = (TextView)findViewById(R.id.resultEdit);
        switch (id){
            case R.id.btnAdd:
                optr = Operator.add;
                break;
            case R.id.btnMinus:
                optr = Operator.minus;
                break;
            case R.id.btmMultiply:
                optr = Operator.multiply;
                break;
            case R.id.btnDivide:
                optr = Operator.divide;
                break;
            default:
                resultView.setText("ERROR");
                break;
        }
        if(resultView.getText().toString() != "") {
            num1 = Double.parseDouble(resultView.getText().toString());
            resultView.setText("");
        }
    }

    public void btnClearClick(View view) {
        TextView resultView = (TextView)findViewById(R.id.resultEdit);
        if(resultView.getText().toString() == ""){
            num1 = 0;
        }
        resultView.setText("");
    }

    public void btnResultClick(View view) {
        TextView resultView = (TextView)findViewById(R.id.resultEdit);
        if(optr != Operator.none){
            num2 = Double.parseDouble(resultView.getText().toString());
            double result = 0;
            if(optr == Operator.add){
                result = num1 + num2;
            } else if(optr == Operator.minus){
                result = num1 - num2;
            } else if(optr == Operator.multiply){
                result = num1 * num2;
            } else if(optr == Operator.divide){
                result = num1 / num2;
            }

            if(num2 == 0 && optr == Operator.divide) {
                num1 = 0;
                num2 = 0;
                resultView.setText("NaN");
            }else if(result - (int)result != 0){
                result = Math.round(result*1000000000);
                result = result/(1000000000);
                resultView.setText(String.valueOf(result));
            } else {
                resultView.setText(String.valueOf((int)result));
            }
            optr = Operator.none;
            num1 = result;
        }
    }
}