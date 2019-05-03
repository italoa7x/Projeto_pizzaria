package model.facades;

import dao.Adapter.AdapterCliente;
import dao.Adapter.ServicePessoa;
import dto.ClienteDTO;
import model.strategy.InterfaceCrudPessoa;

public class FacadeCliente implements InterfaceCrudPessoa{
    private ServicePessoa adpCli;

    public FacadeCliente() {
        adpCli = new AdapterCliente();
    }
    
    @Override
    public boolean salvar(Object obj) throws Exception {
        return adpCli.salvar(obj);
    }

    @Override
    public boolean excluir(int id) throws Exception {
       return adpCli.excluir(id);
    }

    @Override
    public Object listar() throws Exception {
       return adpCli.exibir();
    }

    @Override
    public boolean atualizar(Object obj) throws Exception {
       return adpCli.atualizar((ClienteDTO) obj);
    }

    @Override
    public Object buscar(Object id) throws Exception {
       return adpCli.buscar_por_nome((String) id);
    }

    @Override
    public Object logarSistema(String l, String s) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
