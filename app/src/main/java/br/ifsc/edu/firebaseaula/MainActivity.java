package br.ifsc.edu.firebaseaula;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.security.Principal;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    EditText editTextLogin;
    EditText editTextSenha;
    Button logar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Login");

        editTextLogin = findViewById(R.id.txt_email);
        editTextSenha = findViewById(R.id.txt_senha);
        logar = findViewById(R.id.btn_login);


    }

    public void login(View view){

        String login = editTextLogin.getText().toString();
        String senha = editTextSenha.getText().toString();

        if (!login.trim().equals("")){

            mAuth.signInWithEmailAndPassword(login,senha)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){

                        Toast.makeText(getApplicationContext(),"Acesso Permitido",Toast.LENGTH_LONG).show();
                        Intent intentLogin = new Intent(getApplicationContext(),PrincipalActivity.class);
                        startActivity(intentLogin);

                    }else {

                        Toast.makeText(getApplicationContext(),"Acesso Negado",Toast.LENGTH_LONG).show();

                    }
                }
            });

        }

    }

    public void varprap(View view) {

        Intent intentCadastrar = new Intent(getApplicationContext(),CadastrarActivity.class);
        startActivity(intentCadastrar);

    }

    public void recuperar(View view) {

        Intent intentRecuperar = new Intent(getApplicationContext(),RecuperarSenha.class);
        startActivity(intentRecuperar);

    }
}
