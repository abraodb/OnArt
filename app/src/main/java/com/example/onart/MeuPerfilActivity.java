package com.example.onart;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MeuPerfilActivity extends AppCompatActivity {
    TextView txNome, txEmail;
    Button  btEditarPerfil, btAdicionarArte;
    RecyclerView rvPerfilArtes;
    InformacoesApp infoApp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meu_perfil);
        Toolbar toolbar = findViewById(R.id.toolbar);
        txNome = findViewById(R.id.txNome);
        txEmail = findViewById(R.id.txEmail);
        btEditarPerfil = findViewById(R.id.btEditarPerfil);
        btAdicionarArte = findViewById(R.id.btAdicionarArte);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        infoApp =  (InformacoesApp) getApplicationContext();

    }

}
