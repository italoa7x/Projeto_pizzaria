/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.Adapter.AdapterFuncionario;
import dao.Adapter.ServicePessoa;

/**
 *
 * @author Italo
 */
public class Funcionario{

    private String nome;
    private String login;
    private String senha;
    private int nivel_acesso;
    private String cargo;
    private int id;

    private ServicePessoa serviceF;

    public Funcionario() {
        serviceF = new AdapterFuncionario();
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

    public boolean salvar(Object obj) throws Exception {
        return serviceF.salvar(obj);
    }

    public boolean excluir(int id) throws Exception {
        return serviceF.excluir(id);
    }

    public Object listar() throws Exception {
        return serviceF.exibir();
    }

    public boolean atualizar(Object obj) throws Exception {
        return serviceF.atualizar(obj);
    }


    public Object logarSistema(String l, String s) throws Exception {
        return serviceF.acessar_sistema(l, s);
    }

}
