package control;

import dto.FuncionarioDTO;
import model.facades.FacadeFuncionario;
import model.strategy.InterfaceCrudPessoa;

/**
 *
 * @author Italo
 */
public class FuncionarioControl {

    private InterfaceCrudPessoa facadeFun;

    public FuncionarioControl() {
        facadeFun = new FacadeFuncionario();

    }

    public boolean salvarFuncionario(FuncionarioDTO obj) throws Exception {
        return facadeFun.salvar(obj);
    }
    
    public boolean excluirFuncionario (int id) throws Exception{
        return facadeFun.excluir(id);
    }
    
    public FuncionarioDTO listarFuncionario() throws Exception{
        return (FuncionarioDTO) facadeFun.listar();
    }
    
    public boolean atualizarFuncionario(FuncionarioDTO obj) throws Exception{
        return facadeFun.atualizar(obj);
    }
    
    public FuncionarioDTO logarSistema(String loginF, String senhaF) throws Exception {
        return (FuncionarioDTO) facadeFun.logarSistema(loginF,senhaF);
    }
  
}
