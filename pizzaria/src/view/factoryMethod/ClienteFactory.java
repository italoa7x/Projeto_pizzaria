package view.factoryMethod;
import control.ClienteControl;
import dto.ClienteDTO;

public class ClienteFactory extends FabricaMaster{

    private Pessoa cliente;

    @Override
    public Pessoa gerar(String tipo) {
        if(tipo.toUpperCase().equals("DTO")){
            cliente = new ClienteDTO();
        } else if(tipo.toUpperCase().equals("CONTROL")){
            cliente = new ClienteControl();
        }
        return cliente;
    }

}
