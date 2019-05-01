/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.interfaces.InterfaceMotoboy;
import dao.MotoboyDAO;

/**
 *
 * @author Italo
 */
public class Motoboy extends Funcionario{
    private InterfaceMotoboy motoboyDAO;
    
    public Motoboy() {
        super(1);
        motoboyDAO = new MotoboyDAO();
    }
    
    public boolean entregarPizza(int id, String status) throws Exception{
       return motoboyDAO.entregarPizza(id, status);
    }
    
}
