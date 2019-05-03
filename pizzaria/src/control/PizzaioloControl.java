/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import model.Pizzaiolo;
import model.facades.FacadePizzaiolo;

/**
 *
 * @author Italo
 */
public class PizzaioloControl {
    private FacadePizzaiolo facadePizzaiolo;
    
    public PizzaioloControl(){
        facadePizzaiolo = new FacadePizzaiolo();
    }
    
    public boolean prepararPizza(int id) throws Exception{
        return facadePizzaiolo.prepararPizza(id);
    }
}
