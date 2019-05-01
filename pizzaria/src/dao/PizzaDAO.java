/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.interfaces.InterfacePizza;
import ConnectionFactory.ConexaoDB;
import dto.PizzaDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Pizza;

/**
 *
 * @author Italo
 */
public class PizzaDAO implements InterfacePizza {

    @Override
    public boolean salva(PizzaDTO obj) throws Exception {
        /// area responsável por conectar ao banco e salvar os dados.
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = ConexaoDB.instancia().conectar();
            pst = con.prepareStatement("insert into pizza (nome,tamanho,valor,quant_fatias, fatia) values (?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
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

    @Override
    public boolean deletar(int id) throws Exception {
        Connection con = null;
        PreparedStatement pst = null;
        con = ConexaoDB.instancia().conectar();
        try {
            pst = con.prepareStatement("delete from pizza where id = ?");
            pst.setInt(1, id);
            pst.execute();
            return true;
        } catch (Exception e) {
            throw new Exception("Não é possível excluir esta pizza.");
        } finally {
            ConexaoDB.instancia().desconectar(con, pst);
        }
    }

    @Override
    public PizzaDTO listar() throws Exception {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<PizzaDTO> vetor = new ArrayList<PizzaDTO>();
        PizzaDTO regPizzas = new PizzaDTO();
        try {
            con = ConexaoDB.instancia().conectar();
            pst = con.prepareStatement("select *from pizza");
            rs = pst.executeQuery();
            while (rs.next()) {
                PizzaDTO p = new PizzaDTO();
                p.setNome(rs.getString("nome"));
                p.setTamanho(rs.getString("tamanho"));
                p.setFatia(rs.getDouble("fatia"));
                p.setValor(rs.getDouble("valor"));
                p.setQuant_fatias(rs.getInt("quant_fatias"));
                p.setId(rs.getInt("id"));
                vetor.add(p);
            }
            regPizzas.setPizzasCadastradas(vetor);
            return regPizzas;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            ConexaoDB.instancia().desconectar(con, pst, rs);
        }
    }

    @Override
    public boolean atualizar(Object obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object buscar(Object obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    @Override
    public ArrayList<String> verSabores(int id) throws Exception {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<String> vetor = new ArrayList<String>();
        try {
            con = ConexaoDB.instancia().conectar();
            pst = con.prepareStatement("select tb.sabor as sabor from tbl_sabores as tb inner join pizza as p on (p.id = tb.id_pi) where p.id = ?");
            pst.setInt(1, id);
            rs = pst.executeQuery();
            while (rs.next()) {
                vetor.add(rs.getString("sabor"));
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            ConexaoDB.instancia().desconectar(con, pst, rs);
        }
        return vetor;
    }

    @Override
    public int salvaPizzaPersonalizada(PizzaDTO obj) throws Exception {
        /// area responsável por conectar ao banco e salvar os dados.
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        int id_pizza = 0;
        try {
            con = ConexaoDB.instancia().conectar();
            pst = con.prepareStatement("insert into pizza (nome,tamanho,valor,quant_fatias, fatia) values (?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
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
