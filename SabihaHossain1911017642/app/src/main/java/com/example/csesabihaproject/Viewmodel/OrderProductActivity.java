
package com.example.csesabihaproject.Viewmodel;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.csesabihaproject.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * @version 1.0a
 * @author Sabihahossain
 */

public class OrderProductActivity extends AppCompatActivity {

    private EditText nameEditText, phoneEditText, addressEditText, cityEditText;
    private Button confirmOrderBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_product);


        confirmOrderBtn = (Button) findViewById(R.id.confirm_final_order_btn);
        nameEditText = (EditText) findViewById(R.id.shipment_name);
        phoneEditText = (EditText) findViewById(R.id.shipment_phone_number);
        addressEditText = (EditText) findViewById(R.id.shipment_address);
        cityEditText = (EditText) findViewById(R.id.shipment_city);


        confirmOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //here we are going to call a method

                validateAddress();


            }

            /**
             * this method is for check validation
             * @param
             */
            private void validateAddress() {
                //from the root we are going to do validation
                final DatabaseReference RootRef;
                //this is the reference to the root
                RootRef = FirebaseDatabase.getInstance().getReference();
                RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                        //here first we are going to check if the user contain address or not
                        String vaddress;
                        if (!(dataSnapshot.child(("Users").child(vaddress).exists))) {

                            Toast.makeText(OrderProductActivity.this, "this" + vaddress + " address is not clear", Toast.LENGTH_SHORT).show();


                        } else {

                            Toast.makeText(OrderProductActivity.this, "order will reached in this" + vaddress + " in a short time", Toast.LENGTH_SHORT).show();

                        }


                    }
                });


            }

        }   

           

    }
}



