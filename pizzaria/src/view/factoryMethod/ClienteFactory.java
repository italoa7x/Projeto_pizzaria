package view.factoryMethod;

import control.ClienteControl;
import dto.ClienteDTO;

public class ClienteFactory implements Pessoa {

    @Override
    public Object gerar(String tipo) {
       if (tipo.toUpperCase().equals("CONTROL")) {
            return new ClienteControl();
        } else if (tipo.toUpperCase().equals("DTO")){
            return new ClienteDTO();
        }
        return null;
    }

}
