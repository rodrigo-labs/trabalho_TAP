package br.com.integrador.model;

import br.com.integrador.exception.CargaCompletaException;
import br.com.integrador.exception.HabilitacaoInvalidaException;

public abstract class Veiculo {

    private String marca;
    private String modelo;
    private String ano;
    private String placa;
    private int capacidade;
    private int carga;
    private Motorista motorista;


    public Veiculo() {
        this.carga = 0;
    }

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

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public int getCarga() {
        return carga;
    }

    public void setCarga() throws CargaCompletaException {
        if (this.carga < this.capacidade) {
            this.carga++;
        } else {
            throw new CargaCompletaException("CARGA COMPLETA");
        }
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public abstract void setMotorista(Motorista motorista) throws HabilitacaoInvalidaException;

    @Override
    public String toString() {
        StringBuilder veiculo = new StringBuilder();

        veiculo.append("\nMARCA:             ").append(this.getMarca());
        veiculo.append("\nMODELO:            ").append(this.getModelo());
        veiculo.append("\nANO:               ").append(this.getAno());
        veiculo.append("\nPLACA:             ").append(this.getPlaca());
        veiculo.append("\nCAPACIDADE:        ").append(this.getCapacidade());
        veiculo.append("\nCARGA:             ").append(this.getCarga());
        if (this.getMotorista() != null) {
            veiculo.append("\nMOTORISTA:         ").append(this.getMotorista());
        } else {
            veiculo.append("\nMOTORISTA:           VEICULO SEM MOTORISTA");
        }

        return String.valueOf(veiculo);
    }
}
