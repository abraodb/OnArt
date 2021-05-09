package modelDominio;

import java.util.Date;

public class ArteCompra {
    private int codartecompra;
    private Arte arte;
    private DadosCompra dadoscompra;
    
                      // Arte //  
    public ArteCompra(int codartecompra, int codarte, String nome, String descricao, Date datapostagem, Double valor,  byte[] foto, 
    /* Comprador */   int codusuario, int codcomprador, String nomecompleto,
    /* Dados Compra */int coddadoscompra, String cpf, String numerocartao, Date datacompra, Date datanascimento){      
        
        this.codartecompra = codartecompra;
        
        Arte artee = new Arte(codarte,nome,descricao,datapostagem,valor,foto,codusuario,nomecompleto);
        this.arte = artee;
        
        DadosCompra dadoscompraa = new DadosCompra(coddadoscompra, cpf, numerocartao, datacompra, datanascimento, codcomprador,nomecompleto);
        this.dadoscompra = dadoscompraa;
    }

    public int getCodartecompra() {
        return codartecompra;
    }

    public void setCodartecompra(int codartecompra) {
        this.codartecompra = codartecompra;
    }

    public Arte getArte() {
        return arte;
    }

    public void setArte(Arte arte) {
        this.arte = arte;
    }

    public DadosCompra getDadoscompra() {
        return dadoscompra;
    }

    public void setDadoscompra(DadosCompra dadoscompra) {
        this.dadoscompra = dadoscompra;
    }

    @Override
    public String toString() {
        return "\nArteCompra: " 
                + "\n codartecompra = " + codartecompra 
                + "\n Arte = " + arte 
                + "\n dadoscompra = " + dadoscompra;
    }
    

    
    
    
}
