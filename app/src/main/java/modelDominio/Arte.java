package modelDominio;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Arte implements Serializable {
    private static final long serialVersionUID = 123456789L;
    private int codarte;
    private String nome;
    private String descricao;
    private Date datapostagem;
    private double valor;
    private byte[] foto;
    private Artista artista;

    public Arte(int codarte, String nome, String descricao, Date datapostagem, double valor, byte[] foto, int codusuario,String nomecompleto) {

        this.codarte = codarte;
        this.nome = nome;
        this.descricao = descricao;
        this.datapostagem = datapostagem;
        this.valor = valor;
        this.foto = foto;
        Artista artista = new Artista(codusuario,nomecompleto);
        this.artista = artista;
    }
    
    public Arte(String nome, String descricao, Date datapostagem, double valor, byte[] foto) {
        this.nome = nome;
        this.descricao = descricao;
        this.datapostagem = datapostagem;
        this.valor = valor;
        this.foto = foto;
    }
    
    public Arte(int codarte, String nome) {
        this.codarte = codarte;
        this.nome = nome;
    }

    public Arte(int codarte) {
        this.codarte = codarte;
    }
    
    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public int getCodarte() {
        return codarte;
    }

    public void setCodarte(int codarte) {
        this.codarte = codarte;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    // Usado para mandar uma String no campo de Data Final na Table
    public String getDataPostagemFormat() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(datapostagem);
    }
    
    // Usado para enviar ao banco a Data no formato DATE
    public Date getDataPostagem() {
        return datapostagem;
    }

    public void getDataPostagem(Date datapostagem) {
        this.datapostagem = datapostagem;
    }
    
    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    public String getValorString(){
        String pattern = "###,##0.00";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        return decimalFormat.format(valor);
    }
    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return "Arte{" + "codarte=" + codarte + ", nome=" + nome + ", descricao=" + descricao + ", datapostagem=" + datapostagem + ", valor=" + valor + ", foto=" + foto + '}';
    } 
}
