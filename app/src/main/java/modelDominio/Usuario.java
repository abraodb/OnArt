package modelDominio;

import java.io.Serializable;
import java.util.Date;

public class Usuario implements Serializable{
    private static final long serialVersionUID = 123456789L; 
    private int codusuario ;
    private String nomecompleto;
    private String email;
    private String senha;

    //  CONSTRUTORES //
    
    public Usuario(int codusuario, String nomecompleto, String email, String senha) {
        this.codusuario = codusuario;
        this.nomecompleto = nomecompleto;
        this.email = email;
        this.senha = senha;
    }
    
    // -----> LOGIN E CADASTRO <----- //
    // Cadastro de Usuário //
    public Usuario(String nomecompleto, String email, String senha) {
        this.nomecompleto = nomecompleto;
        this.email = email;
        this.senha = senha;
    }
        
    // Login //
   public Usuario(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }
   
    // ------> LISTAS <------ //

    public Usuario(int codusuario, String nomecompleto) {
        this.codusuario = codusuario;
        this.nomecompleto = nomecompleto;    
    }
    
    public Usuario(int codusuario) {
        this.codusuario = codusuario;  
    }    
    
    // GETTERS E SETTERS //
    
    public int getCodusuario() {
        return codusuario;
    }

    public void setCodusuario(int codusuario) {
        this.codusuario = codusuario;
    }

    public String getNomecompleto() {
        return nomecompleto;
    }

    public void setNomecompleto(String nomecompleto) {
        this.nomecompleto = nomecompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    @Override
    public String toString() {
        return "\nUsuario: " 
                + "\n codusuario = " + codusuario 
                + "\n nomecompleto = " + nomecompleto 
                + "\n email = " + email 
                + "\n senha = " + senha;
    }
}
