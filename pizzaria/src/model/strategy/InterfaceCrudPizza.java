/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.strategy;

/**
 *
 * @author Italo
 */
public interface InterfaceCrudPizza {
    
    public boolean salvar(Object obj) throws Exception;
    
    public int salvarPersonalizada(Object obj) throws Exception;
    
    public Object listar() throws Exception;
    
    public Object verSabores(int id) throws Exception;
    
    public boolean excluir(int id) throws Exception;
}
