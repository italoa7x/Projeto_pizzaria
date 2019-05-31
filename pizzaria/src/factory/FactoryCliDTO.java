package factory;

import dto.ClienteDTO;

public class FactoryCliDTO implements Pessoa {

    @Override
    public ClienteDTO criar() {
        return new ClienteDTO();
    }
}
