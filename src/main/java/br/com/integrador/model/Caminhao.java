package br.com.integrador.model;

import br.com.integrador.exception.HabilitacaoInvalidaException;

public class Caminhao extends Veiculo {

    public Caminhao() {
        this.setCapacidade(3);
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
