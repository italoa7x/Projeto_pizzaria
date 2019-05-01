/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.interfaces.InterfacePizza;
import dao.*;
import dto.PizzaDTO;
import java.util.ArrayList;

/**
 *
 * @author Italo
 */
public class Pizza {

    private String tamanho;
    private double valor;
    private double fatia;
    private String[] sabores;
    private int id;
    private String nome;
    private int quant_fatias;
    private InterfacePizza pizzaDao;
    
    public Pizza(){
        pizzaDao = new PizzaDAO();
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
    //////////////////////// AREA QUE SE COMUNICA COM O DAO //////////////////////
    public boolean salvarPizza(PizzaDTO obj) throws Exception {
        return pizzaDao.salva(obj);
    }

    public PizzaDTO listarPizza() throws Exception {
       return pizzaDao.listar();
    }

    public ArrayList<String> verSabores(int id) throws Exception {
        return pizzaDao.verSabores(id);
    }

    public boolean excluirPizza(int id) throws Exception {
       return pizzaDao.deletar(id);
    }
    public int salvaPizzaPersonalizada(PizzaDTO obj)throws Exception{
        return pizzaDao.salvaPizzaPersonalizada(obj);
    }
}
