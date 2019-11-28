package br.ifsc.edu.firebaseaula;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class CadastrarActivity extends AppCompatActivity {

    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    EditText editTextLoginCadastrar;
    EditText editTextSenhaCadastrar;
    Button cadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar2);

        editTextLoginCadastrar = findViewById(R.id.txt_loginCadastrar);
        editTextSenhaCadastrar = findViewById(R.id.txt_senhaCadastrar);
        cadastrar = findViewById(R.id.btn_cadastrar);

    }

    public void cadastrar(View view) {

        if (!editTextLoginCadastrar.getText().toString().trim().equals("")){
            mAuth.createUserWithEmailAndPassword(
              editTextLoginCadastrar.getText().toString(),
              editTextSenhaCadastrar.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if (task.isSuccessful()){

                        Toast.makeText(getApplicationContext(),"Conta Cadastrado com Sucesso",Toast.LENGTH_LONG).show();
                        Intent intentCadastrado = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intentCadastrado);

                    }else {

                        Toast.makeText(getApplicationContext(),"Falha ao Cadastrar Conta",Toast.LENGTH_LONG).show();

                    }
                }
            });
        }

    }
}
