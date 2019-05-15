/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.iterator;

import dto.FuncionarioDTO;

/**
 *
 * @author italo
 */
public interface IteratorF {
    
    public boolean hasnext();
    
    public FuncionarioDTO next();
}
