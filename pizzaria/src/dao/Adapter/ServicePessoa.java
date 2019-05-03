/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Adapter;

/**
 *
 * @author Italo
 */
public interface ServicePessoa {
    
    public  boolean salvar(String nome, String cpf, String telefone, String login, String senha, String cargo, String endereco, int nivel_acesso) throws Exception;
    
    public Object exibir() throws Exception;
    
    public boolean excluir (int id) throws Exception;
    
    public boolean atualizar(Object obj) throws Exception;
    
    public Object acessar_sistema(String login, String senha) throws Exception;
    
    public Object buscar_por_nome(String nome) throws Exception;
}
