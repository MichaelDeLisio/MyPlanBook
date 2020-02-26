package utm.csc301.theBrogrammers.myPlanBook.ui.login;

import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import utm.csc301.theBrogrammers.myPlanBook.MainActivity;
import utm.csc301.theBrogrammers.myPlanBook.R;

public class LoginActivity extends AppCompatActivity {

    private LoginViewModel loginViewModel;
    private EditText usernameInput;
    private EditText passwordInput;
    private String sign, pass;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginViewModel = ViewModelProviders.of(this, new LoginViewModelFactory())
                .get(LoginViewModel.class);


        usernameInput = findViewById(R.id.UsernameInput);
        passwordInput = findViewById(R.id.PasswordInput);
        Button login = findViewById(R.id.LoginButton);
        Button signup = findViewById(R.id.SignupButton);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = usernameInput.getText().toString();
                String password = passwordInput.getText().toString();
                valid(username, password);

            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                 /////////////

//                 clickbutton();

//                 /////////////
//                 loadingProgressBar.setVisibility(View.VISIBLE);
//                 loginViewModel.login(usernameEditText.getText().toString(),
//                         passwordEditText.getText().toString());
                
                Intent intent = new Intent(LoginActivity.this, Signup.class);
                startActivity(intent);
            }
        });


    }

    public void valid(String username, String password){

        if(username.equals("login") && password.equals("pass") || username.equals(sign) && password.equals(pass)){
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        } else if(username.equals(sign) && password.equals(pass) && username != null && username != null){
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        } else{
            Toast.makeText(LoginActivity.this, sign, Toast.LENGTH_SHORT).show();
        }

    }

}
