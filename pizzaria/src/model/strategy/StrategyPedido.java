package model.strategy;
/**
 *
 * @author italo
 */
public interface StrategyPedido {
    
    public boolean salvar_pedido(int id_pizza, int id_cliente) throws Exception;
    
    public Object listar_pedido() throws Exception;
    
    public Object verificaQuantPedidos(int id_cliente) throws Exception;
    
    public boolean preparar_pedido(int id_pedido) throws Exception;
    
    public boolean entregar_pedido(String status, int id_pedido) throws Exception;
}
