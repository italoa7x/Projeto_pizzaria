package model.facades;

import dao.Adapter.AdapterFuncionario;
import dao.Adapter.ServicePessoa;
import dto.FuncionarioDTO;
import model.strategy.InterfaceCrudPessoa;

public class FacadeFuncionario implements InterfaceCrudPessoa{
    private ServicePessoa apdFun;

    public FacadeFuncionario() {
        apdFun = new AdapterFuncionario();
    }
    
    
    @Override
    public boolean salvar(Object obj) throws Exception {
        return apdFun.salvar((FuncionarioDTO) obj);
    }

    @Override
    public boolean excluir(int id) throws Exception {
       return apdFun.excluir(id);
    }

    @Override
    public Object listar() throws Exception {
       return apdFun.exibir();
    }

    @Override
    public boolean atualizar(Object obj) throws Exception {
       return apdFun.atualizar((FuncionarioDTO) obj);
    }

    @Override
    public Object buscar(Object id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object logarSistema(String l, String s) throws Exception {
      return apdFun.acessar_sistema(l, s);
    }
    
}
