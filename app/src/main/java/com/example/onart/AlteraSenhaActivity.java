package com.example.onart;

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

public class AlteraSenhaActivity extends AppCompatActivity {
    EditText txNovaSenha, txConfirmaNovaSenha;
    Button btAlterarSenha, btSair;
    InformacoesApp infoApp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_altera_arte);
            txNovaSenha = findViewById(R.id.txNovaSenha);
            txConfirmaNovaSenha = findViewById(R.id.txConfirmaNovaSenha);
            btAlterarSenha = findViewById(R.id.btAlteraSenha);
            btSair = findViewById(R.id.btSair);
            txNovaSenha = findViewById(R.id.txLoginEmail);
            txConfirmaNovaSenha = findViewById(R.id.txLoginSenha);
            //btAlterarSenha = View.OnClickListener(clickAlteraSenha);
            //btSair = View.OnClickListener(clickSair);
            Toolbar toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);


            infoApp = (InformacoesApp) getApplicationContext();
        }

        View.OnClickListener clickAlteraSenha = new View.OnClickListener(){
        @Override
            public void onClick(View v){
                Thread thread = new Thread() {
                    @Override
                    public void run() {
                        if (txNovaSenha.getText().toString().equals(txConfirmaNovaSenha.getText().toString())) {
                            ConexaoController ccont = new ConexaoController(infoApp);
                            String senhaAntiga = infoApp.user.getSenha();
                            // alterando o objeto
                            infoApp.user.setSenha(txNovaSenha.getText().toString());
                            // enviando o comando de alterar a senha para o Servidor
                            if (ccont.usuarioAlterar(infoApp.user)) {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(AlteraSenhaActivity.this, "Senha alterada com sucesso", Toast.LENGTH_SHORT).show();
                                        finish();
                                    }
                                });
                            } else {
                                infoApp.user.setSenha(senhaAntiga); // voltando senha antiga
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(AlteraSenhaActivity.this, "Não foi possível alterar a senha", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                        } else {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    txNovaSenha.setError("Senhas não estão idênticas");
                                }
                            });
                        }
                    }
                };
                thread.start();
            }
        };

        View.OnClickListener clickSair = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        };


    }