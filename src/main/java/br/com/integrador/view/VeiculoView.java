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
                "3 - ADD MOTORISTA\n" +
                "4 - CONSULTAR\n" +
                "5 - LISTAR\n" +
                "0 - RETORNAR\n\n" +
                "OPÇÃO: ";

        return JOptionPane.showInputDialog(menu).charAt(0);
    }

    public Veiculo incluir() {
        Veiculo veiculo;
        int opcaoVeiculo;
        String[] opcoes = {"VAN", "CAMINHÃO", "CARRETA"};

        opcaoVeiculo = JOptionPane.showOptionDialog(
                null,
                "Escolha o tipo do veiculo",
                "Veiculos",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcoes,
                opcoes[0]
        );

        if (opcaoVeiculo == 0) {
            veiculo = new Van();
        } else if (opcaoVeiculo == 1) {
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
        return consultar();
    }

    public String adicionarMotorista() {
        return JOptionPane.showInputDialog("Nome");
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
            lista.append("\nVEICULO PLACA[")
                    .append(veiculo.getPlaca())
                    .append("] - CAPACIDADE ")
                    .append(veiculo.getCapacidade())
                    .append(" - CARGA ")
                    .append(veiculo.getCarga())
                    .append(veiculo.getMotorista());
        }

        JOptionPane.showMessageDialog(null, lista.toString());
    }
}
