package model.strategy;

public interface InterfaceCrudPessoa {
    
    public boolean salvar(Object obj) throws Exception;
    
    public boolean excluir(int id) throws Exception;
    
    public Object listar() throws Exception;
    
    public boolean atualizar(Object obj) throws Exception;
    
    public Object buscar(Object id) throws Exception;
    
    public Object logarSistema(String l, String s) throws Exception;
}
