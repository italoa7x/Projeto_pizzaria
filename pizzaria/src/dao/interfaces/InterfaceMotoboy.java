/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.interfaces;

import java.sql.SQLException;

/**
 *
 * @author italo
 */
public interface InterfaceMotoboy {
    
    public boolean entregarPizza(int id, String status) throws Exception;
    
}
