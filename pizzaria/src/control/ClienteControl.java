package control;

import dto.ClienteDTO;
import model.facades.FacadeCliente;
import model.strategy.InterfaceCrudPessoa;

/**
 *
 * @author Italo
 */
public class ClienteControl {
    private InterfaceCrudPessoa facadeCli;
    
    public ClienteControl(){
        facadeCli = new FacadeCliente();
    }
    public boolean salvaCliente(ClienteDTO obj) throws Exception {
      return facadeCli.salvar(obj);
    }
    
    public boolean atualizarCliente(ClienteDTO obj)throws Exception{
        return facadeCli.atualizar(obj);
    }
    
    public boolean excluir(int id) throws Exception{
        return facadeCli.excluir(id);
    }
    
    public ClienteDTO buscar(String nome) throws Exception{
        return (ClienteDTO) facadeCli.buscar(nome);
    }
    
    public ClienteDTO listarClientes() throws Exception{
        return (ClienteDTO) facadeCli.listar();
    }
}
