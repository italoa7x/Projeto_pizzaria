/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dto.PedidoDTO;
import model.Pedido;
import model.strategy.StrategyPedido;

/**
 *
 * @author Italo
 */
public class PedidoControl {
    
    private StrategyPedido pedido;
    
    public PedidoControl(){
        pedido = new Pedido();
    }
    
    public boolean salvaPedido(int id_pizza, int id_cliente) throws Exception{
        return pedido.salvar_pedido(id_pizza, id_cliente);
    }
    
    public PedidoDTO listarPedidos() throws Exception{
        return (PedidoDTO) pedido.listar_pedido();
    }
    
    public int quant_pedidosCli(int idCli) throws Exception{
        return (int) pedido.verificaQuantPedidos(idCli);
    }
   
}
