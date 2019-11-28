package br.ifsc.edu.firebaseaula;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

public class RecuperarSenha extends AppCompatActivity {

    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    EditText editTextLogin;
    Button recuperar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_senha);

        editTextLogin = findViewById(R.id.txt_email);


    }

    public void recuperar(View view) {

        if(!editTextLogin.equals("")){
           mAuth.sendPasswordResetEmail(editTextLogin.toString());
        }

    }
}
