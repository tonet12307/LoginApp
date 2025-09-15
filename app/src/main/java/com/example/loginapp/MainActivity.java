package com.example.loginapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
public class MainActivity extends AppCompatActivity {
    private TextInputEditText usernameEditText, passwordEditText;
    private TextInputLayout usernameLayout, passwordLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usernameLayout = findViewById(R.id.usernameLayout);
        passwordLayout = findViewById(R.id.passwordLayout);
        usernameEditText = findViewById(R.id.editTextUsername);
        passwordEditText = findViewById(R.id.editTextPassword);
        MaterialButton loginButton;
        loginButton = findViewById(R.id.buttonLogin);
        loginButton.setOnClickListener(v -> {
            if (validateInputs()) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
            }
        });
    }
    private boolean validateInputs() {
        String username = usernameEditText.getText() != null ? usernameEditText.getText().toString().trim() : "";
        String password = passwordEditText.getText() != null ? passwordEditText.getText().toString().trim() : "";
        boolean valid = true;
        if (username.isEmpty()) {
            usernameLayout.setError("Username cannot be empty");
            valid = false;
        } else {
            usernameLayout.setError(null);
        }
        if (password.isEmpty()) {
            passwordLayout.setError("Password cannot be empty");
            valid = false;
        } else {
            passwordLayout.setError(null);
        }
        return valid;
    }
    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "App minimized", Toast.LENGTH_SHORT).show();
        Log.d("Lifecycle", "onPause called");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Lifecycle", "onStop called");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Lifecycle", "onRestart called");
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Lifecycle", "onStart called");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Lifecycle", "onResume called");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Lifecycle", "onDestroy called");
    }
}
