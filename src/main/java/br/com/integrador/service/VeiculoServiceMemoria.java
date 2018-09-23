package br.com.integrador.service;

import br.com.integrador.exception.HabilitacaoInvalidaException;
import br.com.integrador.exception.NaoEncontradoException;
import br.com.integrador.model.Motorista;
import br.com.integrador.model.Veiculo;

import java.util.ArrayList;
import java.util.List;

public class VeiculoServiceMemoria implements VeiculoService {

    private static List<Veiculo> veiculoList = new ArrayList<>();


    public static List<Veiculo> getVeiculoList() {
        return veiculoList;
    }

    @Override
    public void salvar(Veiculo veiculo) {
        veiculoList.add(veiculo);
    }

    @Override
    public List<Veiculo> listar() {
        return veiculoList;
    }

    @Override
    public Veiculo buscarPor(String placa) throws NaoEncontradoException {
        for (Veiculo veiculo : veiculoList) {
            if (veiculo.getPlaca().equals(placa)) {
                return veiculo;
            }
        }

        throw new NaoEncontradoException("VEICULO NÃO ENCONTRADO");
    }

    @Override
    public void remover(Veiculo veiculo) {
        veiculoList.remove(veiculo);
    }

    @Override
    public void selecionarMotorista(Motorista motorista, Veiculo veiculo) throws HabilitacaoInvalidaException {
        for (Veiculo veiculoAux : veiculoList) {
            if (veiculoAux.equals(veiculo)) {
                veiculoAux.setMotorista(motorista);
            }
        }
    }
}
