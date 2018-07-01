package com.example.jasky.jquiz;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Timer;
import java.util.TimerTask;

public class RegisterActivity extends AppCompatActivity {
    Button register;
    private Context context;
    RadioGroup gender;
    RadioButton man, woman;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        context = this;
        man = findViewById(R.id.male);
        woman = findViewById(R.id.female);

        register = findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText uText = (EditText) findViewById(R.id.username);
                String name = uText.getText().toString();
                EditText aText = (EditText) findViewById(R.id.age);
                String age = aText.getText().toString();
                EditText pText = (EditText) findViewById(R.id.phone);
                String mobile = pText.getText().toString();
                gender = findViewById(R.id.gender);

                if (name.matches("")) {
                    Toast.makeText(context, "UserName required", Toast.LENGTH_SHORT).show();
                }
                else if (age.matches("")) {
                    Toast.makeText(context, "Age required", Toast.LENGTH_SHORT).show();
                }
                else if (mobile.matches("")) {
                    Toast.makeText(context, "Phone Number required", Toast.LENGTH_SHORT).show();
                }
                else if (gender.getCheckedRadioButtonId() == -1){
                    Toast.makeText(RegisterActivity.this, "Select your gender", Toast.LENGTH_SHORT).show();
                }
                else {
                    final ProgressDialog TempDialog;
                    final CountDownTimer CDT;
                    final int[] i = {5};

                    TempDialog = new ProgressDialog(RegisterActivity.this);
                    TempDialog.setMessage("Please wait...");
                    TempDialog.setCancelable(false);
                    TempDialog.setProgress(i[0]);
                    TempDialog.show();

                    CDT = new CountDownTimer(6000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            TempDialog.setMessage("Please wait.." + i[0] + " sec");
                            --i[0];
                        }

                        public void onFinish() {
                            Intent intent = new Intent(context, AndroidActivity.class);
                            startActivity(intent);
                            TempDialog.dismiss();

                        }
                    }.start();
                }
            }
        });
        }
}
