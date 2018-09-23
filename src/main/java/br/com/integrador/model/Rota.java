package br.com.integrador.model;


public class Rota {

    private int id;
    private String data;
    private Veiculo veiculo;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    @Override
    public String toString() {
        StringBuilder rota = new StringBuilder();

        rota.append("\nID:              ").append(this.getId());
        rota.append("\nDATA:            ").append(this.getData());
        rota.append("\nVEICULO:         ").append(this.getVeiculo());

        return String.valueOf(rota);
    }
}
