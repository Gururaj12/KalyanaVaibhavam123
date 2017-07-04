package com.example.admin.kalyanavaibhavam;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;

public class User_Register5 extends Activity {

    private Button button_last;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__register5);

        button_last = (Button)findViewById(R.id.button_last);
        button_last.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(User_Register5.this, Image_activity.class);
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
