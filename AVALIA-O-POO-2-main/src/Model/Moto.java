package Model;

import Enums.TipoMotoEnum;

public abstract class Moto extends Veiculo {
    private TipoMotoEnum tipoMotosEnum;
    private int cavalaria;
    private int velocidade;

    public Moto(String marca, String modelo, TipoMotoEnum tipoMotosEnum, int cavalaria){
        super(marca,modelo);
        this.cavalaria = cavalaria;
        this.tipoMotosEnum = tipoMotosEnum;


    }

    public TipoMotoEnum getTipoMotos() {
        return tipoMotosEnum;
    }

    public void setTipoMotos(TipoMotoEnum tipoMotosEnum) {
        this.tipoMotosEnum = tipoMotosEnum;
    }

    public int getPotencia() {
        return cavalaria;
    }

    public void setCavalaria(int cavalaria) {
        this.cavalaria = cavalaria;

    }




}
