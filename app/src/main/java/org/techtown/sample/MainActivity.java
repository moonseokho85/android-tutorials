package org.techtown.sample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextInputEditText TextInputEditText_email, TextInputEditText_password;
    RelativeLayout RelativeLayout_login;

    String emailOK = "123@gmail.com";
    String passwordOK = "1234";

    String inputEmail = "";
    String inputPassword = "";

    // main(String[] args])
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextInputEditText_email = findViewById(R.id.TextInputEditText_email);
        TextInputEditText_password = findViewById(R.id.TextInputEditText_password);
        RelativeLayout_login = findViewById(R.id.RelativeLayout_login);

        // 1. 값을 가져온다. - 검사(서버) => ( 123@gmail.com / 1234 )
        // 2. 클릭을 감지한다.
        // 3. 1번의 값을 다음 액티비티로 넘긴다.

        RelativeLayout_login.setClickable(false);
        TextInputEditText_email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence != null){
                    Log.d("SENTI", charSequence.toString());

                    inputEmail = charSequence.toString();
                    RelativeLayout_login.setClickable(validation());

                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        TextInputEditText_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence != null){
                    Log.d("SENTI", charSequence.toString());

                    inputPassword = charSequence.toString();
//                    if(validation()){
//                        RelativeLayout_login.setClickable(true);
//
//                    }
//                    else {
//                        RelativeLayout_login.setClickable(false);
//
//                    }
                    RelativeLayout_login.setClickable(validation());
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

//        RelativeLayout_login.setClickable(true);
        RelativeLayout_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("SENTI", "onClick");
                String email = TextInputEditText_email.getText().toString();
                String password = TextInputEditText_password.getText().toString();

                Intent intent = new Intent(MainActivity.this, LoginResultActivity.class);
                intent.putExtra("email", email);
                intent.putExtra("password", password);
                startActivity(intent);
            }
        });
    }
    public boolean validation() {
        Log.d("SENTI", inputEmail + " / " + inputPassword + " / " + inputEmail.equals(emailOK) + " / " + inputPassword.equals(passwordOK));
        return inputEmail.equals(emailOK) && inputPassword.equals(passwordOK);
    }
}
