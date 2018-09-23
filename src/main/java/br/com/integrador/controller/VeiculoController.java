package br.com.integrador.controller;

import br.com.integrador.exception.HabilitacaoInvalidaException;
import br.com.integrador.exception.NaoEncontradoException;
import br.com.integrador.model.Motorista;
import br.com.integrador.model.Veiculo;
import br.com.integrador.service.MotoristaService;
import br.com.integrador.service.VeiculoService;
import br.com.integrador.view.VeiculoView;

import javax.swing.JOptionPane;
import java.util.List;

public class VeiculoController {

    private VeiculoView view = new VeiculoView();
    private VeiculoService service = VeiculoService.getNewInstance();
    private MotoristaService motoristaService = MotoristaService.getNewInstance();
    private Veiculo veiculo;


    public void incluir() {
        veiculo  = view.incluir();
        service.salvar(veiculo);
    }

    public void excluir() {
        try {
            String placa = view.excluir();
            veiculo = service.buscarPor(placa);
            service.remover(veiculo);
        } catch (NaoEncontradoException e) {
            JOptionPane.showMessageDialog(null, " " + e.getMessage());
        }
    }

    public void adicionarMotorista() {
        try {
            String placa = view.consultar();
            veiculo = service.buscarPor(placa);

            String nome = view.adicionarMotorista();
            Motorista motorista = motoristaService.buscarPor(nome);
            service.selecionarMotorista(motorista, veiculo);
        } catch (NaoEncontradoException | HabilitacaoInvalidaException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void consultar() {
        try {
            String placa = view.consultar();
            veiculo = service.buscarPor(placa);
            view.mostrar(veiculo);
        } catch (NaoEncontradoException e) {
            JOptionPane.showMessageDialog(null, " " + e.getMessage());
        }
    }

    public void listar() {
        List<Veiculo> veiculoList = service.listar();
        if (veiculoList.isEmpty()) {
            JOptionPane.showMessageDialog(null, "NENHUM VEICULO CADASTRADO");
        } else {
            view.mostrarTodos(veiculoList);
        }
    }
}
