/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.strategy;

/**
 *
 * @author Italo
 */
public interface InterfaceCrudPedido {
    
    public boolean salvarPedido(int idPizza, int idCli) throws Exception;
    
    public Object listar() throws Exception;
    
    public Object verificarQuantPedidos(int idCli) throws Exception;
}
