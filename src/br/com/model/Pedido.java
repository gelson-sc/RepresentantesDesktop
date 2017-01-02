package br.com.model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author gelson
 */
public class Pedido {
    private int id;
    private String codBarras;
    private String cliente;
    private Date data;
    private List<Produto> produtos;
    private float total;
    private boolean transmitido;

    public Pedido() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodBarras() {
        return codBarras;
    }

    public void setCodBarras(String codBarras) {
        this.codBarras = codBarras;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal() {
        float total = 0;
         for (int i = 0; i < produtos.size(); i++) {
            total += produtos.get(i).getValor();
        }
        this.total = total;
    }

    public boolean isTransmitido() {
        return transmitido;
    }

    public void setTransmitido(boolean transmitido) {
        this.transmitido = transmitido;
    }

    @Override
    public String toString() {
        return "Pedido{" + "id=" + id + ", codBarras=" + codBarras + ", cliente=" + cliente + ", data=" + data + ", produtos=" + produtos + ", total=" + total + ", transmitido=" + transmitido + '}';
    }
    
    
    
}
