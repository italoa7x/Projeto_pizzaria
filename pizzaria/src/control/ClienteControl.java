package control;

import dao.Adapter.AdapterCliente;
import dao.Adapter.ServicePessoa;
import dto.ClienteDTO;

/**
 *
 * @author Italo
 */
public class ClienteControl {
    private ServicePessoa adpCliente;
    
    public ClienteControl(){
        adpCliente = new AdapterCliente();
    }
    public boolean salvaCliente(String nome, String cpf, String telefone, String login, String senha, String cargo, String endereco, int nivel_acesso) throws Exception {
      return adpCliente.salvar(nome, cpf, telefone, null, null, null, endereco, nivel_acesso);
    }
    
    public boolean atualizarCliente(ClienteDTO obj)throws Exception{
        return adpCliente.atualizar(obj);
    }
    
    public boolean excluir(int id) throws Exception{
        return adpCliente.excluir(id);
    }
    
    public ClienteDTO buscar(String nome) throws Exception{
        return (ClienteDTO) adpCliente.buscar_por_nome(nome);
    }
    
    public ClienteDTO listarClientes() throws Exception{
        return (ClienteDTO) adpCliente.exibir();
    }
}
