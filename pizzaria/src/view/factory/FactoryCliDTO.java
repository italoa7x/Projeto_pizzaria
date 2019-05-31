package view.factory;

import dto.ClienteDTO;

public class FactoryCliDTO implements Pessoa {

    @Override
    public Object criar() {
        return new ClienteDTO();
    }
}
