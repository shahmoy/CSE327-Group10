package com.example.csesabihaproject.Viewmodel;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.csesabihaproject.R;

/**
 * @author Sabihahossain
 */
public class SubscriptionActivity extends AppCompatActivity {

    private Button SubscriptionAppButton;
    private EditText InputName, InputPhoneNumber, InputPassword, InputPayment;
    private ProgressDialog lodingBar;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscription);


        SubscriptionAppButton = (Button) findViewById(R.id.subscription_btn);
        InputName = (EditText) findViewById(R.id.subscription_username_input);
        InputPhoneNumber = (EditText) findViewById(R.id.subscription_phone_number_input);
        InputPassword = (EditText) findViewById(R.id.subscription_payment_input);
        InputPayment = (EditText) findViewById(R.id.subscription_payment_input);
        lodingBar = new ProgressDialog(this);

        SubscriptionAppButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                createSubscription();
            }
        });
    }
    /**
     * this is for create subscription
     * @param
     */
    void createSubscription() {
        //here inside the method -first we are going to get the inputs-NAME,PHONENUMBER,PASSWORD,CREDITCARD NO
        String name = InputName.getText().toString();
        String phone = InputPhoneNumber.getText().toString();
        String password = InputPassword.getText().toString();
        String payment = InputPassword.getText().toString();

        //now we have to check-if any of these input is empty or not
        if (TextUtils.isEmpty(name)) {
            //if the name input is empty -then we have to give a toast message-to enter a name
            Toast.makeText(this, "Please Write Your Name..", Toast.LENGTH_SHORT).show();


        } else if (TextUtils.isEmpty(phone)) {
            //if the phonenumber input is empty -then we have to give a toast message-to enter a name
            Toast.makeText(this, "Please Write Your Phone Number..", Toast.LENGTH_SHORT).show();


        } else if (TextUtils.isEmpty(password)) {
            //if the password input is empty -then we have to give a toast message-to enter a name
            Toast.makeText(this, "Please Write Your Password..", Toast.LENGTH_SHORT).show();


        } else if (TextUtils.isEmpty(payment)) {
            //if the creditcardno input is empty -then we have to give a toast message-to enter a name
            Toast.makeText(this, "Please fill your payment..", Toast.LENGTH_SHORT).show();


        } else {

            //if everything is okay-than we will store data inside our database
            lodingBar.setTitle("Subscribe Account");
            lodingBar.setMessage("Subscription Successfull");
            lodingBar.setCanceledOnTouchOutside(false);
            lodingBar.show();
            Toast.makeText(this, "Subscription Successfull.", Toast.LENGTH_SHORT).show();

        }
    }

}