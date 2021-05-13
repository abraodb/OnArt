package com.example.onart;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import controller.ConexaoController;
import modelDominio.Usuario;

public class MainActivity extends AppCompatActivity {
    Button btEntrar, btRecupSenha, btTelaCadastro;
    EditText txLoginEmail, txLoginSenha;
    InformacoesApp infoApp;
    Usuario usr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btEntrar = findViewById(R.id.btEntrar);
        btRecupSenha = findViewById(R.id.btRecupSenha);
        btTelaCadastro = findViewById(R.id.btTelaCadastro);
        btEntrar.setOnClickListener(clickEntrar);
        btRecupSenha.setOnClickListener(clickRecupSenha);
        btTelaCadastro.setOnClickListener(clickCadastro);
        txLoginEmail = findViewById(R.id.txLoginEmail);
        txLoginSenha = findViewById(R.id.txLoginSenha);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        infoApp = (InformacoesApp) getApplicationContext();

        Thread t = new Thread() {
            @Override
            public void run() {
                ConexaoController ccont = new ConexaoController(infoApp);
                ccont.Conectar();
            }
        };
        t.start();
    }

        View.OnClickListener clickEntrar = (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread thread = new Thread() {
                    @Override
                    public void run() {
                        ConexaoController ccont = new ConexaoController(infoApp);
                        Usuario usr = new Usuario(txLoginEmail.getText().toString(), txLoginSenha.getText().toString());
                        infoApp.user = ccont.efetuarLogin(usr);
                        if (infoApp.user != null) {
                            Intent it = new Intent(getApplicationContext(), FeedActivity.class);
                            startActivity(it);
                        } else {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(MainActivity.this, "Usuário ou senha inválida!", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }

                    }
                };
                thread.start();
            }
  });


    View.OnClickListener clickCadastro = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent it = new Intent(MainActivity.this, CadastroActivity.class);
            startActivity(it);
        }
    };

    View.OnClickListener clickRecupSenha = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent it = new Intent(MainActivity.this, AlteraSenhaActivity.class);
            startActivity(it);
        }
    };



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
