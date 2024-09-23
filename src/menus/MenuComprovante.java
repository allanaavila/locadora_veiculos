package menus;

import java.time.LocalDateTime;
import java.util.Scanner;

public class MenuComprovante {

    private Scanner scanner = new Scanner(System.in);

    public void exibirMenu() {
        int opcao = 0;
        while (opcao != 2) {
            System.out.println("\n==== 📄 Menu de Comprovantes ====");
            System.out.println("1. Gerar Comprovante de Aluguel");
            System.out.println("2. 🔙 Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    gerarComprovante();
                    break;
                case 2:
                    System.out.println("🔙 Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("❌ Opção inválida, tente novamente.");
            }
        }
    }

    private void gerarComprovante() {
        System.out.print("Nome do cliente: ");
        String nomeCliente = scanner.nextLine();
        System.out.print("Placa do veículo: ");
        String placaVeiculo = scanner.nextLine();
        System.out.print("Tipo de veículo (Carro/Moto/Caminhão): ");
        String tipoVeiculo = scanner.nextLine();
        System.out.print("Dias de aluguel: ");
        int diasAluguel = scanner.nextInt();

        LocalDateTime dataAluguel = LocalDateTime.now();
        LocalDateTime dataDevolucao = dataAluguel.plusDays(diasAluguel);

        double valorTotal = calcularValorTotal(tipoVeiculo, diasAluguel);

        System.out.println("Comprovante de Aluguel:");
        System.out.println("Cliente: " + nomeCliente);
        System.out.println("Veículo: " + tipoVeiculo + " - Placa: " + placaVeiculo);
        System.out.println("Data do Aluguel: " + dataAluguel);
        System.out.println("Data da Devolução: " + dataDevolucao);
        System.out.println("Valor Total: R$ " + valorTotal);
    }

    private double calcularValorTotal(String tipoVeiculo, int diasAluguel) {
        double valorDiaria;

        switch (tipoVeiculo.toLowerCase()) {
            case "moto":
                valorDiaria = 100.0;
                break;
            case "carro":
                valorDiaria = 150.0;
                break;
            case "caminhão":
                valorDiaria = 200.0;
                break;
            default:
                System.out.println("❌ Tipo de veículo inválido!");
                return 0.0;
        }

        return valorDiaria * diasAluguel;
    }
}
