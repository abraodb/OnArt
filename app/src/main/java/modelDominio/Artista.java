package modelDominio;

import java.io.Serializable;

public class Artista extends Usuario implements Serializable {

    private static final long serialVersionUID = 123456789L;

    public Artista(int codusuario, String nomecompleto, String email, String senha) {
        super(codusuario, nomecompleto, senha, email);
    }
    
    // Cadastro do Artista //
    public Artista(String nomecompleto, String email) {
        super(nomecompleto, email, senha);
    }
    
    // Lista //
    public Artista(int codusuario, String nomecompleto) {
        super(codusuario, nomecompleto);
    }   

    public Artista(int codusuario) {
       super(codusuario);
    }
    
    @Override
    public String toString() {
        return super.toString() + "Artista: ";
    }
}
