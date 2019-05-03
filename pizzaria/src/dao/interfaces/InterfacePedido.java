/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.interfaces;

import dto.PedidoDTO;
import java.sql.SQLException;

/**
 *
 * @author italo
 */
public interface InterfacePedido {
    
      
    public boolean salva(int idPizza, int idCli) throws Exception;
    
    public PedidoDTO listar () throws Exception;
    
    public int verificaQuantPedidos (int idCli) throws Exception;
    
}
