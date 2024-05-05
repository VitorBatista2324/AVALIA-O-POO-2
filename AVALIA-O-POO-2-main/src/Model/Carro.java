package Model;

import Enums.TipoCarroEnum;

public abstract class Carro extends Veiculo {
    private TipoCarroEnum tipoCarroEnum;
    private int cavalaria;

    public Carro(String marca, String modelo, TipoCarroEnum tipocarro, int cavalaria) {
        super(marca, modelo);
        this.cavalaria = cavalaria;
        this.tipoCarroEnum = tipocarro;
    }

    public TipoCarroEnum getTipoCarro() {
        return tipoCarroEnum;
    }

    public void setTipoCarro(TipoCarroEnum tipoCarroEnum) {
        this.tipoCarroEnum = tipoCarroEnum;
    }

    public int getPotencia() {
        return cavalaria;
    }

    public void setCavalaria(int cavalaria) {
        this.cavalaria = cavalaria;
    }

}

