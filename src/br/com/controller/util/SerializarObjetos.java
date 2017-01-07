/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controller.util;

import br.com.model.Cliente;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gelson
 */
public class SerializarObjetos {

    public void serializaClientes(String extra) {
        String[] parts = extra.split(",");
        List<Cliente> lista = new ArrayList<Cliente>();

        for (int i = 0; i < parts.length; i++) {
            Cliente cliente;
            String part = parts[i];
            String[] separado = part.split("-");
            cliente = new Cliente(separado[0], separado[1]);
            lista.add(cliente);

        }
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream("listaClientes.ser");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(lista);
            oos.flush();
            oos.close();
        } catch (FileNotFoundException fnfex) {
            fnfex.printStackTrace();
        } catch (IOException ioex) {
            ioex.printStackTrace();
        }
        System.out.println("lista salva");
    }
    
     public List<Cliente> deserializaClientes() {
 
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        List<Cliente> clientes = null;
        try {
            fis = new FileInputStream("listaClientes.ser");
            ois = new ObjectInputStream(fis);
            clientes = (ArrayList<Cliente>) ois.readObject();
        } 
        catch (FileNotFoundException fnfex) {
            fnfex.printStackTrace();
        }
        catch (IOException ioex) {
            ioex.printStackTrace();
        } 
        catch (ClassNotFoundException ccex) {
            ccex.printStackTrace();
        }
        System.out.println("lista recuperada");
 
    return clientes;

}
}
