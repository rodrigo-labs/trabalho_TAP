package br.com.integrador.view;

import br.com.integrador.model.ObjetoSituacao;
import br.com.integrador.model.Objeto;

import javax.swing.*;
import java.util.List;

public class ObjetoView {

    public char menu() {
        String menu = "SISTEMA DE LOGISTICA\n" +
                "CADASTRO DE OBJETOS\n\n" +
                "1 - INCLUIR\n" +
                "2 - EXCLUIR\n" +
                "3 - CONFIRMAR ENTREGA\n" +
                "4 - CONSULTAR\n" +
                "5 - LISTAR\n" +
                "0 - RETORNAR\n\n" +
                "OPÇÃO: ";

        return JOptionPane.showInputDialog(menu).charAt(0);
    }

    public Objeto incluir() {
        Objeto objeto = new Objeto();

        objeto.setNomeRemetente(JOptionPane.showInputDialog("Nome do remetente"));
        objeto.setEnderecoRemetente(JOptionPane.showInputDialog("Endereço do remetente"));
        objeto.setNomeDestinatario(JOptionPane.showInputDialog("Nome do Destinatário"));
        objeto.setEnderecoDestinatario(JOptionPane.showInputDialog("Endereço do Destinatário"));
        objeto.setDataDeposito(JOptionPane.showInputDialog("Data do Depósito"));
        objeto.setPeso(Float.parseFloat(JOptionPane.showInputDialog("Peso")));
        objeto.setCodigoLocalizador(JOptionPane.showInputDialog("Código Localizador"));
        objeto.setSituacao(ObjetoSituacao.TRIAGEM);

        return objeto;
    }

    public String confirmarEntrega() {
        return consultar();
    }

    public String excluir() {
        return consultar();
    }

    public String consultar() {
        return JOptionPane.showInputDialog("Código Localizador");
    }

    public void mostrarTodos(List<Objeto> objetos) {
        StringBuilder lista = new StringBuilder();

        for (Objeto objeto : objetos) {
            lista.append("\n[").append(objeto.getCodigoLocalizador()).append("] - ").append(objeto.getNomeRemetente());
        }

        JOptionPane.showMessageDialog(null, lista.toString());
    }

    public void mostrar(Objeto objeto) {
        JOptionPane.showMessageDialog(null, objeto);
    }
}
