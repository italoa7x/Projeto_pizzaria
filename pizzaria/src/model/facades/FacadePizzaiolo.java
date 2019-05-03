/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.facades;

import dao.PizzaioloDAO;
import dao.interfaces.InterfacePizzaiolo;

/**
 *
 * @author Italo
 */
public class FacadePizzaiolo {
    private InterfacePizzaiolo daoPizzaiolo;

    public FacadePizzaiolo() {
        daoPizzaiolo = new PizzaioloDAO();
       
    }
    
    public boolean prepararPizza(int id) throws Exception{
        return daoPizzaiolo.prepararPizza(id);
    }
    
}
