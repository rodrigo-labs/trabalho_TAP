package br.com.integrador.service;

import br.com.integrador.exception.NaoEncontradoException;
import br.com.integrador.model.Motorista;
import br.com.integrador.model.Rota;

import java.util.List;

public interface RotaService {

    void salvar(Rota rota);

    List<Rota> listar();

    List<Rota> listarPor(String data);

    Rota buscarPor(int id) throws NaoEncontradoException;

    Rota buscarPor(Motorista motorista) throws NaoEncontradoException;

    static RotaService getNewInstance() {
        return new RotaServiceMemoria();
    }
}
