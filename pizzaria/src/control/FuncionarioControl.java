/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dto.FuncionarioDTO;
import model.Funcionario;

/**
 *
 * @author Italo
 */
public class FuncionarioControl {

    private Funcionario funcionario;

    public FuncionarioControl() {
        funcionario = new Funcionario();

    }

    public boolean salvarFuncionario(FuncionarioDTO obj) throws Exception {
        return funcionario.salvarFuncionario(obj);
    }
    
    public boolean excluirFuncionario (int id) throws Exception{
        return funcionario.excluirFuncionario(id);
    }
    
    public FuncionarioDTO listarFuncionario() throws Exception{
        return funcionario.listarFuncionarios();
    }
    
    public boolean atualizarFuncionario(FuncionarioDTO obj) throws Exception{
        return funcionario.atualizarFuncionario(obj);
    }
    
    public FuncionarioDTO logarSistema(String loginF, String senhaF) throws Exception {
        return funcionario.logarSistema(loginF,senhaF);
    }
  
}
