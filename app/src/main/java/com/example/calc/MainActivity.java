package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //variables de instancia
    double num1 = 0 ,num2 =0, result = 0;

    boolean sign = true;

    Operator operator;

    Button btn_divide, btn_multiply, btn_minus, btn_plus, btn_1,
           btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9,
           btn_dot, btn_zero, btn_equal, btn_clear, btn_percent, btn_change;

    TextView tvResult, tvUserInput;

    public void assignText(String number){
        tvResult.setText(tvResult.getText() + number);
    }

    public double sum(double num1, double num2){
        return num1 + num2;
    }

    public double sub(double num1, double num2){
        return num1 - num2;
    }

    public double mul(double num1, double num2){
        return num1 * num2;
    }

    public double div(double num1, double num2){
        return num1 / num2;
    }

    public double percent (double num1){
        return num1 * 100;
    }

    public Double change(Double number){
        if (sign == true){
            sign = false;
            return number * -1;

        }else{
            sign = true;
            return number;
        }
    }

    enum Operator{
        plus,div,mul,sub,percent
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = findViewById(R.id.tvResult);
        tvUserInput = findViewById(R.id.tvUserInput);
        btn_divide = findViewById(R.id.btn_divide);
        btn_multiply = findViewById(R.id.btn_multiply);
        btn_minus = findViewById(R.id.btn_minus);
        btn_plus = findViewById(R.id.btn_plus);
        btn_1 = findViewById(R.id.btn_one);
        btn_2 = findViewById(R.id.btn_two);
        btn_3 = findViewById(R.id.btn_three);
        btn_4 = findViewById(R.id.btn_four);
        btn_5 = findViewById(R.id.btn_five);
        btn_6 =  findViewById(R.id.btn_six);
        btn_7 = findViewById(R.id.btn_seven);
        btn_8 = findViewById(R.id.btn_eight);
        btn_9= findViewById(R.id.btn_nine);
        btn_dot = findViewById(R.id.btn_dot);
        btn_zero= findViewById(R.id.btn_zero);
        btn_equal = findViewById(R.id.btn_equal);
        btn_clear = findViewById(R.id.btn_clear);
        btn_percent = findViewById(R.id.btn_percent);
        btn_change =findViewById(R.id.btn_change);

        btn_zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                assignText("0");
            }
        });

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                assignText("1");
            }
        });
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                assignText("2");
            }
        });
        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                assignText("3");
            }
        });
        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                assignText("4");
            }
        });
        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                assignText("5");
            }
        });
        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                assignText("6");
            }
        });
        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                assignText("7");
            }
        });
        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                assignText("8");
            }
        });
        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                assignText("9");
            }
        });

        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvResult.setText("");
                tvUserInput.setText("");
                num1 = 0;
                num2 = 0;
                result = 0;
            }
        });

        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operator= Operator.plus;
                num1 = Double.parseDouble(String.valueOf(tvResult.getText()));
                tvResult.setText("");
            }
        });
        btn_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operator = Operator.sub;
                num1 = Double.parseDouble(String.valueOf(tvResult.getText()));
                tvResult.setText("");
            }
        });

        btn_divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operator = Operator.div;
                num1 = Double.parseDouble(String.valueOf(tvResult.getText()));
                tvResult.setText("");
            }
        });

        btn_multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operator = Operator.mul;
                num1 = Double.parseDouble(String.valueOf(tvResult.getText()));
                tvResult.setText("");
            }
        });

        btn_percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operator = Operator.percent;
                num1 = Double.parseDouble(String.valueOf(tvResult.getText()));
                result = percent(num1);
                tvResult.setText(String.valueOf(result)+"%");
            }
        });

        btn_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = Double.parseDouble(String.valueOf(tvResult.getText()));
                num1 = change(num1);
                tvResult.setText(String.valueOf(num1));

            }
        });

        btn_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num2 = Double.parseDouble(String.valueOf(tvResult.getText()));
                switch(operator){
                    case plus:
                        result = sum(num1,num2);
                        break;
                    case sub:
                        result = sub(num1,num2);
                        break;
                    case div:
                        result = div(num1,num2);
                        break;
                    case mul:
                        result = mul(num1,num2);
                        break;

                    default:
                        throw new IllegalStateException("Unexpected Value: "+ operator);
                }

                tvResult.setText(String.valueOf(result));

            }
        });


    }
}