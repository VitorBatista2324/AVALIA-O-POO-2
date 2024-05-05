package Main;
import java.util.Scanner;
import Enums.TipoMotoEnum;
import Enums.TipoCarroEnum;
import Enums.TipoEstradaEnum;
import Model.*;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        System.out.println("Bem-vindo ao sistema de corrida!");

        // para informar o tipo de terreno
        System.out.println("Informe o tipo de terreno da corrida:");
        System.out.println("1. Asfalto");
        System.out.println("2. Terra");
        System.out.println("3. Grama");
        int opcaoTerreno = scanner.nextInt();

        // para armazenar o tipo de terreno da corrida
        TipoEstradaEnum tipoTerreno;
        switch (opcaoTerreno) {
            case 1:
                tipoTerreno = TipoEstradaEnum.ASFALTO;
                break;
            case 2:
                tipoTerreno = TipoEstradaEnum.TERRA;
                break;
            case 3:
                tipoTerreno = TipoEstradaEnum.BARRO;
                break;
            default:

                System.out.println("Opção inválida. Usando Asfalto como padrão.");
                tipoTerreno = TipoEstradaEnum.ASFALTO;
                break;
        }

        // duas instâncias chamando um método criarVeiculo para criar dois objetos de veículo, veiculo1 e veiculo2.
        Veiculo veiculo1 = criarVeiculo(scanner, "primeiro");
        Veiculo veiculo2 = criarVeiculo(scanner, "segundo");

        // criando a corrida com os veículos e o tipo de terreno
        Corrida corrida = new Corrida(veiculo1, veiculo2, tipoTerreno);

        // chamando Contratos
        corrida.acao1();
        corrida.acao2();

        // iniciando a corrida
        System.out.println("Preparando para começar a corrida...");
        corrida.iniciar();

        // determinar o ganhador
        System.out.println("Determinando o vencedor...");
        String vencedor = corrida.Logica();
        System.out.println("O vencedor da corrida é: " + vencedor);

        // final
        System.out.println("Finalizando a corrida...");
        corrida.finalizar();


        scanner.close();
    }

    // metodo para criar um veiculo
    private static Veiculo criarVeiculo(Scanner scanner, String ordem) {
        System.out.println("Informe os detalhes do " + ordem + " veículo:");
        System.out.println("Marca do veículo:");
        String marca = scanner.next();

        System.out.println("Modelo do veículo:");
        String modelo = scanner.next();

        System.out.println("Potência do veículo:");
        int potencia = scanner.nextInt();

        System.out.println("Tipo do veículo (1 para Moto, 2 para Carro):");
        int tipoVeiculo = scanner.nextInt();
        scanner.nextLine();

        if (tipoVeiculo == 1) {
            return criarMoto(scanner, marca, modelo, potencia); // chama o metodo para criar uma moto
        } else if (tipoVeiculo == 2) {
            return criarCarro(scanner, marca, modelo, potencia); // para criar um carro
        } else {
            System.out.println("Tipo de veículo inválido. Criando moto como padrão.");
            return criarMoto(scanner, marca, modelo, potencia);
        }
    }

    // metodo para criar uma moto
    private static Veiculo criarMoto(Scanner scanner, String marca, String modelo, int potencia) {
        System.out.println("Tipo de moto (1 para ESPORTIVA, 2 para BIG_TRAIL):");
        int tipoMoto = scanner.nextInt();
        TipoMotoEnum tipoMotoEnum;
        switch (tipoMoto) {
            case 1:
                tipoMotoEnum = TipoMotoEnum.ESPORTIVA;
                return new Moto1(marca, modelo, tipoMotoEnum, potencia); // define o tipo de moto como esportiva
            case 2:
                tipoMotoEnum = TipoMotoEnum.BIG_TRAIL;
                return new Moto2(marca, modelo, tipoMotoEnum, potencia); // define como big trail
            default:
                System.out.println("Tipo de moto inválido. Escolhendo Moto1 como padrão.");
                tipoMotoEnum = TipoMotoEnum.ESPORTIVA;
                return new Moto1(marca, modelo, tipoMotoEnum, potencia);
        }
    }

    // metodo para criar um carro
    private static Veiculo criarCarro(Scanner scanner, String marca, String modelo, int potencia) {
        System.out.println("Tipo de carro (1 para ESPORTIVO, 2 para OFF_ROAD):");
        int tipoCarro = scanner.nextInt();
        TipoCarroEnum tipoCarroEnum;
        switch (tipoCarro) {
            case 1:
                tipoCarroEnum = TipoCarroEnum.ESPORTIVO;
                return new Carro1(marca, modelo, tipoCarroEnum, potencia); // cria e retorna um carro
            case 2:
                tipoCarroEnum = TipoCarroEnum.OFF_ROAD;
                return new Carro2(marca, modelo, tipoCarroEnum, potencia); // cria e retorna outro carro
            default:
                System.out.println("Tipo de carro inválido. Escolhendo Carro1 como padrão.");
                tipoCarroEnum = TipoCarroEnum.ESPORTIVO;
                return new Carro1(marca, modelo, tipoCarroEnum, potencia);
        }
    }
}

