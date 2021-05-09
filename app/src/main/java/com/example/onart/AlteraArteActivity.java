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
import android.widget.Toast;

import controller.ConexaoController;

public class AlteraArteActivity extends AppCompatActivity {
    EditText txNovoNome, txNovoValor, txNovaDescricao;
    TextView tvDataPostagem;
    Button btSalvarEdicaoArte, btVoltaArte;
    InformacoesApp infoApp;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_altera_arte);
        txNovoNome = findViewById(R.id.txNovoNome);
        txNovoValor = findViewById(R.id.txNovoValor);
        txNovaDescricao = findViewById(R.id.txNovaDescricao);
        tvDataPostagem = findViewById(R.id.tvDataPostagem);
        btSalvarEdicaoArte = findViewById(R.id.btSalvaEdicaoArte);
        btVoltaArte = findViewById(R.id.btVoltaArte);
        // btSalvarEdicaoArte = View.OnClickListener(btSalvarEdicaoArte);
        // btVoltaArte = View.OnClickListener(btVoltaArte);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        infoApp = (InformacoesApp) getApplicationContext();
    }

}



