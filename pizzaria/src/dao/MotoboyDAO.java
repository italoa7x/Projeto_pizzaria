/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.interfaces.InterfaceMotoboy;
import ConnectionFactory.ConexaoDB;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author darkc
 */
public class MotoboyDAO implements InterfaceMotoboy {

    @Override
    public boolean entregarPizza(int id, String status) throws Exception {
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = ConexaoDB.instancia().conectar();
            pst = con.prepareStatement("update pedido set status = ? where id = ?");
            pst.setString(1, status);
            pst.setInt(2, id);
            pst.execute();
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
