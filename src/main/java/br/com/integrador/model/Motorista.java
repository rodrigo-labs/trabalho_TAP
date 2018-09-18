package br.com.integrador.model;

import br.com.integrador.exception.HabilitacaoInvalidaException;

public class Motorista {

    private String nome;
    private String endereco;
    private CNH tipoCNH;
    private int numeroCNH;
    private String dataNascimento;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public CNH getTipoCNH() {
        return tipoCNH;
    }

    public void setTipoCNH(CNH tipoCNH) {
        this.tipoCNH = tipoCNH;
    }

    public void setTipoCNH(int tipoCNH) {
        if (tipoCNH == 0) {
            this.tipoCNH = CNH.TIPO_B;
        } else {
            this.tipoCNH = CNH.TIPO_C;
        }
    }

    public int getNumeroCNH() {
        return numeroCNH;
    }

    public void setNumeroCNH(int numeroCNH) {
        this.numeroCNH = numeroCNH;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }


    @Override
    public String toString() {
        StringBuilder motorista = new StringBuilder();

        motorista.append("\nNOME:                   ").append(this.getNome());
        motorista.append("\nENDEREÇO:               ").append(this.getEndereco());
        motorista.append("\nTIPO DA CNH:            ").append(this.getTipoCNH());
        motorista.append("\nNUMERO DA CNH:          ").append(this.getNumeroCNH());
        motorista.append("\nDATA DE NASCIMENTO:     ").append(this.getDataNascimento());

        return String.valueOf(motorista);
    }
}
