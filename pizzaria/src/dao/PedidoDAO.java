/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.interfaces.InterfacePedido;
import ConnectionFactory.ConexaoDB;
import dto.ClienteDTO;
import dto.PedidoDTO;
import dto.PizzaDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author darkc
 */
public class PedidoDAO implements InterfacePedido {
    
    

    @Override
    public boolean salva(int idPizza, int idCli) throws Exception {
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = ConexaoDB.instancia().conectar();
            pst = con.prepareStatement("insert into pedido (id_cli, id_pi, status) values (?,?,?)");
            pst.setInt(1, idCli);
            pst.setInt(2, idPizza);
            pst.setString(3, "Pedido aberto");
            pst.execute();
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } 
    }

    @Override
    public PedidoDTO listar() throws Exception {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<PedidoDTO> vetor = new ArrayList<PedidoDTO>();
        PedidoDTO regPedidos = new PedidoDTO();
        try {
            con = ConexaoDB.instancia().conectar();
            pst = con.prepareStatement("select c.nome as cliente, c.id as id_cli, p.nome as pizza, p.valor, p.tamanho as tamanho, pe.status,pe.id as id_pedido from pizza as p inner join pedido as pe on (p.id = pe.id_pi)\n"
                    + "inner join cliente as c on (c.id = pe.id_cli) order by pe.id asc");
            rs = pst.executeQuery();
            while (rs.next()) {
                PizzaDTO pizzaDTO = new PizzaDTO();
                ClienteDTO clienteDTO = new ClienteDTO();
                PedidoDTO pedidoDTO = new PedidoDTO();
                // dados da pizza
                pizzaDTO.setTamanho(rs.getString("tamanho"));
                pizzaDTO.setNome(rs.getString("pizza"));
                pizzaDTO.setValor(rs.getByte("valor"));
                // dados do cliente
                clienteDTO.setNome(rs.getString("cliente"));
                clienteDTO.setId(rs.getInt("id_cli"));
                // dados do pedido = pizza + cliente.
                pedidoDTO.setId(rs.getInt("id_pedido"));
                pedidoDTO.setCliente(clienteDTO);
                pedidoDTO.setPizza(pizzaDTO);
                pedidoDTO.setStatus(rs.getString("status"));
                vetor.add(pedidoDTO);
            }
            regPedidos.setPedidosCadastrados(vetor);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return regPedidos;
    }

    @Override
    public int verificaQuantPedidos(int idCli) throws Exception {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = ConexaoDB.instancia().conectar();
            pst = con.prepareStatement("select count(*) as total from pedido as p, cliente as c where p.id_cli = ? and p.status = ?");
            pst.setInt(1, idCli);
            pst.setString(2, "Pedido aberto");
            rs = pst.executeQuery();
            while (rs.next()) {
                return rs.getInt("total");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } 
        return 0;
    }

}
