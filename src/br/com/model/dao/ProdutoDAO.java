/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.dao;

import br.com.model.Produto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gelson
 */
public class ProdutoDAO {

    private static List<Produto> produtos = new ArrayList<Produto>();

    public boolean add(Produto c) {
        if (!produtos.contains(c)) {
            produtos.add(c);
            return true;
        } else {
            remove(c);
            produtos.add(c);
            return false;
        }
    }

    public void remove(Produto c) {
        produtos.remove(c);
    }

    public List<Produto> listAll() {
        return produtos;
    }

}
