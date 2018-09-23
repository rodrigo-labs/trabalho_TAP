package br.com.integrador.controller;

import br.com.integrador.exception.CargaCompletaException;
import br.com.integrador.model.Objeto;
import br.com.integrador.model.Rota;
import br.com.integrador.model.Situacao;
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
        chapa();
        RotaServiceMemoria service = new RotaServiceMemoria();

        for (Veiculo veiculo : veiculos) {
            if (veiculo.getCarga().size() > 0) {
                Rota rota = new Rota();
                rota.setId(Utils.getProximoID());
                rota.setData(Utils.dataDeHoje());
                rota.setVeiculo(veiculo);

                service.salvar(rota);
            }
        }
    }

    public void chapa() {
        StringBuilder lista = new StringBuilder();
        veiculos.sort(Comparator.reverseOrder());

        for (Veiculo veiculo : veiculos) {
            if (veiculo.getTamanhoDaCarga() == veiculo.getCapacidade()) {
                for (Objeto objeto : objetos) {
                    if (objeto.getSituacao().equals(Situacao.TRIAGEM)) {
                        try {
                            veiculo.setCarga(objeto);
                            objeto.setSituacao(Situacao.SAIU_PARA_ENTREGA);
                        } catch (CargaCompletaException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    }
                }
            }

        }

        for (Veiculo veiculo : veiculos) {
            lista.append("\nVEICULO PLACA[")
                    .append(veiculo.getPlaca())
                    .append("] - CAPACIDADE ")
                    .append(veiculo.getCapacidade())
                    .append(" - CARGA ")
                    .append(veiculo.getTamanhoDaCarga())
                    .append(veiculo.getMotorista());
        }

        JOptionPane.showMessageDialog(null, lista.toString());
    }
}
