/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.Adapter.AdapterCliente;
import dao.Adapter.ServicePessoa;
import dto.ClienteDTO;

/**
 *
 * @author Italo
 */
public class Cliente {

    private String nome;
    private String telefone;
    private String endereco;
    private String cpf;
    private int id;

    /// instanciamento de uma interface ServicePessoa
    ServicePessoa service;

    public Cliente() {
        //através da interface pessoa, criei uma instancia de adapter cliente.
        service = new dao.Adapter.AdapterCliente();
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

    public boolean salvaCliente(ClienteDTO obj) throws Exception {
        return service.salvar(obj);
    }

    public boolean atualizarCliente(ClienteDTO obj) throws Exception {
        return service.atualizar(obj);
    }

    public ClienteDTO listarCliente() throws Exception {
        return (ClienteDTO) service.exibir();
    }

    public boolean excluirCliente(int id) throws Exception {
        return service.excluir(id);
    }

    public ClienteDTO buscar(String nome) throws Exception {
        return (ClienteDTO) service.buscar_por_nome(nome);

    }
}
