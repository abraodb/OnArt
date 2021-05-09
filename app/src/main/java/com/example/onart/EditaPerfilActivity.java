package com.example.onart;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditaPerfilActivity extends AppCompatActivity {
    EditText txAlteraNome, txAlteraSenha, txAlteraEmail, txConfirmaSenha;
    Button btSalvarPerfil, btSair;
    InformacoesApp infoApp;

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
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        infoApp = (InformacoesApp) getApplicationContext();
    }

}
