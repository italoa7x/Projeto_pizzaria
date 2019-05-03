package dao.Adapter;

import dao.FuncionarioDAO;
import dto.FuncionarioDTO;

public class AdapterFuncionario extends FuncionarioDAO implements ServicePessoa{

    @Override
    public boolean salvar(String nome, String cpf, String telefone, String login, String senha, String cargo, String endereco, int nivel_acesso) throws Exception {
        FuncionarioDTO fdto = new FuncionarioDTO();
        fdto.setNome(nome);
        fdto.setCargo(cargo);
        fdto.setNivel_acesso(nivel_acesso);
        fdto.setLogin(login);
        fdto.setSenha(senha);
        return super.salva(fdto);
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
        return super.atualizar((FuncionarioDTO) obj);
    }

    @Override
    public Object acessar_sistema(String login, String senha) throws Exception {
        return super.AcessarSistema(login, senha);
    }

    @Override
    public Object buscar_por_nome(String nome) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
}
