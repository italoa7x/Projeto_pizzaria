package factory;

import dto.FuncionarioDTO;

public class FactoryFuncionarioDTO implements Pessoa {
    @Override
    public FuncionarioDTO criar() {
        return new FuncionarioDTO();
    }
}
