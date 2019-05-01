/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.ArrayList;

/**
 *
 * @author italo
 */
public class ClienteDTO {

    private String nome;
    private String telefone;
    private String endereco;
    private String cpf;
    private int id;
    private ArrayList<ClienteDTO> clientesCadastrados;


    public String getNome() {
        return nome;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<ClienteDTO> getClientesCadastrados() {
        return clientesCadastrados;
    }

    public void setClientesCadastrados(ArrayList<ClienteDTO> clientesCadastrados) {
        this.clientesCadastrados = clientesCadastrados;
    }

}
