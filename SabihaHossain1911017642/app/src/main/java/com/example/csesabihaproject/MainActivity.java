package com.example.csesabihaproject;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.csesabihaproject.Viewmodel.SubscriptionActivity;
/**
 * @version 1.0a
 * @author Sabihahossain
 */

public class MainActivity extends AppCompatActivity {
    private Button subscribeNowButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        subscribeNowButton = (Button) findViewById(R.id.main_subscribe_now);
        subscribeNowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SubscriptionActivity.class);
                startActivity(intent);

            }
        });

    }
}