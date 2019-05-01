/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.Adapter.AdapterFuncionario;
import dao.Adapter.ServicePessoa;
import dto.FuncionarioDTO;

/**
 *
 * @author Italo
 */
public class Funcionario {

    private String nome;
    private String login;
    private String senha;
    private int nivel_acesso;
    private String cargo;
    private int id;
    
    // Criando uma instancia da interface ServicePessoa
    private ServicePessoa service;
    
    public Funcionario(){
        // Através de polimorfismo eu criei uma instância de adapter funcionario.
        
        service = new AdapterFuncionario();
    }

    public Funcionario(int nivel) {
        this.nivel_acesso = nivel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setNivel_acesso(int nivel_acesso) {
        this.nivel_acesso = nivel_acesso;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean salvarFuncionario(FuncionarioDTO obj) throws Exception {
        return service.salvar(obj);
    }

    public boolean atualizarFuncionario(FuncionarioDTO obj) throws Exception {
        return service.atualizar(obj);

    }

    public FuncionarioDTO listarFuncionarios() throws Exception {
        return (FuncionarioDTO) service.exibir();
    }

    public boolean excluirFuncionario(int id) throws Exception {
        return service.excluir(id);
    }

    public FuncionarioDTO logarSistema(String loginF, String senhaF) throws Exception {
       return (FuncionarioDTO) service.acessar_sistema(loginF, senhaF);
    }
}
