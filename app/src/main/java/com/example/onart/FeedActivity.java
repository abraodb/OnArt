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

public class FeedActivity extends AppCompatActivity {
    TextView txPesquisar;
    Button btMeuPerfil;
    RecyclerView rvFeedArte;
    InformacoesApp infoApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        txPesquisar = findViewById(R.id.txPesquisar);
        btMeuPerfil = findViewById(R.id.btMeuPerfil);
        setContentView(R.layout.activity_feed);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        infoApp =  (InformacoesApp) getApplicationContext();
    }

}
