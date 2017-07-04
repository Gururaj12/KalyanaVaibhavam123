package com.example.admin.kalyanavaibhavam;


import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.Color;
import android.content.Intent;


import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.firebase.client.Firebase;


public class User_Register4 extends Activity implements TextWatcher {

    private Spinner spinner_food_type;
    private Spinner spinner_smoke;
    private Spinner spinner_drink;
    private Spinner spinner_height;
    private Spinner spinner_body_type;
    private Spinner spinner_skin_tone;
    private Spinner spinner_mobile;

    private EditText edt_number;

    private Spinner spinner_disability;
    private EditText edit_user_name;
    private EditText edit_about_him;

    TextView WordCountTXT,CharCountTXT;

    private Button button_done;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__register4);

        Firebase.setAndroidContext(this);

        spinner_food_type = (Spinner)findViewById(R.id.spinner_food_type);
        spinner_smoke = (Spinner)findViewById(R.id.spinner_smoke);
        spinner_drink = (Spinner)findViewById(R.id.spinner_drink);
        spinner_height = (Spinner)findViewById(R.id.spinner_height);
        spinner_body_type = (Spinner)findViewById(R.id.spinner_body_type);
        spinner_skin_tone = (Spinner)findViewById(R.id.spinner_skin_tone);
        spinner_mobile = (Spinner)findViewById(R.id.spinner_mobile);


        spinner_disability = (Spinner)findViewById(R.id.spinner_disability);

        edt_number = (EditText)findViewById(R.id.edt_number);
        edit_user_name = (EditText)findViewById(R.id.edit_user_name);
        edit_about_him = (EditText)findViewById(R.id.edit_about_him);
        edit_about_him.addTextChangedListener(this);

        CharCountTXT=(TextView)findViewById(R.id.textView_count);
        WordCountTXT=(TextView)findViewById(R.id.textView_count1);

        button_done = (Button)findViewById(R.id.button_done);

        button_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Firebase ref = new Firebase(Config.FIREBASE_URL);

                //Getting values to store

                String food_type = spinner_food_type.getSelectedItem().toString();
                String smoke = spinner_smoke.getSelectedItem().toString();
                String drink = spinner_drink.getSelectedItem().toString();
                String height = spinner_height.getSelectedItem().toString();
                String body_type = spinner_body_type.getSelectedItem().toString();
                String skin_tone = spinner_skin_tone.getSelectedItem().toString();
                String mobile = spinner_mobile.getSelectedItem().toString();
                String disability = spinner_disability.getSelectedItem().toString();

                String number = edt_number.getText().toString().trim();
                String about_him = edit_about_him.getText().toString().trim();
                String user_name = edit_user_name.getText().toString().trim();


                // creating user object

                Users users = new Users(food_type, smoke, drink, height, body_type,
                        skin_tone, mobile, disability, number, about_him, user_name);

                //Adding values
                users.setFood_type(food_type);
                users.setSmoke(smoke);
                users.setDrink(drink);
                users.setHeight(height);
                users.setBody_type(body_type);
                users.setSkin_tone(skin_tone);
                users.setMobile(mobile);
                users.setDisability(disability);;
                users.setNumber(number);
                users.setAbout_him(about_him);
                users.setUser_name(user_name);


                //Storing values to firebase `
                ref.child("Users").setValue(users);

                Intent intent = new Intent(User_Register4.this, User_Register5.class);
                startActivity(intent);
                finish();
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.character_count, menu);
        return true;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count,
                                  int after) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        //CharCountTXT.setText(s.length());
        //CharCountTXT.setTextColor(Color.GREEN);
    }
    @Override
    public void afterTextChanged(Editable s) {
        int slenght=s.length();
        String input=edit_about_him.getText().toString().trim().replaceAll("\n", "");
        String[] wordCount=input.split("\\s");
        WordCountTXT.setText("Word Count is: "+String.valueOf(wordCount.length));
        CharCountTXT.setText("Character count is: "+String.valueOf(slenght));
        CharCountTXT.setTextColor(Color.GREEN);

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
