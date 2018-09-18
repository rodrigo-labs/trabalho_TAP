package br.com.integrador.service;

import br.com.integrador.exception.HabilitacaoInvalidaException;
import br.com.integrador.model.Motorista;
import br.com.integrador.model.Veiculo;

import java.util.ArrayList;
import java.util.List;

public class VeiculoServiceMemoria implements VeiculoService {

    private static List<Veiculo> veiculoList = new ArrayList<>();

    @Override
    public void salvar(Veiculo veiculo) {
        veiculoList.add(veiculo);
    }

    @Override
    public List<Veiculo> listar() {
        return veiculoList;
    }

    @Override
    public Veiculo buscarPor(String placa) {
        for (Veiculo veiculo : veiculoList) {
            if (veiculo.getPlaca().equals(placa)) {
                return veiculo;
            }
        }

        return null;
    }

    @Override
    public void remover(Veiculo veiculo) {
        veiculoList.remove(veiculo);
    }

    @Override
    public void selecionarMotorista(Motorista motorista, Veiculo veiculo) throws HabilitacaoInvalidaException {
        for (Veiculo veiculoAux : veiculoList) {
            if (veiculo.equals(veiculoAux)) {
                veiculoAux.setMotorista(motorista);
            }
        }
    }
}
