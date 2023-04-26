package com.example.abdul;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class Dashboard extends AppCompatActivity {

    Button button_capacity , button_profile;

    TextView textView_new_cylinder;
    TextView textView_exchange;
    TextView textView_complain;
    TextView textView_logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        button_capacity = findViewById(R.id.capacity);
        button_profile =findViewById(R.id.user_profile);
        textView_new_cylinder= findViewById(R.id.newcylinder);
        textView_exchange= findViewById(R.id.exchange);
        textView_complain= findViewById(R.id.complaint);
        textView_logout = findViewById(R.id.logout);
        button_capacity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Capacitylevel.class);
                startActivity(intent);
                finish();
            }
        });
       textView_new_cylinder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), New_Cylinder.class);
                startActivity(intent);
                finish();
            }
        });
        textView_exchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Dashboard.class);
                startActivity(intent);
                finish();
            }
        });
        textView_complain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Complain.class);
                startActivity(intent);
                finish();
            }
        });
        button_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), UserProfile.class);
                startActivity(intent);
                finish();
            }
        });
        textView_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                finish();
            }
        });
    }
}