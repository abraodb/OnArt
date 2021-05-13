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
import android.widget.Toast;

import controller.ConexaoController;
import modelDominio.Artista;
import modelDominio.Usuario;

public class CadastroActivity extends AppCompatActivity {
    EditText txCadastroNome, txCadastroEmail, txCadastroSenha, txConfirmaSenha;
    Button btSalvarCadastro, btIrLogin;
    InformacoesApp infoApp;
    Usuario usuarioNovo;
    //Artista artistaCadastro, artistaSelecionado;



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
        btSalvarCadastro.setOnClickListener(clickCadastrar);
        btIrLogin.setOnClickListener(clickTelaLogin);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        infoApp = (InformacoesApp) getApplicationContext();
    }
        View.OnClickListener clickCadastrar = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String nome = txCadastroNome.getText().toString();
                String email = txCadastroEmail.getText().toString();
                String senha = txCadastroSenha.getText().toString();
                String confirmarSenha = txConfirmaSenha.getText().toString();

                if(nome.equals("")){
                    txCadastroNome.setError("Informe o nome!");
                    txCadastroNome.requestFocus();
                } else if(email.equals("")){
                    txCadastroEmail.setError("Informe o e-mail!");
                    txCadastroEmail.requestFocus();
                } else if (senha.equals("")){
                    txCadastroSenha.setError("Informe a senha!");
                    txCadastroSenha.requestFocus();
                } else if (confirmarSenha.equals("")){
                    txConfirmaSenha.setError("Informe a confirmação da senha!");
                    txConfirmaSenha.requestFocus();
                } else {
                    if (!confirmarSenha.equals(senha)) {
                        txCadastroSenha.setError("As senhas não coincidem");
                        txConfirmaSenha.setError("As senhas não coincidem");
                        txConfirmaSenha.requestFocus();

                } else {

                        usuarioNovo = new Usuario(nome, email, senha);
                        Thread thread = new Thread(){
                            @Override
                            public void run() {
                                ConexaoController ccont = new ConexaoController(infoApp);
                                boolean ok = ccont.usuarioInserir(usuarioNovo);
                                if(ok){
                                    Intent it = new Intent(CadastroActivity.this, FeedActivity.class);
                                    it.putExtra("Usuario", usuarioNovo);
                                    startActivity(it);
                                } else {
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            Toast.makeText(CadastroActivity.this, "Cliente não inserido!", Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                }
                            }
                        };thread.start();
                    }
                }
            }
        };

    View.OnClickListener clickTelaLogin = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            Intent it = new Intent(CadastroActivity.this, MainActivity.class);
            startActivity(it);
        }

    };
}
