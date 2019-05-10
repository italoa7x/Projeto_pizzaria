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
    
      
    public int salva(PizzaDTO obj) throws Exception;
    
    public boolean deletar(int id) throws Exception;
    
    public PizzaDTO listar () throws Exception;
    
    public ArrayList<String> verSabores(int id) throws Exception;
    
    public boolean salva_ingredientes(int id, String[] sabores) throws Exception;
}
