package com.example.admin.kalyanavaibhavam;

import android.app.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.firebase.client.Firebase;


public class User_Register2 extends Activity {


    private EditText editText_community;
    private EditText editText_sub_community;
    private Spinner spinner_marital;
    Button button_continue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__register2);

        Firebase.setAndroidContext(this);

        spinner_marital = (Spinner) findViewById(R.id.spinner_marital);

        editText_community = (EditText) findViewById(R.id.editText_community);
        editText_sub_community = (EditText) findViewById(R.id.editText_sub_community);
        button_continue = (Button) findViewById(R.id.button_continue);



        //Click Listener for button
        button_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creating firebase object
                Firebase ref = new Firebase(Config.FIREBASE_URL);

                //Getting values to storeW
                String community = editText_community.getText().toString().trim();
                String sub_community = editText_sub_community.getText().toString().trim();

                String marital = spinner_marital.getSelectedItem().toString();

                //Creating User object
                Users users = new Users(community, sub_community,marital);
                //Adding values
                users.setCommunity(community);
                users.setSub_community(sub_community);
                users.setMarital(marital);

                //Storing values to firebase
                ref.child("Users").setValue(users);

                Intent intent = new Intent(User_Register2.this, User_Register3.class);
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
