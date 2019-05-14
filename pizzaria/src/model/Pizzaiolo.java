/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.PizzaioloDAO;
import dao.interfaces.InterfacePizzaiolo;
import model.strategy.StrategyPedido;

/**
 *
 * @author Italo
 */
public class Pizzaiolo extends Funcionario implements StrategyPedido{
    private InterfacePizzaiolo pizzaiolo;
    
    
    public Pizzaiolo() {
        super(1);
        pizzaiolo = new PizzaioloDAO();
    }
    
    public boolean prepararPizza(int id) throws Exception{
        return pizzaiolo.prepararPizza(id);
    }

    @Override
    public boolean salvar_pedido(int id_pizza, int id_cliente) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object listar_pedido() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object verificaQuantPedidos(int id_cliente) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean preparar_pedido(int id_pedido) throws Exception {
        return pizzaiolo.prepararPizza(id_pedido);
    }

    @Override
    public boolean entregar_pedido(String status, int id_pedido) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
