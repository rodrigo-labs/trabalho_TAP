package br.com.integrador.controller;

import br.com.integrador.model.Objeto;
import br.com.integrador.model.Rota;
import br.com.integrador.model.Veiculo;
import br.com.integrador.service.ObjetoServiceMemoria;
import br.com.integrador.service.RotaServiceMemoria;
import br.com.integrador.service.VeiculoServiceMemoria;
import br.com.integrador.utils.Utils;

import javax.swing.*;
import java.util.Comparator;
import java.util.List;

public class RotaController {

    private List<Objeto> objetos = ObjetoServiceMemoria.getObjetoList();
    private List<Veiculo> veiculos = VeiculoServiceMemoria.getVeiculoList();


    public void criadorDeRotas() {
        RotaServiceMemoria service = new RotaServiceMemoria();
        CarregadorRota carregadorRota;
        veiculos.sort(Comparator.reverseOrder());

        for (Veiculo veiculo : veiculos) {
            Rota rota = new Rota();

            rota.setId(Utils.getProximoID());
            rota.setData(Utils.dataDeHoje());
            carregadorRota = new CarregadorRota(veiculo, objetos);
            veiculo.setCarga(carregadorRota.carrega());
            rota.setVeiculo(veiculo);

            if (veiculo.getCarga().size() > 0) {
                service.salvar(rota);
            }
        }
    }

    public void carregador() {
        StringBuilder lista = new StringBuilder();
        veiculos.sort(Comparator.reverseOrder());
        CarregadorRota carregadorRota;

        for (Veiculo veiculo : veiculos) {
            if (veiculo.getCarga().isEmpty()) {
                carregadorRota = new CarregadorRota(veiculo, objetos);
                veiculo.setCarga(carregadorRota.carrega());
            }
        }

        for (Veiculo veiculo : veiculos) {
            lista.append("\nVEICULO PLACA[")
                    .append(veiculo.getPlaca())
                    .append("] - CAPACIDADE ")
                    .append(veiculo.getCapacidade())
                    .append(" - CARGA ")
                    .append(veiculo.getCarga().size())
                    .append(veiculo.getMotorista());
        }

        JOptionPane.showMessageDialog(null, lista.toString());
    }
}
