package com.example.abdul;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class New_Cylinder extends AppCompatActivity {

    Button place_order;
    Switch smartdevice;
    TextInputEditText cylindersize;
    TextInputEditText cylindercolor;
    FirebaseAuth mAuth;
    FirebaseFirestore fStore;
    String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_cylinder);
        smartdevice = findViewById(R.id.smartdevice);
        cylindersize = findViewById(R.id.cylindersize);
        cylindercolor = findViewById(R.id.cylindercolor);
        mAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        userID = mAuth.getCurrentUser().getUid();
        place_order = findViewById(R.id.place_order);
        place_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String size,color;
                size = String.valueOf(cylindersize.getText());
                color = String.valueOf(cylindercolor.getText());
                String smart;
                if(smartdevice.isChecked()){
                    //smart device is checked
                    smart = "Yes";
                }
                else{
                    //smart device is not checked
                    smart = "No";
                }
//               put the code here to store the data in the database
                userID = mAuth.getCurrentUser().getUid();
                DocumentReference documentReference = fStore.collection("bookings").document(userID);
                Map<String,Object> user = new HashMap<>();
                user.put("Size",size);
                user.put("Color",color);

                user.put("Smart Device Included",smart);
//                add date and time
                Date date = new Date();
                user.put("Date",date.toString());
//               loggedInUser name and email
                user.put("Name",mAuth.getCurrentUser().getDisplayName());
                user.put("Email",mAuth.getCurrentUser().getEmail());
//               user id
                user.put("User ID",userID);
                fStore.collection("bookings").document(userID).set(user).addOnSuccessListener(
                        new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(New_Cylinder.this, "Booking is stored",
                                        Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), Login.class);
                                startActivity(intent);
                                finish();
                            }
                        }
                );
            }
        });


    }

}