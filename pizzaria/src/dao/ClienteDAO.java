package dao;

import dao.interfaces.InterfaceCliente;
import ConnectionFactory.ConexaoDB;
import dto.ClienteDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author italo
 */
public class ClienteDAO implements InterfaceCliente {

    @Override
    public boolean salva(ClienteDTO obj) throws Exception {
        Connection con = null;
        PreparedStatement pst = null;
        try {
            if (!obj.getNome().equalsIgnoreCase("Digite o nome completo") && !obj.getEndereco().equalsIgnoreCase("Digite a rua")
                    && !obj.getCpf().equalsIgnoreCase("   .   .   -  ") && !obj.getTelefone().equalsIgnoreCase("(  )  -    -    ")) {

                con = ConexaoDB.instancia().conectar();
                pst = con.prepareStatement("insert into cliente (nome,cpf,telefone,endereco) values (?,?,?,?)");
                pst.setString(1, obj.getNome());
                pst.setString(2, obj.getCpf());
                pst.setString(3, obj.getTelefone());
                pst.setString(4, obj.getEndereco());
                pst.execute();
                return true;
            }

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            ConexaoDB.instancia().desconectar(con, pst);
        }
        return false;
    }

    @Override
    public boolean deletar(int id) throws Exception {
        Connection con = null;
        PreparedStatement pst = null;
        if (id != 0) {
            try {
                con = ConexaoDB.instancia().conectar();
                pst = con.prepareStatement("delete from cliente where id = ?");
                pst.setInt(1, id);
                pst.executeUpdate();
                return true;
            } catch (Exception e) {
                throw new Exception("Não é possível excluir este cliente.");
            } finally {
                ConexaoDB.instancia().desconectar(con, pst);
            }
        }
        return false;
    }

    @Override
    public ClienteDTO listar() throws Exception {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<ClienteDTO> vetorCli = new ArrayList<ClienteDTO>();
        ClienteDTO cliDTO = new ClienteDTO();
        try {
            con = ConexaoDB.instancia().conectar();
            pst = con.prepareStatement("select *from cliente");
            rs = pst.executeQuery();
            while (rs.next()) {
                ClienteDTO c = new ClienteDTO();
                c.setNome(rs.getString("nome"));
                c.setCpf(rs.getString("cpf"));
                c.setEndereco(rs.getString("endereco"));
                c.setTelefone(rs.getString("telefone"));
                c.setId(rs.getInt("id"));
                vetorCli.add(c);
            }
            cliDTO.setClientesCadastrados(vetorCli);

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            ConexaoDB.instancia().desconectar(con, pst, rs);
        }
        return cliDTO;
    }

    @Override
    public boolean atualizar(ClienteDTO obj) throws Exception {
        Connection con = null;
        PreparedStatement pst = null;
        con = ConexaoDB.instancia().conectar();
        try {

            pst = con.prepareStatement("update cliente set nome = ?, cpf = ?, telefone = ?, endereco = ? where id = ?");
            pst.setString(1, obj.getNome());
            pst.setString(2, obj.getCpf());
            pst.setString(3, obj.getCpf());
            pst.setString(4, obj.getEndereco());
            pst.setInt(5, obj.getId());
            pst.executeUpdate();

            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            ConexaoDB.instancia().desconectar(con, pst);
        }
    }

    @Override
    public ClienteDTO buscar(String nome) throws Exception {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        ClienteDTO clienteDTO = new ClienteDTO();
        try {
            con = ConexaoDB.instancia().conectar();
            pst = con.prepareStatement("select *from cliente where nome like ?");
            pst.setString(1, "%" + nome + "%");
            rs = pst.executeQuery();
            while (rs.next()) {
                clienteDTO.setNome(rs.getString("nome"));
                clienteDTO.setEndereco(rs.getString("endereco"));
                clienteDTO.setCpf(rs.getString("cpf"));
                clienteDTO.setTelefone(rs.getString("telefone"));
                clienteDTO.setId(rs.getInt("id"));

            }
            return clienteDTO;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
           ConexaoDB.instancia().desconectar(con, pst, rs);
        }
    }

}
