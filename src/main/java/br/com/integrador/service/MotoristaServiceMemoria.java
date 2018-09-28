package br.com.integrador.service;


import br.com.integrador.exception.NaoEncontradoException;
import br.com.integrador.model.Motorista;

import java.util.ArrayList;
import java.util.List;

public class MotoristaServiceMemoria implements MotoristaService {

    private static List<Motorista> motoristaList = new ArrayList<>();

    @Override
    public void salvar(Motorista motorista) {
        motoristaList.add(motorista);
    }

    @Override
    public List<Motorista> listar() {
        return motoristaList;
    }

    @Override
    public Motorista buscarPor(String nome) throws NaoEncontradoException {
        for (Motorista motorista : motoristaList) {
            if (motorista.getNome().equals(nome)) {
                return motorista;
            }
        }

        throw new NaoEncontradoException("MOTORISTA NÃO ENCONTRADO");
    }

    @Override
    public void remover(Motorista motorista) {
        motoristaList.remove(motorista);
    }

    public static List<Motorista> getMotoristaList() {
        return motoristaList;
    }

    public static void setMotoristaList(List<Motorista> motoristaList) {
        MotoristaServiceMemoria.motoristaList = motoristaList;
    }
}
