package com.example.iot_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {


    ToggleButton togglebtn;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        togglebtn= findViewById(R.id.toggle);
        img= findViewById(R.id.imageView2);

        img.setImageDrawable(getResources().getDrawable(R.drawable.night1));


            togglebtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (togglebtn.isChecked())
                    {
                        int on = 1;
                        FirebaseDatabase.getInstance().getReference("moistureBoolean").setValue(on).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(MainActivity.this, "Lights are turned on", Toast.LENGTH_SHORT).show();
                                    img.setImageDrawable(getResources().getDrawable(R.drawable.day1));
                                } else {
                                    Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();

                                }
                            }
                        });

                    }

                    else {

                        int off = 0;
                        FirebaseDatabase.getInstance().getReference("moistureBoolean").setValue(off).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(MainActivity.this, "Lights are turned off", Toast.LENGTH_LONG).show();
                                    img.setImageDrawable(getResources().getDrawable(R.drawable.night1));
                                } else {
                                    Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_LONG).show();

                                }
                            }
                        });

                    }
                }
            });


    }}


