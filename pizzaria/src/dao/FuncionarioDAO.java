/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.interfaces.InterfaceFuncionario;
import ConnectionFactory.ConexaoDB;
import dto.FuncionarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author italo
 */
public class FuncionarioDAO implements InterfaceFuncionario {

    @Override
    public boolean salva(FuncionarioDTO obj) throws Exception {
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = ConexaoDB.instancia().conectar();
            pst = con.prepareStatement("INSERT INTO funcionario(nome,login,senha,cargo,nivel_acesso) VALUES (?,?,?,?,?)");
            pst.setString(1, obj.getNome());
            pst.setString(2, obj.getLogin());
            pst.setString(3, obj.getSenha());
            pst.setString(4, obj.getCargo());
            pst.setInt(5, obj.getNivel_acesso());
            pst.execute();
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            ConexaoDB.instancia().desconectar(con, pst);
        }
    }

    @Override
    public boolean deletar(int obj) throws Exception {
        Connection con = null;
        PreparedStatement pst = null;
        con = ConexaoDB.instancia().conectar();
        try {
            pst = con.prepareStatement("delete from funcionario where id = ?");
            pst.setInt(1, obj);
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            ConexaoDB.instancia().desconectar(con, pst);
        }
    }

    @Override
    public FuncionarioDTO listar() throws Exception {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<FuncionarioDTO> vetorFuncionarios = new ArrayList<FuncionarioDTO>();
        FuncionarioDTO funcionariodto = new FuncionarioDTO();

        try {
            con = ConexaoDB.instancia().conectar();
            pst = con.prepareStatement("select *from funcionario");
            rs = pst.executeQuery();
            while (rs.next()) {
                FuncionarioDTO f = new FuncionarioDTO();
                f.setNome(rs.getString("nome"));
                f.setLogin(rs.getString("login"));
                f.setSenha(rs.getString("senha"));
                f.setCargo(rs.getString("cargo"));
                f.setId(rs.getInt("id"));
                vetorFuncionarios.add(f);
            }
            funcionariodto.setFuncionarioCadastrados(vetorFuncionarios);
        } catch (Exception e) {
            throw new Exception(e.getMessage());

        } finally {
            ConexaoDB.instancia().desconectar(con, pst, rs);
        }
        return funcionariodto;
    }

    @Override
    public boolean atualizar(FuncionarioDTO obj) throws Exception {
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = ConexaoDB.instancia().conectar();
            pst = con.prepareStatement("update funcionario set nome = ?, login= ?, senha= ? where id = ?");
            pst.setString(1, obj.getNome());
            pst.setString(2, obj.getLogin());
            pst.setString(3, obj.getSenha());
            pst.setInt(4, obj.getId());
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            ConexaoDB.instancia().desconectar(con, pst);
        }
    }

    @Override
    public FuncionarioDTO AcessarSistema(String login, String senha) throws Exception {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        con = ConexaoDB.instancia().conectar();
        FuncionarioDTO fAchado = new FuncionarioDTO();
        try {
            pst = con.prepareStatement("select *from funcionario where login = ? and senha = ? limit 1");
            pst.setString(1, login);
            pst.setString(2, senha);
            rs = pst.executeQuery();
            while (rs.next()) {
                fAchado.setNome(rs.getString("nome"));
                fAchado.setCargo(rs.getString("cargo"));
            }
            return fAchado;
        } catch (Exception e) {
            throw new Exception("Funcionário não encontrado." + e.getMessage());
        } finally {
            ConexaoDB.instancia().desconectar(con, pst, rs);
        }
    }

}
