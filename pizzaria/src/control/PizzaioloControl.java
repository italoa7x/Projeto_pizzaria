/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import model.Pizzaiolo;

/**
 *
 * @author Italo
 */
public class PizzaioloControl {
    private Pizzaiolo pizzaiolo;
    
    public PizzaioloControl(){
        pizzaiolo = new Pizzaiolo();
    }
    
    public boolean prepararPizza(int id) throws Exception{
        return pizzaiolo.prepararPizza(id);
    }
}
