package control;

import dto.ClienteDTO;
import model.Cliente;

/**
 *
 * @author Italo
 */
public class ClienteControl {
    private Cliente cliente;
    
    public ClienteControl(){
        cliente = new Cliente();
    }
    public boolean salvaCliente(ClienteDTO obj) throws Exception {
      return cliente.salvaCliente(obj);
    }
    
    public boolean atualizarCliente(ClienteDTO obj)throws Exception{
        return cliente.atualizarCliente(obj);
    }
    
    public boolean excluir(int id) throws Exception{
        return cliente.excluirCliente(id);
    }
    
    public ClienteDTO buscar(String nome) throws Exception{
        return cliente.buscar(nome);
    }
    
    public ClienteDTO listarClientes() throws Exception{
        return cliente.listarCliente();
    }
}
