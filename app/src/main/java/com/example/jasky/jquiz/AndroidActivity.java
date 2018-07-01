package com.example.jasky.jquiz;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class AndroidActivity extends AppCompatActivity {
    RadioButton android1_op2, android2_op4, android3_op2, android4_op1, android5_op3;
    RadioGroup rG1, rG2, rG3, rG4, rG5;
    Button submit, btnValidate;
    ImageView profileData;
    String message, scores;
    int score, percent, percentage;
    private Context context;


    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android);
        android1_op2 = findViewById(R.id.android1_op2);
        android2_op4 = findViewById(R.id.android2_op4);
        android3_op2 = findViewById(R.id.android3_op2);
        android4_op1 = findViewById(R.id.android4_op1);
        android5_op3 = findViewById(R.id.android5_op3);


        rG1 = findViewById(R.id.android_rg1);
        rG2 = findViewById(R.id.android_rg2);
        rG3 = findViewById(R.id.android_rg3);
        rG4 = findViewById(R.id.android_rg4);
        rG5 = findViewById(R.id.android_rg5);

//        EditText text = (EditText) findViewById(R.id.username);
//        String name = text.getText().toString();
//        TextView toptext = (TextView) findViewById(R.id.profilename);
//        toptext.setText(name);

        context = this;

        btnValidate = findViewById(R.id.submitButton);
        btnValidate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rG1.getCheckedRadioButtonId() == -1) {
                    // no radio buttons are checked
                    Toast.makeText(AndroidActivity.this, "Question 1 haven't being selected", Toast.LENGTH_SHORT).show();
                } else if (rG2.getCheckedRadioButtonId() == -1) {
                    // no radio buttons are checked
                    Toast.makeText(AndroidActivity.this, "Question 2 haven't being selected", Toast.LENGTH_SHORT).show();
                } else if (rG3.getCheckedRadioButtonId() == -1) {
                    // no radio buttons are checked
                    Toast.makeText(AndroidActivity.this, "Question 3 haven't being selected", Toast.LENGTH_SHORT).show();
                } else if (rG4.getCheckedRadioButtonId() == -1) {
                    // no radio buttons are checked
                    Toast.makeText(AndroidActivity.this, "Question 4 haven't being selected", Toast.LENGTH_SHORT).show();
                } else if (rG5.getCheckedRadioButtonId() == -1) {
                    // no radio buttons are checked
                    Toast.makeText(AndroidActivity.this, "Question 5 haven't being selected", Toast.LENGTH_SHORT).show();
                } else if (rG1.getCheckedRadioButtonId() + rG2.getCheckedRadioButtonId() + rG3.getCheckedRadioButtonId() + rG4.getCheckedRadioButtonId() + rG5.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(AndroidActivity.this, "Make sure u complete the quiz", Toast.LENGTH_SHORT).show();
                } else if (rG1.getCheckedRadioButtonId() + rG2.getCheckedRadioButtonId() + rG3.getCheckedRadioButtonId() + rG4.getCheckedRadioButtonId() + rG5.getCheckedRadioButtonId() != -1) {


                    final Dialog dialog = new Dialog(context);
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog.setCancelable(false);
                    dialog.setCanceledOnTouchOutside(false);
                    dialog.setContentView(R.layout.xml_validation);


                    final CheckBox checking = dialog.findViewById(R.id.end_summary);

                    Button btnContinue = dialog.findViewById(R.id.custom_dialog_btn_continue);
                    Button btnDone = dialog.findViewById(R.id.custom_dialog_btn_done);

                    btnDone.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (checking.isChecked()) {
                                dialog.dismiss();
                                submit();
                            } else {
                                Toast.makeText(AndroidActivity.this, "Please Check the box", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
                    btnContinue.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });

                    dialog.show();

                }
            }



        });

    }
    public void submit(){


            if (android1_op2.isChecked()) {
                score += 1;
                percent += 20;
            }
            if (android2_op4.isChecked()) {
                score += 1;
                percent += 20;
            }
            if (android3_op2.isChecked()) {
                score += 1;
                percent += 20;
            }
            if (android4_op1.isChecked()) {
                score += 1;
                percent += 20;
            }
            if (android5_op3.isChecked()) {
                score += 1;
                percent += 20;
            }

            scores = percent+"%";
            message = "Your answered is " + score +" out of 5 question correctly";
            final Dialog dialog = new Dialog(context);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setCancelable(false);
            dialog.setCanceledOnTouchOutside(false);
            dialog.setContentView(R.layout.result);

            TextView toptext = (TextView) dialog.findViewById(R.id.topview);
            toptext.setText(message);
            TextView scoretext = (TextView) dialog.findViewById(R.id.score);
            scoretext.setText(scores);

        Button btnEndQuiz = dialog.findViewById(R.id.custom_dialog_btn_end);
        Button btnRestart = dialog.findViewById(R.id.custom_dialog_btn_restart);

        btnEndQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(0);

            }
        });
        btnRestart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Intent intent = new Intent(context,AndroidActivity.class);
                startActivity(intent);
            }
        });

        dialog.show();
        }
    }

