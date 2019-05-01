package dao.Adapter;
import dto.ClienteDTO;

public class AdapterCliente extends ServiceCliente implements ServicePessoa{
    
    @Override
    public boolean salvar(Object obj) throws Exception{
        return super.salvar_cliente((ClienteDTO) obj);
    }

    @Override
    public Object exibir() throws Exception {
        return super.listar_clientes();
    }

    @Override
    public boolean excluir(int id) throws Exception {
        return super.excluir_cliente(id);
    }

    @Override
    public boolean atualizar(Object obj) throws Exception {
        return super.atualizar_cliente((ClienteDTO) obj);
    }

    @Override
    public Object acessar_sistema(String login, String senha) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object buscar_por_nome(String nome) throws Exception {
        return super.buscar_cliente_nome(nome);
    }
    
}
