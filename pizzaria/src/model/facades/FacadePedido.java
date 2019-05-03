/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.facades;

import dao.PedidoDAO;
import dao.interfaces.InterfacePedido;
import model.strategy.InterfaceCrudPedido;

/**
 *
 * @author Italo
 */
public class FacadePedido implements InterfaceCrudPedido {

    private InterfacePedido daoP;

    public FacadePedido() {
        daoP = new PedidoDAO();
    }

    @Override
    public boolean salvarPedido(int idCli, int idPizza) throws Exception {
        return daoP.salva(idPizza, idCli);
    }

    @Override
    public Object listar() throws Exception {
        return daoP.listar();
    }

    @Override
    public Object verificarQuantPedidos(int idCli) throws Exception {
        return daoP.verificaQuantPedidos(idCli);
    }

}
