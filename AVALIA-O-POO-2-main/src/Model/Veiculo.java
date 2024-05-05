package Model;

public abstract class Veiculo {
    private String marca;
    private String modelo;
    private int potencia;
    //private int ano;
    //private int velocidade;

    // Construtor
    public Veiculo(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
        //this.ano = ano;
        //this.velocidade = 0;
    }

    // Métodos getters e setters
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

}

