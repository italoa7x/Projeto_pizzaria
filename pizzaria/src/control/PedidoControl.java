/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dto.PedidoDTO;
import model.facades.FacadePedido;

/**
 *
 * @author Italo
 */
public class PedidoControl {
    
    private FacadePedido facadePedido;
    
    public PedidoControl(){
        facadePedido = new FacadePedido();
    }
    
    public boolean salvaPedido(int id_pizza, int id_cliente) throws Exception{
        return facadePedido.salvarPedido(id_pizza, id_cliente);
    }
    
    public PedidoDTO listarPedidos() throws Exception{
        return (PedidoDTO) facadePedido.listar();
    }
    
    public int quant_pedidosCli(int idCli) throws Exception{
        return (int) facadePedido.verificarQuantPedidos(idCli);
    }
   
}
