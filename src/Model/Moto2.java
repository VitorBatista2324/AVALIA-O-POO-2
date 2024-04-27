package Model;

import Contratos.IAcao1;
import Contratos.IAcao2;
import Enums.TipoMotoEnum;

public class Moto2 extends Moto implements IAcao1, IAcao2 {
    public Moto2(String marca, String modelo, TipoMotoEnum tipoMotosEnum, int cavalaria) {
        super(marca, modelo, tipoMotosEnum, cavalaria);
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
