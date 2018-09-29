package br.com.integrador.model;

import java.io.Serializable;

public class Objeto  implements Serializable {

    private String nomeRemetente;
    private String enderecoRemetente;
    private String nomeDestinatario;
    private String enderecoDestinatario;
    private String dataDeposito;
    private Float peso;
    private String codigoLocalizador;
    private Situacao situacao;


    public Objeto() {
    }

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

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Objeto objeto = (Objeto) o;

        return codigoLocalizador != null ? codigoLocalizador.equals(objeto.codigoLocalizador) : objeto.codigoLocalizador == null;
    }

    @Override
    public int hashCode() {
        int result = nomeRemetente != null ? nomeRemetente.hashCode() : 0;
        result = 31 * result + (enderecoRemetente != null ? enderecoRemetente.hashCode() : 0);
        result = 31 * result + (nomeDestinatario != null ? nomeDestinatario.hashCode() : 0);
        result = 31 * result + (enderecoDestinatario != null ? enderecoDestinatario.hashCode() : 0);
        result = 31 * result + (dataDeposito != null ? dataDeposito.hashCode() : 0);
        result = 31 * result + (peso != null ? peso.hashCode() : 0);
        return result;
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
        objeto.append("\nSituacao do objeto:        ").append(this.getSituacao());

        return String.valueOf(objeto);
    }
}
