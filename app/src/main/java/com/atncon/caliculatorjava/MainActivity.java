package com.atncon.caliculatorjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

        TextView textView;
        EditText editText;
        Button button;

        View.OnClickListener buttonListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //textView.setText(editText.getText().toString());

                recentOperator = R.id.button_equal;
                result = 0;
                isOperatorKeyPushed = false;

                textView.setText("");
                editText.setText("");
            }
        };

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            /* textField */
            textView =  findViewById(R.id.textview);

            /* editField */
            editText =  findViewById(R.id.edittext);

            /* CLEAR_buttonField */
            button = findViewById(R.id.button);
            button.setOnClickListener(buttonListener);

            /* ten_key Field */
            findViewById(R.id.button_0).setOnClickListener(buttonNumberListener);
            findViewById(R.id.button_1).setOnClickListener(buttonNumberListener);
            findViewById(R.id.button_2).setOnClickListener(buttonNumberListener);
            findViewById(R.id.button_3).setOnClickListener(buttonNumberListener);
            findViewById(R.id.button_4).setOnClickListener(buttonNumberListener);
            findViewById(R.id.button_5).setOnClickListener(buttonNumberListener);
            findViewById(R.id.button_6).setOnClickListener(buttonNumberListener);
            findViewById(R.id.button_7).setOnClickListener(buttonNumberListener);
            findViewById(R.id.button_8).setOnClickListener(buttonNumberListener);
            findViewById(R.id.button_9).setOnClickListener(buttonNumberListener);
            findViewById(R.id.button_dot).setOnClickListener(buttonNumberListener);

            findViewById(R.id.button_add).setOnClickListener(buttonOperatorListener);
            findViewById(R.id.button_equal).setOnClickListener(buttonOperatorListener);
            findViewById(R.id.button_divide).setOnClickListener(buttonOperatorListener);
            findViewById(R.id.button_multiply).setOnClickListener(buttonOperatorListener);
            findViewById(R.id.button_subtract).setOnClickListener(buttonOperatorListener);
    }

    int recentOperator = R.id.button_equal;
    double result ;
    boolean isOperatorKeyPushed;


    View.OnClickListener buttonOperatorListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Button operatorButton = (Button) view;
            double value = Double.parseDouble(editText.getText().toString());

           if(recentOperator == R.id.button_equal){
               result = value;
           } else {
               result = calc(recentOperator,result,value);
               editText.setText(String.valueOf(result));
           }

           recentOperator = operatorButton.getId();
           textView.setText(operatorButton.getText());
           isOperatorKeyPushed = true;

        }
    };

    public  double calc(int operator, double value1, double value2) {
        switch (operator) {
            case R.id.button_add:
                return value1 + value2;
            case R.id.button_subtract:
                return value1 - value2;
            case R.id.button_multiply:
                return value1 * value2;
            case R.id.button_divide:
                return value1 / value2;
            default:
                return value1;
        }
    }


    View.OnClickListener buttonNumberListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Button button = (Button) view;

            if(isOperatorKeyPushed == true){
                editText.setText(button.getText());
            } else {
                editText.append(button.getText()); // EditTextの後ろに文字を追加 append()
            }
            isOperatorKeyPushed = false;
        }
    };
}
