package model;

import dao.PedidoDAO;
import dao.interfaces.InterfacePedido;
import model.strategy.StrategyPedido;

public class Pedido implements StrategyPedido{

    private String status;
    private Pizza pizza;
    private Cliente cliente;
    private int id;
  
    private InterfacePedido interfaceP;

    public Pedido(){
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

//    public boolean salvarPedido(int idPizza, int idCli) throws Exception {
//       return interfaceP.salva(idPizza, idCli);
//    }
//
//    public Object listar() throws Exception {
//        return interfaceP.listar();
//    }
//
//    public Object verificarQuantPedidos(int idCli) throws Exception {
//        return interfaceP.verificaQuantPedidos(idCli);
//    }

    @Override
    public boolean salvar_pedido(int id_pizza, int id_cliente) throws Exception {
        return interfaceP.salva(id_pizza, id_cliente);
    }

    @Override
    public Object listar_pedido() throws Exception {
        return interfaceP.listar();
    }


    @Override
    public Object verificaQuantPedidos(int id_cliente) throws Exception {
        return interfaceP.verificaQuantPedidos(id_cliente);
    }

    @Override
    public boolean preparar_pedido(int id_pedido) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean entregar_pedido(String status, int id_pedido) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



}
