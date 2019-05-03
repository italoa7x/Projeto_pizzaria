/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.PizzaDAO;
import dao.interfaces.InterfacePizza;
import dto.PizzaDTO;
import model.strategy.InterfaceCrudPizza;

/**
 *
 * @author Italo
 */
public class Pizza implements InterfaceCrudPizza {

    private String tamanho;
    private double valor;
    private double fatia;
    private String[] sabores;
    private int id;
    private String nome;
    private int quant_fatias;

    private InterfacePizza interfacePi;

    public Pizza() {
        interfacePi = new PizzaDAO();
    }

    public int getQuant_fatias() {
        return quant_fatias;
    }

    public void setQuant_fatias(int quant_fatias) {
        this.quant_fatias = quant_fatias;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getFatia() {
        return fatia;
    }

    public void setFatia(double fatia) {
        this.fatia = fatia;
    }

    public String[] getSabores() {
        return sabores;
    }

    public void setSabores(String[] sabores) {
        this.sabores = sabores;
    }

    @Override
    public boolean salvar(Object obj) throws Exception {
        return interfacePi.salva((PizzaDTO) obj);
    }

    @Override
    public int salvarPersonalizada(Object obj) throws Exception {
        return interfacePi.salvaPizzaPersonalizada((PizzaDTO) obj);
    }

    @Override
    public Object listar() throws Exception {
        return interfacePi.listar();
    }

    @Override
    public Object verSabores(int id) throws Exception {
        return interfacePi.verSabores(id);
    }

    @Override
    public boolean excluir(int id) throws Exception {
        return interfacePi.deletar(id);
    }

}
