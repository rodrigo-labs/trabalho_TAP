package br.com.integrador.service;

import br.com.integrador.exception.NaoEncontradoException;
import br.com.integrador.model.Objeto;

import java.util.List;

public interface ObjetoService {

    void salvar(Objeto objeto);

    List<Objeto> listar();

    Objeto buscarPor(String codigoLocalizador) throws NaoEncontradoException;

    void remover(Objeto objeto);

    void ConfirmarEntregaPor(String codigoLocalizador) throws NaoEncontradoException;

    static ObjetoService getNewInstance() {
        return new ObjetoServiceMemoria();
    }
}
