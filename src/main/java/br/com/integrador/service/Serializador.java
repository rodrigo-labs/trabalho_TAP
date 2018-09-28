package br.com.integrador.service;

import br.com.integrador.model.Motorista;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Serializador {

    public void serializar(List<?> elements, String path) {
        try (OutputStream escritorByte = new FileOutputStream(path, true);
             ObjectOutputStream escritorObjeto = new ObjectOutputStream(escritorByte)) {

            escritorObjeto.writeObject(elements);
            escritorObjeto.flush();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public List<?> descerializar(String path) {
        List<?> list = new ArrayList<>();

        try (InputStream leitorByte =  new FileInputStream(path);
             ObjectInputStream leitorObjeto = new ObjectInputStream(leitorByte)) {

            list = (List<?>) leitorObjeto.readObject();
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return list;
    }

    public void descerializarMotorista(String path) {
        try (InputStream leitorByte = new FileInputStream(path);
             ObjectInputStream leitorObjeto = new ObjectInputStream(leitorByte)) {

            MotoristaServiceMemoria.setMotoristaList((List<Motorista>) leitorObjeto.readObject());
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
