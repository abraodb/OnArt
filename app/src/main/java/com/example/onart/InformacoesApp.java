package com.example.onart;

import android.app.Application;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import modelDominio.Arte;
import modelDominio.Artista;
import modelDominio.Usuario;

public class InformacoesApp extends Application {

    public Socket socket;
    public ObjectInputStream in;
    public ObjectOutputStream out;

    public Usuario user;
    public Arte arte;
    public Artista artista;


    @Override
    public void onCreate() {
        super.onCreate();
    }
}
