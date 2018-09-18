package br.com.integrador.model;

public class Objeto {

    private String nomeRemetente;
    private String enderecoRemetente;
    private String nomeDestinatario;
    private String enderecoDestinatario;
    private String dataDeposito;
    private Float peso;
    private String codigoLocalizador;
    private ObjetoSituacao situacao;


    public String getNomeRemetente() {
        return nomeRemetente;
    }

    public void setNomeRemetente(String nomeRemetente) {
        this.nomeRemetente = nomeRemetente;
    }

    public String getEnderecoRemetente() {
        return enderecoRemetente;
    }

    public void setEnderecoRemetente(String enderecoRemetente) {
        this.enderecoRemetente = enderecoRemetente;
    }

    public String getNomeDestinatario() {
        return nomeDestinatario;
    }

    public void setNomeDestinatario(String nomeDestinatario) {
        this.nomeDestinatario = nomeDestinatario;
    }

    public String getEnderecoDestinatario() {
        return enderecoDestinatario;
    }

    public void setEnderecoDestinatario(String enderecoDestinatario) {
        this.enderecoDestinatario = enderecoDestinatario;
    }

    public String getDataDeposito() {
        return dataDeposito;
    }

    public void setDataDeposito(String dataDeposito) {
        this.dataDeposito = dataDeposito;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public String getCodigoLocalizador() {
        return codigoLocalizador;
    }

    public void setCodigoLocalizador(String codigoLocalizador) {
        this.codigoLocalizador = codigoLocalizador;
    }

    public ObjetoSituacao getSituacao() {
        return situacao;
    }

    public void setSituacao(ObjetoSituacao situacao) {
        this.situacao = situacao;
    }

    @Override
    public String toString() {
        StringBuilder objeto = new StringBuilder();

        objeto.append("\nNome do remetente:         ").append(this.getNomeRemetente());
        objeto.append("\nEndereço do remetente:     ").append(this.getEnderecoRemetente());
        objeto.append("\nNome do Destinatário:      ").append(this.getNomeDestinatario());
        objeto.append("\nEndereço do Destinatário:  ").append(this.getEnderecoDestinatario());
        objeto.append("\nData do Depósito:          ").append(this.getDataDeposito());
        objeto.append("\nPeso:                      ").append(this.getPeso());
        objeto.append("\nCódigo Localizador:        ").append(this.getCodigoLocalizador());
        objeto.append("\nObjetoSituacao do objeto:          ").append(this.getSituacao());

        return String.valueOf(objeto);
    }
}
