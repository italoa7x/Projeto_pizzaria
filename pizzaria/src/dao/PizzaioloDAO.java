/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.interfaces.InterfacePizzaiolo;
import ConnectionFactory.ConexaoDB;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author darkc
 */
public class PizzaioloDAO implements InterfacePizzaiolo {

    @Override
    public boolean prepararPizza(int id) throws Exception {
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = ConexaoDB.instancia().conectar();
            pst = con.prepareStatement("update pedido set status = ? where id = ?");
            pst.setString(1, "Preparado");
            pst.setInt(2, id);
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            ConexaoDB.instancia().desconectar(con, pst);
        }
    }

}
