/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author italo
 */
public class PizzaDTO {

    private String tamanho;
    private double valor;
    private double fatia;
    private String[] sabores;
    private int id;
    private String nome;
    private int quant_fatias;
    private ArrayList<PizzaDTO> pizzasCadastradas;

    public PizzaDTO(String tamanho, double valor, double valorFatia,String[] sabores, String nome, int qnt_fatias) {
        this.nome = nome;
        this.tamanho = tamanho;
        this.quant_fatias = qnt_fatias;
        this.sabores = sabores;
        this.valor = valor;
        this.fatia = valorFatia;
    }

    public PizzaDTO() {

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuant_fatias() {
        return quant_fatias;
    }

    public void setQuant_fatias(int quant_fatias) {
        this.quant_fatias = quant_fatias;
    }

    public ArrayList<PizzaDTO> getPizzasCadastradas() {
        return pizzasCadastradas;
    }

    public void setPizzasCadastradas(ArrayList<PizzaDTO> pizzasCadastradas) {
        this.pizzasCadastradas = pizzasCadastradas;
    }

}
