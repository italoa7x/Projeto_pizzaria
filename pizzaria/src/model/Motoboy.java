/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.MotoboyDAO;
import dao.interfaces.InterfaceMotoboy;


/**
 *
 * @author Italo
 */
public class Motoboy extends Funcionario{
    private InterfaceMotoboy motoBoy;

    
    public Motoboy() {
        super(1);
        motoBoy = new MotoboyDAO();
    }
   
    public boolean entregarPedido(int id, String status) throws Exception{
        return motoBoy.entregarPizza(id, status);
    }
    
}
