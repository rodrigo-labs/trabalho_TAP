package br.com.integrador.service;

import br.com.integrador.model.Motorista;
import br.com.integrador.model.Rota;

import java.util.List;

public interface RotaService {

    void salvar(Rota rota);

    List<Rota> listar();

    List<Rota> listarPor(String data);

    Rota buscarPor(int id);

    Rota buscarPor(Motorista motorista);

    static RotaService getNewInstance() {
        return new RotaServiceMemoria();
    }
}
