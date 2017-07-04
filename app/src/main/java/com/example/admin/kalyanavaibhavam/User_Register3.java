package com.example.admin.kalyanavaibhavam;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.firebase.client.*;


public class User_Register3 extends Activity {

    private Spinner spinner_education_level;
    private EditText edit_education_field;
    private Spinner spinner_works_as;
    private EditText edit_works_as;
    Button button_continue_2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__register3);

        Firebase.setAndroidContext(this);

        spinner_education_level = (Spinner)findViewById(R.id.spinner_education_level);
        spinner_works_as = (Spinner)findViewById(R.id.spinner_works_as);

        edit_education_field = (EditText)findViewById(R.id.edit_education_field);
        edit_works_as = (EditText)findViewById(R.id.edit_works_as);

        button_continue_2 = (Button)findViewById(R.id.button_continue_2);


        button_continue_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Firebase ref = new Firebase(Config.FIREBASE_URL);

                //Getting values to store

                String education_level = spinner_education_level.getSelectedItem().toString();

                String works_as = spinner_works_as.getSelectedItem().toString();
                String education_field = edit_education_field.getText().toString().trim();
                String works = edit_works_as.getText().toString().trim();


                // creating user object

                Users users = new Users(education_level, works_as, education_field, works);

                //Adding values
                users.setEducation_level(education_level);
                users.setWorks_as(works_as);
                users.setEducation_field(education_field);
                users.setWorks(works);

                //Storing values to firebase `
                ref.child("Users").setValue(users);

                Intent intent = new Intent(User_Register3.this, User_Register4.class);
                startActivity(intent);
                finish();
            }
        });



    }
    @Override
    public void onBackPressed() {

        new AlertDialog.Builder(this)
                .setIcon(R.drawable.mark)
                .setTitle("Kalyana Vaibhavam")
                .setMessage("Are you sure you want to exit?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }

                })
                .setNegativeButton("No", null)
                .show();


    }


}


