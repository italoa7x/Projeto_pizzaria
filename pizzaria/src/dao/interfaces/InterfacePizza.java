/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.interfaces;

import dto.PizzaDTO;
import java.util.ArrayList;

/**
 *
 * @author italo
 */
public interface InterfacePizza {
    
      
    public boolean salva(PizzaDTO obj) throws Exception;
    
    public int salvaPizzaPersonalizada(PizzaDTO obj) throws Exception;
    
    public boolean deletar(int id) throws Exception;
    
    public PizzaDTO listar () throws Exception;
    
    public boolean atualizar (Object obj) throws Exception;
    
    public Object buscar(Object obj) throws Exception;
    
    public ArrayList<String> verSabores(int id) throws Exception;
    
}
