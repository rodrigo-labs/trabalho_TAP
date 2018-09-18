package br.com.integrador;

import br.com.integrador.exception.HabilitacaoInvalidaException;
import br.com.integrador.model.Motorista;
import br.com.integrador.model.Objeto;
import br.com.integrador.model.Veiculo;
import br.com.integrador.service.MotoristaService;
import br.com.integrador.service.ObjetoService;
import br.com.integrador.service.VeiculoService;
import br.com.integrador.view.MotoristaView;
import br.com.integrador.view.ObjetoView;
import br.com.integrador.view.PrincipalView;
import br.com.integrador.view.VeiculoView;

import javax.swing.*;
import java.util.List;


public class App {

    public static void main( String[] args ) {
        PrincipalView view = new PrincipalView();
        char opcao;

        do {

            opcao = view.menu();
            switch (opcao) {
                case '1':
                    emitirRota();
                    break;

                case '2':
                    cadastroObjeto();
                    break;

                case '3':
                    cadastroMotorista();
                    break;

                case '4':
                    cadastroVeiculo();
                    break;

                case '5':
                    exibirRelatorios();
                    break;

                case '0':
                    System.exit(0);
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "OPÇÃO INVALIDA!!!\n");
                    break;
            }
        } while (true);
    }

    private static void emitirRota() {

    }

    private static void cadastroObjeto() {
        ObjetoView view = new ObjetoView();
        ObjetoService service = ObjetoService.getNewInstance();
        Objeto objeto;
        List<Objeto> objetoList;
        String codigoVerificador;
        char opcao;

        do {
            opcao = view.menu();

            switch (opcao) {
                case '1':
                    objeto = view.incluir();
                    service.salvar(objeto);
                    break;

                case '2':
                    codigoVerificador = view.excluir();
                    objeto = service.buscarPor(codigoVerificador);
                    if (objeto == null) {
                        JOptionPane.showMessageDialog(null, "OBJETO NÃO ENCONTRADO");
                    } else {
                        service.remover(objeto);
                    }
                    break;

                case '3':
                    codigoVerificador = view.confirmarEntrega();
                    objeto = service.buscarPor(codigoVerificador);
                    if (objeto == null) {
                        JOptionPane.showMessageDialog(null, "OBJETO NÃO ENCONTRADO");
                    } else {
                        service.ConfirmarEntregaPor(codigoVerificador);
                    }
                    break;

                case '4':
                    codigoVerificador = view.consultar();
                    objeto = service.buscarPor(codigoVerificador);
                    if (objeto == null) {
                        JOptionPane.showMessageDialog(null, "OBJETO NÃO ENCONTRADO");
                    } else {
                        view.mostrar(objeto);
                    }
                    break;

                case '5':
                    objetoList = service.listar();
                    if (objetoList.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "NENHUM OBJETO CADASTRADO");
                    } else {
                        view.mostrarTodos(objetoList);
                    }
                    break;

                case '0':
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "OPÇÃO INVALIDA!!!\n");
                    break;
            }
        } while (opcao != '0');
    }

    private static void cadastroMotorista() {
        MotoristaView view = new MotoristaView();
        MotoristaService service = MotoristaService.getNewInstance();
        Motorista motorista;
        List<Motorista> motoristaList;
        String nome;
        char opcao;

        do {
            opcao = view.menu();
            switch (opcao) {
                case '1':
                    motorista  = view.incluir();
                    service.salvar(motorista);
                    break;

                case '2':
                    nome = view.excluir();
                    motorista = service.buscarPor(nome);
                    if (motorista != null) {
                        service.remover(motorista);
                    } else {
                        JOptionPane.showMessageDialog(null, "MOTORISTA NÃO ENCONTRADO");
                    }
                    break;

                case '3':
                    nome = view.consultar();
                    motorista = service.buscarPor(nome);
                    if (motorista != null) {
                        view.mostrar(motorista);
                    } else {
                        JOptionPane.showMessageDialog(null, "MOTORISTA NÃO ENCONTRADO");
                    }
                    break;

                case '4':
                    motoristaList = service.listar();
                    if (motoristaList.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "NENHUM MOTORISTA CADASTRADO");
                    } else {
                        view.mostrarTodos(motoristaList);
                    }
                    break;

                case '0':
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "OPÇÃO INVALIDA!!!\n");
                    break;
            }
        } while (opcao != '0');
    }

    private static void cadastroVeiculo() {
        VeiculoView view = new VeiculoView();
        VeiculoService service = VeiculoService.getNewInstance();
        MotoristaService motoristaService = MotoristaService.getNewInstance();
        List<Veiculo> veiculoList;
        Veiculo veiculo;
        Motorista motorista;
        String placa;
        String nome;
        char opcao;

        do {
            opcao = view.menu();

            switch (opcao) {
                case '1':
                    veiculo  = view.incluir();
                    service.salvar(veiculo);
                    break;

                case '2':
                    placa = view.excluir();
                    veiculo = service.buscarPor(placa);
                    if (veiculo != null) {
                        service.remover(veiculo);
                    } else {
                        JOptionPane.showMessageDialog(null, "VEICULO NÃO ENCONTRADO");
                    }
                    break;

                case '3':
                    placa = view.consultar();
                    veiculo = service.buscarPor(placa);
                    if (veiculo != null) {
                        nome = view.selecionarMotorista();
                        motorista = motoristaService.buscarPor(nome);
                        if (motorista != null) {
                            try {
                                service.selecionarMotorista(motorista, veiculo);
                            } catch (HabilitacaoInvalidaException ex) {
                                JOptionPane.showMessageDialog(null, ex.getMessage());
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "MOTORISTA NÃO ENCONTRADO");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "VEICULO NÃO ENCONTRADO");
                    }

                    break;

                case '4':
                    placa = view.consultar();
                    veiculo = service.buscarPor(placa);
                    if (veiculo != null) {
                        view.mostrar(veiculo);
                    } else {
                        JOptionPane.showMessageDialog(null, "VEICULO NÃO ENCONTRADO");
                    }
                    break;

                case '5':
                    veiculoList = service.listar();
                    if (veiculoList.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "NENHUM VEICULO CADASTRADO");
                    } else {
                        view.mostrarTodos(veiculoList);
                    }
                    break;

                case '0':
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "OPÇÃO INVALIDA!!!\n");
                    break;
            }
        } while (opcao != '0');
    }

    private static void exibirRelatorios() {

    }
}
