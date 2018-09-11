package br.com.integrador.service;

import br.com.integrador.model.Objeto;

import java.util.ArrayList;
import java.util.List;

public class ObjetoServiceMemoria implements ObjetoService {

    private static List<Objeto> objetoList = new ArrayList<>();

    @Override
    public void salvar(Objeto objeto) {
        objetoList.add(objeto);
    }

    @Override
    public List<Objeto> listar() {
        return objetoList;
    }

    @Override
    public Objeto buscarPor(String codigoLocalizador) {
        for (Objeto objeto: objetoList) {
            if (objeto.getCodigoLocalizador().equals(codigoLocalizador)) {
                return objeto;
            }
        }

        return null;
    }

    @Override
    public void remover(Objeto objeto) {
        objetoList.remove(objeto);
    }

    @Override
    public void ConfirmarEntregaPor(String codigoLocalizador) {
        for (Objeto objeto: objetoList) {
            if (objeto.getCodigoLocalizador().equals(codigoLocalizador)) {
                objeto.setEntregue(true);
            }
        }
    }
}
