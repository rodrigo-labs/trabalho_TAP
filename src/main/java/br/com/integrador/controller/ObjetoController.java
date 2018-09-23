package br.com.integrador.controller;

import br.com.integrador.exception.NaoEncontradoException;
import br.com.integrador.model.Objeto;
import br.com.integrador.service.ObjetoService;
import br.com.integrador.view.ObjetoView;

import javax.swing.*;
import java.util.List;

public class ObjetoController {

    private ObjetoView view = new ObjetoView();
    private ObjetoService service = ObjetoService.getNewInstance();
    private Objeto objeto;

    public void incluir() {
        objeto = view.incluir();
        service.salvar(objeto);
    }

    public void excluir() {
        try {
            String codigoVerificador = view.excluir();
            objeto = service.buscarPor(codigoVerificador);
            service.remover(objeto);
        } catch (NaoEncontradoException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void confirmarEntrega() {
        try {
            String codigoVerificador = view.confirmarEntrega();
            service.ConfirmarEntregaPor(codigoVerificador);
        } catch (NaoEncontradoException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void mostrar() {
        try {
            String codigoVerificador = view.consultar();
            objeto = service.buscarPor(codigoVerificador);
            view.mostrar(objeto);
        } catch (NaoEncontradoException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void listar() {
        List<Objeto> objetoList = service.listar();

        if (objetoList.isEmpty()) {
            JOptionPane.showMessageDialog(null, "NENHUM OBJETO CADASTRADO");
        } else {
            view.mostrarTodos(objetoList);
        }
    }

    public void listarEntregues() {

    }
}
