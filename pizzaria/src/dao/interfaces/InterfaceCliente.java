/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.interfaces;

import dto.ClienteDTO;

/**
 *
 * @author italo
 */
public interface InterfaceCliente {
    
    public boolean salva(ClienteDTO obj) throws Exception;
    
    public boolean deletar(int id) throws Exception;
    
    public ClienteDTO listar () throws Exception;
    
    public boolean atualizar (ClienteDTO obj) throws Exception;
    
    public ClienteDTO buscar(String nome) throws Exception;
}
