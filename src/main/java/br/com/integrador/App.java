package br.com.integrador;

import br.com.integrador.controller.MotoristaController;
import br.com.integrador.controller.ObjetoController;
import br.com.integrador.controller.RotaController;
import br.com.integrador.controller.VeiculoController;
import br.com.integrador.model.Motorista;
import br.com.integrador.service.MotoristaServiceMemoria;
import br.com.integrador.service.Serializador;
import br.com.integrador.view.*;

import javax.swing.JOptionPane;
import java.util.List;


public class App {

    public static void main( String[] args ) {
        PrincipalView view = new PrincipalView();
        char opcao;

        Serializador serializador = new Serializador();
        MotoristaServiceMemoria.setMotoristaList((List<Motorista>) serializador.descerializar("data/motorista.bin"));

        do {
            opcao = view.menu();
            switch (opcao) {
                case '1':
                    menuRota();
                    break;

                case '2':
                    menuObjeto();
                    break;

                case '3':
                    menuMotorista();
                    break;

                case '4':
                    menuVeiculo();
                    break;

                case '5':
                    menuRelatorios();
                    break;

                case '0':
                    serializador.serializar(MotoristaServiceMemoria.getMotoristaList(), "data/motorista.bin");
                    System.exit(0);
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "OPÇÃO INVALIDA!!!\n");
                    break;
            }
        } while (true);
    }

    private static void menuRota() {
        RotaView view = new RotaView();
        RotaController controller = new RotaController();
        char opcao;

        do {
            opcao = view.menu();

            switch (opcao) {
                case '1':
                    controller.criadorDeRotas();
                    break;

                case '2':

                    break;
                case '3':

                    break;

                case '4':

                    break;

                case '5':

                    break;

                case '0':
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "OPÇÃO INVALIDA!!!\n");
                    break;
            }
        } while (opcao != '0');
    }

    private static void menuObjeto() {
        ObjetoView view = new ObjetoView();
        ObjetoController controller = new ObjetoController();
        char opcao;

        do {
            opcao = view.menu();

            switch (opcao) {
                case '1':
                    controller.incluir();
                    break;

                case '2':
                    controller.excluir();
                    break;
                case '3':
                    controller.confirmarEntrega();
                    break;

                case '4':
                    controller.mostrar();
                    break;

                case '5':
                    controller.listar();
                    break;

                case '6':
                    controller.listarEntregues();
                    break;

                case '0':
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "OPÇÃO INVALIDA!!!\n");
                    break;
            }
        } while (opcao != '0');
    }

    private static void menuMotorista() {
        MotoristaView view = new MotoristaView();
        MotoristaController controller = new MotoristaController();
        char opcao;

        do {
            opcao = view.menu();
            switch (opcao) {
                case '1':
                    controller.incluir();
                    break;

                case '2':
                    controller.excluir();
                    break;

                case '3':
                    controller.consultar();
                    break;

                case '4':
                    controller.listar();
                    break;

                case '0':
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "OPÇÃO INVALIDA!!!\n");
                    break;
            }
        } while (opcao != '0');
    }

    private static void menuVeiculo() {
        VeiculoView view = new VeiculoView();
        VeiculoController controller = new VeiculoController();
        char opcao;

        do {
            opcao = view.menu();

            switch (opcao) {
                case '1':
                    controller.incluir();
                    break;

                case '2':
                    controller.excluir();
                    break;

                case '3':
                    controller.adicionarMotorista();
                    break;

                case '4':
                    controller.consultar();
                    break;

                case '5':
                    controller.listar();
                    break;

                case '0':
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "OPÇÃO INVALIDA!!!\n");
                    break;
            }
        } while (opcao != '0');
    }

    private static void menuRelatorios() {

    }
}
