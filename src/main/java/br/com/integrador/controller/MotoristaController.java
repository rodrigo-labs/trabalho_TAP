package br.com.integrador.controller;

import br.com.integrador.exception.NaoEncontradoException;
import br.com.integrador.model.Motorista;
import br.com.integrador.service.MotoristaService;
import br.com.integrador.view.MotoristaView;

import javax.swing.*;
import java.util.List;

public class MotoristaController {

    private MotoristaView view = new MotoristaView();
    private MotoristaService service = MotoristaService.getNewInstance();
    private Motorista motorista;

    public void incluir() {
        motorista  = view.incluir();
        service.salvar(motorista);
    }

    public void excluir() {
        try {
            String nome = view.excluir();
            motorista = service.buscarPor(nome);
            service.remover(motorista);
        } catch (NaoEncontradoException e) {
            JOptionPane.showMessageDialog(null, "" + e.getMessage());
        }
    }

    public void consultar() {
        try {
            String nome = view.consultar();
            motorista = service.buscarPor(nome);
            view.mostrar(motorista);
        } catch (NaoEncontradoException e) {
            JOptionPane.showMessageDialog(null, "" + e.getMessage());
        }
    }

    public void listar() {
         List<Motorista> motoristaList = service.listar();
        if (motoristaList.isEmpty()) {
            JOptionPane.showMessageDialog(null, "NENHUM MOTORISTA CADASTRADO");
        } else {
            view.mostrarTodos(motoristaList);
        }
    }
}
