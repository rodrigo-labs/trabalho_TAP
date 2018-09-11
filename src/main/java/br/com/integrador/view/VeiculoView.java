package br.com.integrador.view;

import br.com.integrador.model.Caminhao;
import br.com.integrador.model.Carreta;
import br.com.integrador.model.Van;
import br.com.integrador.model.Veiculo;

import javax.swing.*;
import java.util.List;

public class VeiculoView {

    public char menu() {

        String menu = "SISTEMA DE LOGISTICA\n" +
                "CADASTRO DE VEICULOS\n\n" +
                "1 - INCLUIR\n" +
                "2 - EXCLUIR\n" +
                "3 - CONSULTAR\n" +
                "4 - LISTAR\n" +
                "0 - RETORNAR\n\n" +
                "OPÇÃO: ";

        return JOptionPane.showInputDialog(menu).charAt(0);
    }

    public Veiculo incluir() {
        Veiculo veiculo;
        int opcaoVeiculo;
        String[] options = {"VAN", "CAMINHÃO", "CARRETA"};

        opcaoVeiculo = JOptionPane.showOptionDialog(
                null,
                "Escolha o tipo do veiculo",
                "Veiculos",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );

        if (opcaoVeiculo == 1) {
            veiculo = new Van();
        } else if (opcaoVeiculo == 2) {
            veiculo = new Caminhao();
        } else {
            veiculo = new Carreta();
        }

        veiculo.setMarca(JOptionPane.showInputDialog("Marca"));
        veiculo.setModelo(JOptionPane.showInputDialog("Modelo"));
        veiculo.setAno(JOptionPane.showInputDialog("Ano"));
        veiculo.setPlaca(JOptionPane.showInputDialog("Placa"));

        return veiculo;
    }

    public String excluir() {
        return JOptionPane.showInputDialog("Placa");
    }

    public String consultar() {
        return JOptionPane.showInputDialog("Placa");
    }

    public void mostrar(Veiculo veiculo) {
        JOptionPane.showMessageDialog(null, veiculo);
    }

    public void mostrarTodos(List<Veiculo> veiculos) {
        StringBuilder lista = new StringBuilder();

        for (Veiculo veiculo : veiculos) {
            lista.append("\n[").append(veiculo.getPlaca()).append("] - ").append(veiculo.getCapacidade());
        }

        JOptionPane.showMessageDialog(null, lista.toString());
    }
}
