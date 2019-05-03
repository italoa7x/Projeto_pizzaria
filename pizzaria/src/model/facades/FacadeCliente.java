package model.facades;

import dao.ClienteDAO;
import dao.interfaces.InterfaceCliente;
import dto.ClienteDTO;
import model.strategy.InterfaceCrudPessoa;

public class FacadeCliente implements InterfaceCrudPessoa{
    private InterfaceCliente daoCli;

    public FacadeCliente() {
        daoCli = new ClienteDAO();
    }
    
    @Override
    public boolean salvar(Object obj) throws Exception {
        return daoCli.salva((ClienteDTO) obj);
    }

    @Override
    public boolean excluir(int id) throws Exception {
       return daoCli.deletar(id);
    }

    @Override
    public Object listar() throws Exception {
       return daoCli.listar();
    }

    @Override
    public boolean atualizar(Object obj) throws Exception {
       return daoCli.atualizar((ClienteDTO) obj);
    }

    @Override
    public Object buscar(Object id) throws Exception {
       return daoCli.buscar((String) id);
    }

    @Override
    public Object logarSistema(String l, String s) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
