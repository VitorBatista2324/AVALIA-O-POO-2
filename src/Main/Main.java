package Main;// Importações necessárias
import java.util.Scanner;
import Enums.TipoMotoEnum;
import Enums.TipoCarroEnum;
import Enums.TipoEstradaEnum;
import Model.*;

// Classe principal do programa
public class Main {
    public static void main(String[] args) {
        // Inicialização do scanner para entrada de dados do usuário
        Scanner scanner = new Scanner(System.in);

        // Mensagem de boas-vindas ao sistema de corrida
        System.out.println("Bem-vindo ao sistema de corrida!");

        // Solicitação ao usuário para informar o tipo de terreno da corrida
        System.out.println("Informe o tipo de terreno da corrida:");
        System.out.println("1. Asfalto");
        System.out.println("2. Terra");
        System.out.println("3. Grama");
        int opcaoTerreno = scanner.nextInt();

        // Variável para armazenar o tipo de terreno da corrida
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
                // Caso o usuário forneça uma opção inválida, o programa utiliza o Asfalto como padrão
                System.out.println("Opção inválida. Usando Asfalto como padrão.");
                tipoTerreno = TipoEstradaEnum.ASFALTO;
                break;
        }

        // Criação dos veículos para a corrida
        Veiculo veiculo1 = criarVeiculo(scanner, "primeiro");
        Veiculo veiculo2 = criarVeiculo(scanner, "segundo");

        // Criação da corrida com os veículos e o tipo de terreno informado
        Corrida corrida = new Corrida(veiculo1, veiculo2, tipoTerreno);

        // Ações antes do início da corrida
        corrida.acao1();
        corrida.acao2();

        // Mensagem indicando que a corrida está prestes a começar
        System.out.println("Preparando para começar a corrida...");
        corrida.iniciar();

        // Determinação do vencedor da corrida
        System.out.println("Determinando o vencedor...");
        String vencedor = corrida.Logica();
        System.out.println("O vencedor da corrida é: " + vencedor);

        // Finalização da corrida
        System.out.println("Finalizando a corrida...");
        corrida.finalizar();

        // Fechamento do scanner para liberar recursos
        scanner.close();
    }

    // Método para criar um veículo com base nas informações fornecidas pelo usuário
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
            return criarMoto(scanner, marca, modelo, potencia);
        } else if (tipoVeiculo == 2) {
            return criarCarro(scanner, marca, modelo, potencia);
        } else {
            // Se o tipo de veículo informado for inválido, cria uma moto como padrão
            System.out.println("Tipo de veículo inválido. Criando moto como padrão.");
            return criarMoto(scanner, marca, modelo, potencia);
        }
    }

    // Método para criar uma moto com base nas informações fornecidas pelo usuário
    private static Veiculo criarMoto(Scanner scanner, String marca, String modelo, int potencia) {
        System.out.println("Tipo de moto (1 para Moto1, 2 para Moto2):");
        int tipoMoto = scanner.nextInt();
        TipoMotoEnum tipoMotoEnum;
        switch (tipoMoto) {
            case 1:
                tipoMotoEnum = TipoMotoEnum.ESPORTIVA;
                return new Moto1(marca, modelo, tipoMotoEnum, potencia);
            case 2:
                tipoMotoEnum = TipoMotoEnum.BIG_TRAIL;
                return new Moto2(marca, modelo, tipoMotoEnum, potencia);
            default:
                // Se o tipo de moto informado for inválido, cria uma Moto1 como padrão
                System.out.println("Tipo de moto inválido. Escolhendo Moto1 como padrão.");
                tipoMotoEnum = TipoMotoEnum.ESPORTIVA;
                return new Moto1(marca, modelo, tipoMotoEnum, potencia);
        }
    }

    // Método para criar um carro com base nas informações fornecidas pelo usuário
    private static Veiculo criarCarro(Scanner scanner, String marca, String modelo, int potencia) {
        System.out.println("Tipo de carro (1 para Carro1, 2 para Carro2):");
        int tipoCarro = scanner.nextInt();
        TipoCarroEnum tipoCarroEnum;
        switch (tipoCarro) {
            case 1:
                tipoCarroEnum = TipoCarroEnum.ESPORTIVO;
                return new Carro1(marca, modelo, tipoCarroEnum, potencia);
            case 2:
                tipoCarroEnum = TipoCarroEnum.OFF_ROAD;
                return new Carro2(marca, modelo, tipoCarroEnum, potencia);
            default:
                // Se o tipo de carro informado for inválido, cria um Carro1 como padrão
                System.out.println("Tipo de carro inválido. Escolhendo Carro1 como padrão.");
                tipoCarroEnum = TipoCarroEnum.ESPORTIVO;
                return new Carro1(marca, modelo, tipoCarroEnum, potencia);
        }
    }
}
