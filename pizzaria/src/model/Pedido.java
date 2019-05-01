/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.interfaces.InterfacePedido;
import dao.PedidoDAO;
import dto.PedidoDTO;

/**
 *
 * @author Italo
 */
public class Pedido {

    private String status;
    private Pizza pizza;
    private Cliente cliente;
    private int id;
    
    private InterfacePedido pedidoDAO;
    
    public Pedido(){
        pedidoDAO = new PedidoDAO();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public boolean salvarPedido(int id_pizza, int id_cliente) throws Exception {
        return pedidoDAO.salva(id_cliente, id_pizza);
    }

    public PedidoDTO listarPedidos() throws Exception {
       return pedidoDAO.listar();
    }

    public int verificaQntPedidos(int idCli) throws Exception {
        return pedidoDAO.verificaQuantPedidos(idCli);
    }
}
