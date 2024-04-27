package Model;

import Contratos.IAcao1;
import Contratos.IAcao2;
import Contratos.IComecarCorrida;
import Contratos.IFinalizarCorrida;
import Enums.TipoEstradaEnum;


public class Corrida implements IComecarCorrida, IFinalizarCorrida, IAcao1, IAcao2 {
    private Veiculo veiculo1;
    private Veiculo veiculo2;
    private TipoEstradaEnum tipoTerreno;

    public Corrida(Veiculo veiculo1, Veiculo veiculo2, TipoEstradaEnum tipoTerreno) {
        this.veiculo1 = veiculo1;
        this.veiculo2 = veiculo2;
        this.tipoTerreno = tipoTerreno;
    }

    @Override
    public void iniciar() {
        System.out.println("O Racha começou!");
    }
    @Override
    public void acao1(){
        System.out.println("Aquecendo Motores...");
    }
    @Override
    public void acao2(){
        System.out.println("MARCHA!!!");
    }



    public String Logica() {
        int potenciaVeiculo1 = veiculo1.getPotencia();
        int potenciaVeiculo2 = veiculo2.getPotencia();

        if (potenciaVeiculo1 > potenciaVeiculo2) {
            return veiculo1.getMarca() + " " + veiculo1.getModelo() + " " + "Venceu a corrida em: " + tipoTerreno;
        } else if (potenciaVeiculo2 > potenciaVeiculo1) {
            return veiculo2.getMarca() + " " + veiculo2.getModelo() + " " + "Venceu a corrida em: " + tipoTerreno;
        } else {
            return "Empate";
        }
    }


    @Override
    public void finalizar() {
        System.out.println("A corrida terminou!");
    }
}
