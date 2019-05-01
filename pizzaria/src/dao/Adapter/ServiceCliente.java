package dao.Adapter;

import dao.ClienteDAO;
import dto.ClienteDTO;

public class ServiceCliente {
    private ClienteDAO daoC;

    public ServiceCliente() {
        daoC = new ClienteDAO();
    }
    
    
    public boolean salvar_cliente(ClienteDTO obj) throws Exception {
        return daoC.salva(obj);
    }
    
    public boolean excluir_cliente(int id) throws Exception{
        return daoC.deletar(id);
    }
    
    public ClienteDTO listar_clientes() throws Exception{
        return daoC.listar();
    }

    public boolean atualizar_cliente(ClienteDTO obj) throws Exception{
        return daoC.atualizar(obj);
    }
    
    public ClienteDTO buscar_cliente_nome(String nome) throws Exception{
        return daoC.buscar(nome);
    }
}
