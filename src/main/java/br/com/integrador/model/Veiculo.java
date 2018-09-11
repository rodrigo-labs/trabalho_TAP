package br.com.integrador.model;

public abstract class Veiculo {

    private String marca;
    private String modelo;
    private String ano;
    private String placa;
    private int capacidade;


    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getCapacidade() {
        return capacidade;
    }

    @Override
    public String toString() {
        StringBuilder veiculo = new StringBuilder();

        veiculo.append("\nMARCA:             ").append(this.getMarca());
        veiculo.append("\nMODELO:            ").append(this.getModelo());
        veiculo.append("\nANO:               ").append(this.getAno());
        veiculo.append("\nPLACA:             ").append(this.getPlaca());

        return String.valueOf(veiculo);
    }
}
