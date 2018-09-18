package br.com.integrador.model;

import br.com.integrador.exception.HabilitacaoInvalidaException;

public class Carreta extends Veiculo {

    public Carreta() {
        this.setCapacidade(10);
    }

    @Override
    public void setMotorista(Motorista motorista) throws HabilitacaoInvalidaException {
        if (motorista.getTipoCNH().equals(CNH.TIPO_C)) {
            setMotorista(motorista);
        } else {
            throw new HabilitacaoInvalidaException("HABILITAÇÃO INVÁLIDA");
        }
    }
}
