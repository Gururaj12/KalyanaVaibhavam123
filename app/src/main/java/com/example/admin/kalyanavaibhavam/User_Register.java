package com.example.admin.kalyanavaibhavam;


import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.FileNotFoundException;
import java.io.IOException;


public class User_Register extends Activity {

    private EditText et_email;

    private EditText et_first_name;
    private EditText et_last_name;

    private Spinner spinner_profile;
    private Spinner spinner_sister;
    private Spinner spinner_brother;
    private Spinner spinner_gender;
    private Spinner spinner_date;
    private Spinner spinner_month;
    private Spinner spinner_year;
    private Spinner spinner_religion;
    private Spinner spinner_mother_tongue;
    private Spinner spinner_country;
    private Spinner spinner_state;

    private EditText et_not_in_list;
    private ProgressBar progressBar;
    private Button regButton;

    private EditText  edt_password;

    private CheckBox mShowPwd;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__register);

        Firebase.setAndroidContext(this);


        progressBar = (ProgressBar)findViewById(R.id.progressBar2);
        et_email = (EditText) findViewById(R.id.et_email);
        et_not_in_list = (EditText) findViewById(R.id.et_not_in_list);

        edt_password = (EditText) findViewById(R.id.et_password);

        et_first_name = (EditText) findViewById(R.id.et_first_name);
        et_last_name = (EditText) findViewById(R.id.et_last_name);

        spinner_profile = (Spinner) findViewById(R.id.spinner_profile);
        spinner_sister = (Spinner) findViewById(R.id.spinner_sister);
        spinner_brother = (Spinner) findViewById(R.id.spinner_brother);
        spinner_gender = (Spinner) findViewById(R.id.spinner_gender);
        spinner_date = (Spinner) findViewById(R.id.spinner_date);
        spinner_month = (Spinner) findViewById(R.id.spinner_month);
        spinner_year = (Spinner) findViewById(R.id.spinner_year);
        spinner_religion = (Spinner) findViewById(R.id.spinner_religion);
        spinner_mother_tongue = (Spinner) findViewById(R.id.spinner_mother_tongue);
        spinner_country = (Spinner) findViewById(R.id.spinner_country);
        spinner_state = (Spinner) findViewById(R.id.spinner_state);

        regButton = (Button) findViewById(R.id.button_next);

        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creating firebase object
                Firebase ref = new Firebase(Config.FIREBASE_URL);

                //Getting values to storeW
                String email = et_email.getText().toString().trim();
                String password = edt_password.getText().toString().trim();
                String profile_for = spinner_profile.getSelectedItem().toString();
                String first_name = et_first_name.getText().toString().trim();
                String last_name = et_last_name.getText().toString().trim();
                String sister = spinner_sister.getSelectedItem().toString();
                String brother = spinner_brother.getSelectedItem().toString();
                String gender = spinner_gender.getSelectedItem().toString();
                String date = spinner_date.getSelectedItem().toString();
                String month = spinner_month.getSelectedItem().toString();
                String year = spinner_year.getSelectedItem().toString();
                String religion = spinner_religion.getSelectedItem().toString();
                String mother_tongue = spinner_mother_tongue.getSelectedItem().toString();
                String country = spinner_country.getSelectedItem().toString();
                String state = spinner_state.getSelectedItem().toString();
                String not_in_list = et_not_in_list.getText().toString().trim();

                //Creating User object
                Users users = new Users(email, password, profile_for, first_name, last_name,
                        sister,brother, gender, date, month, year, religion, mother_tongue, country, state, not_in_list);
                //Adding values
                users.setEmail(email);
                users.setPassword(password);
                users.setProfile_for(profile_for);
                users.setFirst_name(first_name);
                users.setLast_name(last_name);
                users.setSisters(sister);
                users.setBrothers(last_name);
                users.setGender(last_name);
                users.setDate(last_name);
                users.setMonth(last_name);
                users.setYear(last_name);
                users.setReligion(last_name);
                users.setMother_tongue(last_name);
                users.setCountry(last_name);
                users.setState(last_name);
                users.setNot_in_list(not_in_list);

                //Storing values to firebase
                ref.child("Users").setValue(users);

                Intent intent = new Intent(User_Register.this, User_Register2.class);
                startActivity(intent);
                finish();


            }
        });

        mShowPwd = (CheckBox) findViewById(R.id.chbox_showpassword);

        mShowPwd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isChecked) {

                    edt_password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                } else {

                    edt_password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
            }
        });


        addListenerOnText();

    }

    public void addListenerOnText() {

        final Context context = this;
        textView = (TextView) findViewById(R.id.text_login);
        textView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(context, MainActivity.class);
                startActivity(intent);

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