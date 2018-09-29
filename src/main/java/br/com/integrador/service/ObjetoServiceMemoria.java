package br.com.integrador.service;

import br.com.integrador.exception.NaoEncontradoException;
import br.com.integrador.model.Situacao;
import br.com.integrador.model.Objeto;

import java.util.ArrayList;
import java.util.List;

public class ObjetoServiceMemoria implements ObjetoService {

    private static List<Objeto> objetoList = new ArrayList<>();


    @Override
    public void salvar(Objeto objeto) {
        if (objeto.getCodigoLocalizador().equalsIgnoreCase("")) {
            objeto.setCodigoLocalizador("" + objeto.hashCode());
        }
        objetoList.add(objeto);
    }

    @Override
    public List<Objeto> listar() {
        return objetoList;
    }

    @Override
    public Objeto buscarPor(String codigoLocalizador) throws NaoEncontradoException {
        for (Objeto objeto: objetoList) {
            if (objeto.getCodigoLocalizador().equals(codigoLocalizador)) {
                return objeto;
            }
        }

        throw new NaoEncontradoException("OBJETO NÃO ENCONTRADO");
    }

    @Override
    public void remover(Objeto objeto) {
        objetoList.remove(objeto);
    }

    @Override
    public void ConfirmarEntregaPor(String codigoLocalizador) throws NaoEncontradoException {
        for (Objeto objeto: objetoList) {
            if (objeto.getCodigoLocalizador().equals(codigoLocalizador)) {
                objeto.setSituacao(Situacao.ENTREGUE);
            }
        }
    }

    public static List<Objeto> getObjetoList() {
        return objetoList;
    }

    public static void setObjetoList(List<Objeto> objetoList) {
        ObjetoServiceMemoria.objetoList = objetoList;
    }
}
