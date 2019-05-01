/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import model.Motoboy;

/**
 *
 * @author Italo
 */
public class MotoboyControl {
    private Motoboy motob;
    
    public MotoboyControl(){
        motob = new Motoboy();
    }
    
    public boolean entregarPizza(int id, String status) throws Exception{
        return motob.entregarPizza(id, status);
    }
}
