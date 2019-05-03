package model;

import dao.Adapter.AdapterCliente;
import dao.Adapter.ServicePessoa;
import model.strategy.InterfaceCrudPessoa;

public class Cliente implements InterfaceCrudPessoa{

    private String nome;
    private String telefone;
    private String endereco;
    private String cpf;
    private int id;
    
    private ServicePessoa serviceC;

    public Cliente() {
        serviceC = new AdapterCliente();
    }
    
    
    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public boolean salvar(String nome, String cpf, String telefone, String login, String senha, String cargo, String endereco, int nivel_acesso) throws Exception {
        return serviceC.salvar(nome, cpf, telefone, null, null, null, endereco, 0);
    }

    @Override
    public boolean excluir(int id) throws Exception {
      return serviceC.excluir(id);
    }

    @Override
    public Object listar() throws Exception {
       return serviceC.exibir();
    }

    @Override
    public boolean atualizar(Object obj) throws Exception {
        return serviceC.atualizar(obj);
    }

    @Override
    public Object buscar(Object id) throws Exception {
      return serviceC.buscar_por_nome(nome);
    }

    @Override
    public Object logarSistema(String l, String s) throws Exception {
       return null;
    }

}
