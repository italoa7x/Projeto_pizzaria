package control;

import dao.Adapter.AdapterFuncionario;
import dao.Adapter.ServicePessoa;
import dto.FuncionarioDTO;

/**
 *
 * @author Italo
 */
public class FuncionarioControl {

    private ServicePessoa adpFuncionario;

    public FuncionarioControl() {
        adpFuncionario = new AdapterFuncionario();

    }

    public boolean salvarFuncionario(String nome, String cpf, String telefone, String login, String senha, String cargo, String endereco, int nivel_acesso) throws Exception {
        return adpFuncionario.salvar(nome, null, null, login, senha, cargo, null, nivel_acesso);
    }
    
    public boolean excluirFuncionario (int id) throws Exception{
        return adpFuncionario.excluir(id);
    }
    
    public FuncionarioDTO listarFuncionario() throws Exception{
        return (FuncionarioDTO) adpFuncionario.exibir();
    }
    
    public boolean atualizarFuncionario(FuncionarioDTO obj) throws Exception{
        return adpFuncionario.atualizar(obj);
    }
    
    public FuncionarioDTO logarSistema(String loginF, String senhaF) throws Exception {
        return (FuncionarioDTO) adpFuncionario.acessar_sistema(loginF,senhaF);
    }
  
}
