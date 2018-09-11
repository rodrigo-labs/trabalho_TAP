package br.com.integrador.view;

import javax.swing.JOptionPane;

public class PrincipalView {

    public char menu() {
        String menu = "\nSISTEMA DE LOGISTICA\n" +
                "MENU PRINCIPAL\n\n" +
                "1 - EMITIR ROTA DE ENTREGA\n" +
                "2 - MENU OBJETOS\n" +
                "3 - MENU MOTORISTAS\n" +
                "4 - MENU VEICULOS\n" +
                "5 - EMITIR RELATÓRIOS\n" +
                "0 - FINALIZAR PROGRAMA\n\n" +
                "OPÇÃO: ";

        return JOptionPane.showInputDialog(menu).charAt(0);
    }
}
