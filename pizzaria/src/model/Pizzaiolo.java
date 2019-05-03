/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.PizzaioloDAO;
import dao.interfaces.InterfacePizzaiolo;

/**
 *
 * @author Italo
 */
public class Pizzaiolo extends Funcionario {
    private InterfacePizzaiolo pizzaiolo;
    
    
    public Pizzaiolo() {
        super(1);
        pizzaiolo = new PizzaioloDAO();
    }
    
    public boolean prepararPizza(int id) throws Exception{
        return pizzaiolo.prepararPizza(id);
    }

}
