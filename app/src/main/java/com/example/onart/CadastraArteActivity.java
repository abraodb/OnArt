package com.example.onart;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CadastraArteActivity extends AppCompatActivity {
    EditText txCadastroNomeArte, txCadastroDescricao, txCadastroValor, txCadastroData;
    Button btUploadImagem, btSalvarArte, btSair;
    InformacoesApp infoApp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastra_arte);
        txCadastroNomeArte = findViewById(R.id.txCadastroNomeArte);
        txCadastroDescricao = findViewById(R.id.txCadastroDescricao);
        txCadastroValor = findViewById(R.id.txCadastroValor);
        txCadastroData = findViewById(R.id.txCadastroData);
        btUploadImagem = findViewById(R.id.btUploadImagem);
        btSalvarArte= findViewById(R.id.btSalvarArte);
        btSair = findViewById(R.id.btSair);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        infoApp =  (InformacoesApp) getApplicationContext();


    }

}
