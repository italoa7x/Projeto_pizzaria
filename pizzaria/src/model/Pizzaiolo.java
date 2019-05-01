/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.interfaces.InterfacePizzaiolo;
import dao.PizzaioloDAO;

/**
 *
 * @author Italo
 */
public class Pizzaiolo extends Funcionario{
    private InterfacePizzaiolo pizzaioloDAO;
    
    public Pizzaiolo() {
        super(1);
        pizzaioloDAO = new PizzaioloDAO();
    }
    
    public boolean prepararPizza(int id) throws Exception{
        return pizzaioloDAO.prepararPizza(id);
    }
}
