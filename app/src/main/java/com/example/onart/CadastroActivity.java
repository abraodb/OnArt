package com.example.onart;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CadastroActivity extends AppCompatActivity {
    EditText txCadastroNome, txCadastroEmail, txCadastroSenha, txConfirmaSenha;
    Button btSalvarCadastro, btIrLogin;
    InformacoesApp infoApp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        txCadastroNome = findViewById(R.id.txCadastroNome);
        txCadastroEmail = findViewById(R.id.txCadastroEmail);
        txCadastroSenha = findViewById(R.id.txCadastroSenha);
        txConfirmaSenha = findViewById(R.id.txConfirmaSenha);
        btSalvarCadastro = findViewById(R.id.btSalvarCadastro);
        btIrLogin = findViewById(R.id.btIrLogin);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        infoApp =  (InformacoesApp) getApplicationContext();
    }

}
