package Model;

import Contratos.IAcao1;
import Contratos.IAcao2;
import Enums.TipoCarroEnum;

public class Carro2 extends Carro implements IAcao1, IAcao2 {
    public Carro2(String marca, String modelo, TipoCarroEnum tipocarro, int cavalaria) {
        super(marca, modelo, tipocarro, cavalaria);
    }
    @Override
    public void acao1(){
        System.out.println("dasda");
    }
    @Override
    public void acao2(){
        System.out.println("dasda");
    }
}