package view.factory;

import dto.FuncionarioDTO;

public class FactoryFuncionarioDTO implements Pessoa {
    @Override
    public Object criar() {
        return new FuncionarioDTO();
    }
}
