package dao.Adapter;

import dto.FuncionarioDTO;

public class AdapterFuncionario extends PersistenceFuncionario implements ServicePessoa{

    @Override
    public boolean salvar(Object obj) throws Exception {
        return super.salvar((FuncionarioDTO) obj);
    }

    @Override
    public Object exibir() throws Exception {
        return super.listar_funcionarios();
    }

    @Override
    public boolean excluir(int id) throws Exception {
        return super.excluir_funcionario(id);
    }

    @Override
    public boolean atualizar(Object obj) throws Exception {
        return super.atualizar_funcionario((FuncionarioDTO) obj);
    }

    @Override
    public Object acessar_sistema(String login, String senha) throws Exception {
        return super.logar_sistema(login, senha);
    }

    @Override
    public Object buscar_por_nome(String nome) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
}
