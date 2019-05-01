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
public class PedidoDTO {

    private String status;
    private PizzaDTO pizza;
    private ClienteDTO cliente;
    private int id;
    private ArrayList<PedidoDTO> pedidosCadastrados;

    public PedidoDTO(ClienteDTO cli, PizzaDTO pi, String status) {
        this.pizza = pi;
        this.cliente = cli;
        this.status = status;

    }

    public PedidoDTO() {

    }

    public ArrayList<PedidoDTO> getPedidosCadastrados() {
        return pedidosCadastrados;
    }

    public void setPedidosCadastrados(ArrayList<PedidoDTO> pedidosCadastrados) {
        this.pedidosCadastrados = pedidosCadastrados;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public PizzaDTO getPizza() {
        return pizza;
    }

    public void setPizza(PizzaDTO pizza) {
        this.pizza = pizza;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
