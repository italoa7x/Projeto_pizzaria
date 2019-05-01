/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.interfaces;

import dto.FuncionarioDTO;
import java.sql.SQLException;

/**
 *
 * @author italo
 */
public interface InterfaceFuncionario {
      
    public boolean salva(FuncionarioDTO obj) throws Exception;
    
    public boolean deletar(int obj) throws Exception;
    
    public FuncionarioDTO listar () throws Exception;
    
    public boolean atualizar (FuncionarioDTO obj) throws Exception;
    
    public FuncionarioDTO AcessarSistema(String login, String senha) throws Exception;
}
