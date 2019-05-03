/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import ConnectionFactory.ConexaoDB;
import dto.PizzaDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Italo
 */
public class FacadePizza {
 
    public boolean salvarPizza(PizzaDTO obj) throws Exception{
        return this.salva(obj);
    }
    
    private boolean salva(PizzaDTO obj) throws Exception {
        /// area responsável por conectar ao banco e salvar os dados.
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = ConexaoDB.instancia().conectar();
            pst = con.prepareStatement("insert into pizza (nome,tamanho,valor,quant_fatias, fatia) values (?,?,?,?,?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setString(1, obj.getNome());
            pst.setString(2, obj.getTamanho());
            pst.setDouble(3, obj.getValor());
            pst.setInt(4, obj.getQuant_fatias());
            pst.setDouble(5, obj.getFatia());
            pst.execute();
            rs = pst.getGeneratedKeys();
            while (rs.next()) {
                int idPi = rs.getInt("id");
                setaSabores(idPi, obj.getSabores());
                return true;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ConexaoDB.instancia().desconectar(con, pst, rs);
        }
        return false;
    }
    
    private void setaSabores(int id, String[] sabores) throws Exception {
        /// area responsável por conectar ao banco e salvar os dados.
        Connection con = null;
        PreparedStatement pst = null;
        con = ConexaoDB.instancia().conectar();
        try {
            pst = con.prepareStatement("insert into tbl_sabores (id_pi, sabor) values (?,?)");
            for (int i = 0; i < sabores.length; i++) {
                pst.setInt(1, id);
                pst.setString(2, sabores[i]);
                pst.execute();
            }

        } catch (SQLException ex) {
            throw new Exception(ex.getMessage());
        } finally {
            ConexaoDB.instancia().desconectar(con, pst);
        }
    }
    
    
     public int salvaPizzaPersonalizada(PizzaDTO obj) throws Exception {
        /// area responsável por conectar ao banco e salvar os dados.
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        int id_pizza = 0;
        try {
            con = ConexaoDB.instancia().conectar();
            pst = con.prepareStatement("insert into pizza (nome,tamanho,valor,quant_fatias, fatia) values (?,?,?,?,?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setString(1, obj.getNome());
            pst.setString(2, obj.getTamanho());
            pst.setDouble(3, obj.getValor());
            pst.setInt(4, obj.getQuant_fatias());
            pst.setDouble(5, obj.getFatia());
            pst.executeUpdate();
            rs = pst.getGeneratedKeys();
            while (rs.next()) {
                id_pizza = rs.getInt("id");
            }
            setaSabores(id_pizza, obj.getSabores());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ConexaoDB.instancia().desconectar(con, pst, rs);
        }
        return id_pizza;
    }
    
}
