package controller;

import com.example.onart.InformacoesApp;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import modelDominio.Arte;
import modelDominio.Artista;
import modelDominio.DadosCompra;
import modelDominio.Usuario;

public class ConexaoController {
    InformacoesApp infoApp;



    public void Conectar(){
        try{
            // sobrescrevendo politicas de restrição
            //StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            //StrictMode.setThreadPolicy(policy);
            System.out.println("Conectando no servidor...");
            infoApp.socket = new Socket("10.0.2.2", 12345);
            infoApp.out = new ObjectOutputStream(infoApp.socket.getOutputStream());
            infoApp.in = new ObjectInputStream(infoApp.socket.getInputStream());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public ConexaoController(InformacoesApp infoApp) {
        this.infoApp = infoApp;
    }
    // ------------> USUARIO <----------- //

    public Usuario efetuarLogin(Usuario usr){
        String msg;
        try{
            infoApp.out.writeObject("UsuarioEfetuarLogin");
            msg = (String) infoApp.in.readObject(); // lendo ok
            infoApp.out.writeObject(usr); // escrevendo o filtro
            Usuario usrselecionado = (Usuario) infoApp.in.readObject();
            return usrselecionado;
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public Boolean usuarioInserir(Usuario usr){
        String msg = "";
        try{
            infoApp.out.writeObject("UsuarioInserir");
            msg = (String) infoApp.in.readObject(); // lendo ok
            infoApp.out.writeObject(usr);
            msg = (String) infoApp.in.readObject(); // lendo ok
            if (msg.equals("ok")){
                return true;
            }else{
                return false;
            }
        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
    }



    public Boolean usuarioAlterar(Usuario usr){
        String msg = "";
        try{
            infoApp.out.writeObject("UsuarioAlterar");
            msg = (String) infoApp.in.readObject(); // lendo ok
            infoApp.out.writeObject(usr); // escrevendo o usuário
            msg = (String) infoApp.in.readObject(); // lendo ok
            if (msg.equals("ok")){
                return true;
            }else{
                return false;
            }
        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    public ArrayList<Usuario> usuarioLista(){
        String msg;
        try{
            infoApp.out.writeObject("UsuarioLista");
            msg = (String) infoApp.in.readObject(); // lendo ok
            ArrayList<Usuario> listausr = (ArrayList<Usuario>) infoApp.in.readObject();
            return listausr;
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    // --------- > ARTISTA < ---------//
    public ArrayList<Artista> artistaListaNome(String nome){
        String msg;
        try{
            infoApp.out.writeObject("ArtistaListaNome");
            msg = (String) infoApp.in.readObject(); // lendo ok
            infoApp.out.writeObject(nome); // escrevendo o filtro
            ArrayList<Artista> listaartista = (ArrayList<Artista>) infoApp.in.readObject();
            return listaartista;
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
    // ----------> ARTE <---------- //


    public ArrayList<Arte> arteLista(){
        String msg;
        try{
            infoApp.out.writeObject("ArteLista");
            msg = (String) infoApp.in.readObject(); // lendo ok
            ArrayList<Arte> listaarte = (ArrayList<Arte>) infoApp.in.readObject();
            return listaarte;
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public ArrayList<Arte> arteListaNome(String nome){
        String msg;
        try{
            infoApp.out.writeObject("ArteListaNome");
            msg = (String) infoApp.in.readObject(); // lendo ok
            infoApp.out.writeObject(nome); // escrevendo o filtro
            ArrayList<Arte> listaarte = (ArrayList<Arte>) infoApp.in.readObject();
            return listaarte;
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    // ----------> COMPRA DADOS <---------- //
    public Boolean compradadosInserir(DadosCompra cmpdds){
        String msg = "";
        try{
            infoApp.out.writeObject("compradadosInserir");
            msg = (String) infoApp.in.readObject(); // lendo ok
            infoApp.out.writeObject(cmpdds); // escrevendo o usuário
            msg = (String) infoApp.in.readObject(); // lendo ok
            if (msg.equals("ok")){
                return true;
            }else{
                return false;
            }
        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
    }
    //=========================== FIM ==================
    public void fim(){
        String msg;
        try{
            infoApp.out.writeObject("fim");
            infoApp.in.close();
            infoApp.out.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
