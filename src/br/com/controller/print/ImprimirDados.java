/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controller.print;

import br.com.model.Pedido;
import br.com.model.Produto;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 *
 * @author gelson
 */
public class ImprimirDados {

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    

    public boolean imprimirPedido(Pedido pedido) {
        try {
            String saidaPedido;
            String codigo = pedido.getCodBarras();
            String cliente = pedido.getCliente();
            String data = sdf.format(pedido.getData());
            pedido.setTotal();
            List<Produto> produtos = pedido.getProdutos();

            String linha = "\n----------------------------\n";
            
            // imprimir com fontes diferentes no formato abaixo
            
            saidaPedido = linha; // fonte B(1,1)
            saidaPedido += cliente; // fonte A(2,1)
            saidaPedido += linha; // fonte B(1,1)
            saidaPedido += codigo; // fonte A(1,1)
            saidaPedido += data; // fonte A(1,1)
            saidaPedido += linha; // fonte B(1,1)
            saidaPedido += produtos.toString(); // fonte A(2,1)
            saidaPedido += linha; // fonte B(1,1)
            

        } catch (Exception e) {
               e.printStackTrace();
        }
        return true;
    }

    public boolean imprimirRodape(Pedido pedido) {
        String codigoBarras = pedido.getCodBarras();
        // print codigo de barras
        return true;
    }
    
    public boolean imprimirString(String dados) {
        
        // print codigo de barras
        return true;
    }

    public String imprimirPedidoTela(List<Produto> produtos) {
        String tela = "<html>";
         for (int i = 0; i < produtos.size(); i++) {
            Produto get = produtos.get(i);
            tela += get.toString();
        }
         tela += "</html>";
        return tela;
    }

}
