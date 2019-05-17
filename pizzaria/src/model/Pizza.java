package model;

import dao.PizzaDAO;
import dao.interfaces.InterfacePizza;
import dto.PizzaDTO;

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

    public boolean salvar(Object obj) throws Exception {
        PizzaDTO pizza = (PizzaDTO) obj;
        int id_gerado = interfacePi.salva(pizza);
        return interfacePi.salva_ingredientes(id_gerado, pizza.getSabores());
    }

    public int salvarPersonalizada(Object obj) throws Exception {
        PizzaDTO pizza = (PizzaDTO) obj;
        int id_gerado = interfacePi.salva(pizza);
        interfacePi.salva_ingredientes(id_gerado, pizza.getSabores());
        return id_gerado;
    }

    public Object listar() throws Exception {
        return interfacePi.listar();
    }

    public Object verSabores(int id) throws Exception {
        return interfacePi.verSabores(id);
    }

    public boolean excluir(int id) throws Exception {
        return interfacePi.deletar(id);
    }

}
