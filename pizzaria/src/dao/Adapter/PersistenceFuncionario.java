package dao.Adapter;

import dao.FuncionarioDAO;
import dto.FuncionarioDTO;

public class PersistenceFuncionario {
    private FuncionarioDAO daoF;

    public PersistenceFuncionario() {
        daoF = new FuncionarioDAO();
    }

    public boolean salvar(FuncionarioDTO obj) throws Exception {
        return daoF.salva(obj);
    }

    public boolean excluir_funcionario(int id) throws Exception {
        return daoF.deletar(id);
    }

    public FuncionarioDTO listar_funcionarios() throws Exception {
        return daoF.listar();
    }

    public boolean atualizar_funcionario(FuncionarioDTO obj) throws Exception {
        return daoF.atualizar(obj);
    }

    public FuncionarioDTO logar_sistema(String loging, String senha) throws Exception{
        return daoF.AcessarSistema(loging, senha);
    }
}
