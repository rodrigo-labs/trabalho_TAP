package br.com.integrador.service;

import br.com.integrador.model.Motorista;
import br.com.integrador.model.Rota;

import java.util.ArrayList;
import java.util.List;

public class RotaServiceMemoria implements RotaService {

    private static List<Rota> rotaList = new ArrayList<>();

    @Override
    public void salvar(Rota rota) {
        rotaList.add(rota);
    }

    @Override
    public List<Rota> listar() {
        return rotaList;
    }

    @Override
    public List<Rota> listarPor(String data) {
        List<Rota> auxiliarList = new ArrayList<>();

        for (Rota rota : rotaList) {
            if (rota.getData().equalsIgnoreCase(data)) {
                auxiliarList.add(rota);
            }
        }

        return auxiliarList;
    }

    @Override
    public Rota buscarPor(int id) {
        for (Rota rota : rotaList) {
            if (rota.getId() == id) {
                return rota;
            }
        }

        return null;
    }

    @Override
    public Rota buscarPor(Motorista motorista) {
        for (Rota rota : rotaList) {
            if (rota.getVeiculo().getMotorista().equals(motorista)) {
                return rota;
            }
        }

        return null;
    }
}
