package view.factoryMethod;

import model.Atendente;

/**
 *
 * @author italo
 */
public class FactoryPessoa extends FabricaMaster {

    @Override
    public Object gerar(String tipo) {
       if(tipo.equalsIgnoreCase("cliente")){
           return new ClienteFactory();
       }else if(tipo.equals("funcionario")){
           return new FuncionarioFactory();
       }
       return null;
    }

}
