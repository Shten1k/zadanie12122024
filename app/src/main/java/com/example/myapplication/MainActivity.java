package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private int count = 0;
    private String temp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        TextView likeCounter = findViewById(R.id.likeCounter);
        Button likeButton = findViewById(R.id.likeButton);
        Button likeClearButton = findViewById(R.id.likeClearButton);
        EditText email = findViewById(R.id.email);
        EditText password1 = findViewById(R.id.pas1);
        EditText password2 = findViewById(R.id.pas2);
        Button saveDataButton = findViewById(R.id.saveDataButton);
        Button showButton = findViewById(R.id.showButton);
        TextView info = findViewById(R.id.info);

        likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                likeCounter.setText(String.valueOf(count) + " polubień");
            }
        });
        likeClearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count !=0){
                    count--;
                }
                likeCounter.setText(String.valueOf(count) + " polubień");
            }
        });
        //login

        saveDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(email.getText().toString().contains("@")){
                    if(password1.getText().toString().equals(password2.getText().toString())){
                        info.setText("Zarejestrowano: " + email.getText().toString());
                        temp = email.getText().toString();
                    }else{
                        info.setText("Hasla sie roznia");
                    }
                }else{
                    info.setText("Email nie zawiera '@' ");
                }


            }
        });
            showButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    info.setText(temp);
                }
            });


    }
}