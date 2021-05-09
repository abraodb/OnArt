package com.example.onart;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ArteActivity extends AppCompatActivity {
    ImageView imgView;
    TextView tvNomeArte,tvValorArte,tvDataPostagem, tvDescricaoArte;
    Button btEditaArte, btAlteraArte, btExcluiArte;
    InformacoesApp infoApp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arte);
        imgView  = findViewById(R.id.imgView);
        tvNomeArte = findViewById(R.id.tvNomeArte);
        tvValorArte = findViewById(R.id.tvValorArte);
        tvDataPostagem = findViewById(R.id.tvDataPostagem);
        tvDescricaoArte = findViewById(R.id.tvDescricaoArte);
        btEditaArte= findViewById(R.id.btEditaArte);
        btAlteraArte = findViewById(R.id.btAlteraSenha);
        btExcluiArte = findViewById(R.id.btExcluiArte);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        infoApp =  (InformacoesApp) getApplicationContext();


    }

}
