package model;

import dao.PedidoDAO;
import dao.interfaces.InterfacePedido;
import model.strategy.InterfaceCrudPedido;

public class Pedido implements InterfaceCrudPedido{

    private String status;
    private Pizza pizza;
    private Cliente cliente;
    private int id;
  
    private InterfacePedido interfaceP;

    public Pedido() {
        interfaceP = new PedidoDAO();
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

    @Override
    public boolean salvarPedido(int idPizza, int idCli) throws Exception {
       return interfaceP.salva(idPizza, idCli);
    }

    @Override
    public Object listar() throws Exception {
        return interfaceP.listar();
    }

    @Override
    public Object verificarQuantPedidos(int idCli) throws Exception {
        return interfaceP.verificaQuantPedidos(idCli);
    }

}
