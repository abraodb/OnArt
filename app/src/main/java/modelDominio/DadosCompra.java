package modelDominio;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DadosCompra implements Serializable{
    private static final long serialVersionUID = 123456789L;
    private int coddadoscompra;
    private String cpf;
    private String numerocartao;
    private Date datacompra;
    private Date datanascimento;
    private Comprador comprador;

    public DadosCompra(int coddadoscompra, String cpf, String numerocartao, Date datacompra, Date datanascimento, int codcomprador, String nomecompleto) {
        this.coddadoscompra = coddadoscompra;
        this.cpf = cpf;
        this.numerocartao = numerocartao;
        this.datacompra = datacompra;
        this.datanascimento = datanascimento;

        // Recebido de outra classe //
        Comprador compradorr = new Comprador(codcomprador, nomecompleto);
        this.comprador = compradorr;
    }

    public DadosCompra(String cpf, String numerocartao, Date datacompra, Date datanascimento, int codcomprador, String nomecompleto) {
        this.cpf = cpf;
        this.numerocartao = numerocartao;
        this.datacompra = datacompra;
        this.datanascimento = datanascimento;
        
        // Recebido de outra classe //
        Comprador compradorr = new Comprador(codcomprador, nomecompleto);
        this.comprador = compradorr;
    }    
    
    public int getCoddadoscompra() {
        return coddadoscompra;
    }

    public void setCoddadoscompra(int coddadoscompra) {
        this.coddadoscompra = coddadoscompra;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNumerocartao() {
        return numerocartao;
    }

    public void setNumerocartao(String numerocartao) {
        this.numerocartao = numerocartao;
    }

    // Usado para mandar uma String no campo de Data Inicial na Table
    public String getDataCompraFormat() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(datacompra);
    }
    
    // Usado para enviar ao banco a Data no formato DATE
    public Date getDataCompraDate() {
        return datacompra;
    }

    public void setDataInicial(Date datacompra) {
        this.datacompra = datacompra;
    }

    // Usado para mandar uma String no campo de Data Inicial na Table
    public String getDataNascimentoFormat() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(datanascimento);
    }
    
    // Usado para enviar ao banco a Data no formato DATE
    public Date getDataNascimentoDate() {
        return datanascimento;
    }

    public void setDataNascimento(Date datanascimento) {
        this.datanascimento = datanascimento;
    }    

    public Comprador getComprador() {
        return comprador;
    }

    public void setComprador(Comprador comprador) {
        this.comprador = comprador;
    }


    @Override
    public String toString() {
        return "\n CompraDados: " 
                + "\nCod Dados Compra" + coddadoscompra 
                + "\nCPF: = " + cpf 
                + "\nNúmero do Cartão = " + numerocartao 
                + "\nData da Compra = " + datacompra 
                + "\nData de Nasicmento = " + datanascimento 
                + "\nComprador = " + comprador;
    }
}
