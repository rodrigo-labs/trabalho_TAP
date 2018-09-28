package br.com.integrador.controller;

import br.com.integrador.model.Objeto;
import br.com.integrador.model.Situacao;
import br.com.integrador.model.Veiculo;

import java.util.ArrayList;
import java.util.List;

class CarregadorRota {

    private Veiculo veiculo;
    private List<Objeto> objetos;


    CarregadorRota(Veiculo veiculo, List<Objeto> objetos) {
        this.veiculo = veiculo;
        this.objetos = objetos;
    }


    List<Objeto> carrega() {
        List<Objeto> carga = new ArrayList<>(veiculo.getCapacidade());

        for (Objeto objeto : objetos) {
            if (objeto.getSituacao() == Situacao.NAO_ENTTREGUE) {
                carga.add(objeto);
                objeto.setSituacao(Situacao.CARREGADO);
            }

            if (objeto.getSituacao() == Situacao.TRIAGEM) {
                carga.add(objeto);
                objeto.setSituacao(Situacao.CARREGADO);
            }
        }

        return carga;
    }
}
