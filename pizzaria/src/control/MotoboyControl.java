/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import model.Motoboy;
import model.facades.FacadeMotoboy;

/**
 *
 * @author Italo
 */
public class MotoboyControl {
    private FacadeMotoboy facadeMotob;
    
    public MotoboyControl(){
        facadeMotob = new FacadeMotoboy();
    }
    
    public boolean entregarPizza(int id, String status) throws Exception{
        return facadeMotob.entregarPedido(id, status);
    }
}
