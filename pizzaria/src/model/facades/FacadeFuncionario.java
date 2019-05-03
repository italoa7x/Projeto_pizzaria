package model.facades;

import dao.FuncionarioDAO;
import dao.interfaces.InterfaceFuncionario;
import dto.FuncionarioDTO;
import model.strategy.InterfaceCrudPessoa;

public class FacadeFuncionario implements InterfaceCrudPessoa{
    private InterfaceFuncionario daoF;

    public FacadeFuncionario() {
        daoF = new FuncionarioDAO();
    }
    
    
    @Override
    public boolean salvar(Object obj) throws Exception {
        return daoF.salva((FuncionarioDTO) obj);
    }

    @Override
    public boolean excluir(int id) throws Exception {
       return daoF.deletar(id);
    }

    @Override
    public Object listar() throws Exception {
       return daoF.listar();
    }

    @Override
    public boolean atualizar(Object obj) throws Exception {
       return daoF.atualizar((FuncionarioDTO) obj);
    }

    @Override
    public Object buscar(Object id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object logarSistema(String l, String s) throws Exception {
      return daoF.AcessarSistema(l, s);
    }
    
}
