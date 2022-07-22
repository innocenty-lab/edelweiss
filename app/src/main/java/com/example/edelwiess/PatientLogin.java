package com.example.edelwiess;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PatientLogin extends AppCompatActivity {
    private TextView tv1;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_login);

        button = (Button) findViewById(R.id.toHome);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toHome();
            }
        });

        tv1= (TextView)findViewById(R.id.toSign);
        tv1.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {
                Intent i = new Intent(getApplicationContext(), SignupActivity.class);
                startActivity(i);
                return false;
            }
        });
    }
    public void toHome(){
        Intent intent = new Intent(this, HomePage.class);
        EditText email = findViewById(R.id.emailAddress);
        EditText pass = findViewById(R.id.passwordLog);

        String emailValue = email.getText().toString();
        String passValue = pass.getText().toString();

        if(TextUtils.isEmpty(emailValue) && TextUtils.isEmpty(passValue)){
            Toast.makeText(this, "Field can't be empty ", Toast.LENGTH_SHORT).show();
            return;
        } else {
            startActivity(intent);
        }
    }
}