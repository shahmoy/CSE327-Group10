package com.example.eshopp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class LogoutactivityActivity extends AppCompatActivity {

Button Logout;
protected void onCreate(Bundle savedInstancesState){
    super.onCreate(savedInstancesState);
    setContentView(layout.logout);
    Logout = (Button) findViewById(R.id.buttonLogout);
    Intent in = getIntent();
    String string = in.getStringExtra("message");
    Logout.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v){

            AlertDialog .Builder builder = new AlertDialog.Builder(Logout.this);
            builder.setTitle("Confirmation Popup!");
               setMessage("Do you want to Logout?");
               builder.setPositiveButton("Yes");
               new DialogInterface.OnClickListener(){
               
                   public void onclick(DialogInterface dialog,int id){
                       Intent i = new Intent(getApplicationContext(),MainActivity.class);
                       startActivity(i);
                   }
               });
    builder.setNegativeButton("No");
    new DialogInterface.OnClickListener(){
        @Override
        public void onClick(DialogInterface dialog, int id) {
            dialog.cancel();
        }
    });
AlertDialog alter11 = builder.create();
alter11.show();
    }
        });

}

}