package model.strategy;

public interface InterfaceCrudPessoa {
    
    public boolean salvar(String nome, String cpf, String telefone, String login, String senha, String cargo, String endereco, int nivel_acesso) throws Exception;
    
    public boolean excluir(int id) throws Exception;
    
    public Object listar() throws Exception;
    
    public boolean atualizar(Object obj) throws Exception;
    
    public Object buscar(Object id) throws Exception;
    
    public Object logarSistema(String l, String s) throws Exception;
}
