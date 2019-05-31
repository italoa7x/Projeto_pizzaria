package model;

import dao.Adapter.AdapterCliente;
import dao.Adapter.ServicePessoa;

public class Cliente{

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

    public boolean salvar(Object obj) throws Exception {
        return serviceC.salvar(obj);
    }

    public boolean excluir(int id) throws Exception {
      return serviceC.excluir(id);
    }

    public Object listar() throws Exception {
       return serviceC.exibir();
    }

    public boolean atualizar(Object obj) throws Exception {
        return serviceC.atualizar(obj);
    }

    public Object buscar(Object id) throws Exception {
      return serviceC.buscar_por_nome((String) id);
    }

}
