package br.com.integrador.model;

import br.com.integrador.exception.HabilitacaoInvalidaException;

public class Van extends Veiculo {

    public Van() {
        this.setCapacidade(1);
    }

    @Override
    public void setMotorista(Motorista motorista) throws HabilitacaoInvalidaException {
        if (motorista.getTipoCNH().equals(CNH.TIPO_B) || motorista.getTipoCNH().equals(CNH.TIPO_C)) {
            setMotorista(motorista);
        } else {
            throw new HabilitacaoInvalidaException("HABILITAÇÃO INVÁLIDA");
        }
    }
}
