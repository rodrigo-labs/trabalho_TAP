package br.com.integrador.view;

import br.com.integrador.model.Objeto;
import br.com.integrador.model.Rota;

import javax.swing.*;
import java.util.List;

public class RotaView {

    public char menu() {
        String menu = "\nSISTEMA DE LOGISTICA\n" +
                "MENU DE ROTAS\n\n" +
                "1 - GERAR ROTAS\n" +
                "2 - CONSULTAR POR ID\n" +
                "3 - CONSULTAR POR MOTORISTA\n" +
                "4 - LISTAR\n" +
                "5 - LISTAR POR DATA\n" +
                "0 - RETORNAR\n\n" +
                "OPÇÃO: ";

        return JOptionPane.showInputDialog(menu).charAt(0);
    }

    public String consultarPorID() {
        return JOptionPane.showInputDialog("Consulta por ID");
    }

    public String consultarPorMotorista() {
        return JOptionPane.showInputDialog("Consulta por ID");
    }

    public void mostrarTodos(List<Rota> rotas) {
        StringBuilder lista = new StringBuilder();

        for (Rota rota : rotas) {
            lista.append("\n[")
                    .append(rota.getId())
                    .append("] - ")
                    .append(rota.getData())
                    .append(" - ")
                    .append(rota.getVeiculo().getMotorista());
        }

        JOptionPane.showMessageDialog(null, lista.toString());
    }

    public void mostrar(Rota rota) {
        JOptionPane.showMessageDialog(null, rota);
    }
}
