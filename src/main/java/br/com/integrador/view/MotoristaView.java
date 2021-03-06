package br.com.integrador.view;

import br.com.integrador.model.Motorista;

import javax.swing.*;
import java.util.List;


public class MotoristaView {

    public char menu() {
        String menu = "\nSISTEMA DE LOGISTICA\n" +
                "CADASTRO DE MOTORISTAS\n\n" +
                "1 - INCLUIR\n" +
                "2 - EXCLUIR\n" +
                "3 - CONSULTAR\n" +
                "4 - LISTAR\n" +
                "0 - RETORNAR\n\n" +
                "OPÇÃO: ";

        return JOptionPane.showInputDialog(menu).charAt(0);
    }

    public Motorista incluir() {
        Motorista motorista = new Motorista();
        String[] opcoes = {"Tipo B", "Tipo C"};
        int opcaoCNH;

        motorista.setNome(JOptionPane.showInputDialog("Nome"));
        motorista.setEndereco(JOptionPane.showInputDialog("Endereço"));
        opcaoCNH = JOptionPane.showOptionDialog(
                null,
                "Escolha o tipo daCNH",
                "CNH",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcoes,
                opcoes[0]
        );
        motorista.setTipoCNH(opcaoCNH);
        motorista.setNumeroCNH(Integer.parseInt(JOptionPane.showInputDialog("Número da CNH")));
        motorista.setDataNascimento(JOptionPane.showInputDialog("Data de nascimento"));

        return motorista;
    }

    public String excluir() {
        return consultar();
    }

    public String consultar() {
        return JOptionPane.showInputDialog("Nome");
    }

    public void mostrar(Motorista motorista) {
        JOptionPane.showMessageDialog(null, motorista);
    }

    public void mostrarTodos(List<Motorista> motoristas) {
        StringBuilder lista = new StringBuilder();

        for (Motorista motorista : motoristas) {
            lista.append("\n[").append(motorista.getNumeroCNH()).append("] - ").append(motorista.getNome());
        }

        JOptionPane.showMessageDialog(null, lista.toString());
    }
}
