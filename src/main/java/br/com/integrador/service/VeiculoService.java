package br.com.integrador.service;

import br.com.integrador.exception.HabilitacaoInvalidaException;
import br.com.integrador.model.Motorista;
import br.com.integrador.model.Veiculo;

import java.util.List;

public interface VeiculoService {

    void salvar(Veiculo veiculo);

    List<Veiculo> listar();

    Veiculo buscarPor(String placa);

    void remover(Veiculo veiculo);

    static VeiculoService getNewInstance() {
        return new VeiculoServiceMemoria();
    }

    void selecionarMotorista(Motorista motorista, Veiculo veiculo) throws HabilitacaoInvalidaException;
}
