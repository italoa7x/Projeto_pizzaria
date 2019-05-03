/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.facades;

import dao.MotoboyDAO;
import dao.interfaces.InterfaceMotoboy;

/**
 *
 * @author Italo
 */
public class FacadeMotoboy {
    private InterfaceMotoboy motoboyDAO;

    public FacadeMotoboy() {
        motoboyDAO = new MotoboyDAO();
    }
    
    public boolean entregarPedido(int id, String status) throws Exception{
        return motoboyDAO.entregarPizza(id, status);
    }
}
