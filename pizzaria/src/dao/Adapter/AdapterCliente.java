package dao.Adapter;
import dao.ClienteDAO;
import dto.ClienteDTO;

public class AdapterCliente extends ClienteDAO implements ServicePessoa{

    @Override
    public boolean salvar(String nome, String cpf, String telefone, String login, String senha, String cargo, String endereco, int nivel_acesso) throws Exception{
        ClienteDTO clidto = new ClienteDTO();
        clidto.setNome(nome);
        clidto.setEndereco(endereco);
        clidto.setCpf(cpf);
        clidto.setTelefone(telefone);
        return super.salva(clidto);
    }

    @Override
    public Object exibir() throws Exception {
        return super.listar();
    }

    @Override
    public boolean excluir(int id) throws Exception {
        return super.deletar(id);
    }

    @Override
    public boolean atualizar(Object obj) throws Exception {
        return super.atualizar((ClienteDTO) obj);
    }

    @Override
    public Object acessar_sistema(String login, String senha) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object buscar_por_nome(String nome) throws Exception {
        return super.buscar(nome);
    }
    
}
