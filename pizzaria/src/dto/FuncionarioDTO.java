/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.ArrayList;
import view.factoryMethod.Pessoa;

/**
 *
 * @author italo
 */
public class FuncionarioDTO extends Pessoa{

    private String nome;
    private String login;
    private String senha;
    private int nivel_acesso;
    private String cargo;
    private int id;
    private ArrayList<FuncionarioDTO> funcionarioCadastrados;


    public ArrayList<FuncionarioDTO> getFuncionarioCadastrados() {
        return funcionarioCadastrados;
    }

    public void setFuncionarioCadastrados(ArrayList<FuncionarioDTO> funcionarioCadastrados) {
        this.funcionarioCadastrados = funcionarioCadastrados;
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

    public int getNivel_acesso() {
        return nivel_acesso;
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

}
