package com.example.onart;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import modelDominio.Usuario;

public class EditaPerfilActivity extends AppCompatActivity {
    EditText txAlteraNome, txAlteraSenha, txAlteraEmail, txConfirmaSenha;
    Button btSalvarPerfil, btSair;
    InformacoesApp infoApp;
    Usuario usuarioAlterar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edita_perfil);
        txAlteraNome = findViewById(R.id.txAlteraNome);
        txAlteraSenha = findViewById(R.id.txAlteraSenha);
        txAlteraEmail = findViewById(R.id.txAlteraEmail);
        txConfirmaSenha = findViewById(R.id.txConfirmaSenha);
        btSalvarPerfil = findViewById(R.id.btSalvarPerfil);
        btSair = findViewById(R.id.btSair);
        btSalvarPerfil.setOnClickListener(clickSalvar);
        btSair.setOnClickListener(clickSair);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        infoApp = (InformacoesApp) getApplicationContext();
    }


    View.OnClickListener clickSalvar = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String nome = txAlteraNome.getText().toString();
            String email = txAlteraEmail.getText().toString();
            String senha = txAlteraSenha.getText().toString();
            String confirmarSenha = txConfirmaSenha.getText().toString();

            if(nome.equals("")){
                txAlteraNome.setError("Informe o nome!");
                txAlteraNome.requestFocus();
            } else if(email.equals("")){
                txAlteraEmail.setError("Informe o e-mail!");
                txAlteraEmail.requestFocus();
            } else if (senha.equals("")){
                txAlteraSenha.setError("Informe a senha!");
                txAlteraSenha.requestFocus();
            } else if (confirmarSenha.equals("")){
                txConfirmaSenha.setError("Informe a confirmação da senha!");
                txConfirmaSenha.requestFocus();
            } else {
                if (!confirmarSenha.equals(senha)) {
                    txAlteraSenha.setError("As senhas não coincidem");
                    txConfirmaSenha.setError("As senhas não coincidem");
                    txConfirmaSenha.requestFocus();

                } else {

                      usuarioAlterar  = new Usuario(nome, email, senha);


                }
            }

            }
    };

    View.OnClickListener clickSair = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        }
    };

}
