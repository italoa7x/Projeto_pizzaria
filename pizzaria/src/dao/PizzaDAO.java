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

/**
 *
 * @author Italo
 */
public class PizzaDAO implements InterfacePizza {

    @Override
    public int salva(PizzaDTO obj) throws Exception {
        /// area responsável por conectar ao banco e salvar os dados.
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        int id_gerado = 0;
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
                id_gerado = rs.getInt("id");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar pizza " + e.getMessage());
        } finally {
            ConexaoDB.instancia().desconectar(con, pst, rs);
        }
        return id_gerado;
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
    public boolean salva_ingredientes(int id, String[] sabores) throws Exception {
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
            return true;
        } catch (SQLException ex) {
            throw new Exception("Erro ao salvar pizza " + ex.getMessage());
        } finally {
            ConexaoDB.instancia().desconectar(con, pst);
        }
    }
}
