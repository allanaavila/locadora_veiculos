package menus;

import controlador.veiculoControlador.VeiculoControlador;
import modelo.veiculo.TipoVeiculo;
import modelo.veiculo.Veiculo;

import java.math.BigDecimal;
import java.util.Scanner;

public class MenuVeiculo {

    private VeiculoControlador<Veiculo> veiculoControlador;
    private Scanner scanner = new Scanner(System.in);

    public MenuVeiculo(VeiculoControlador<Veiculo> veiculoControlador) {
        this.veiculoControlador = veiculoControlador;
    }

    public void exibirMenu() {
        int opcao = 0;
        while (opcao != 4) {
            System.out.println("\n==== 🚗 Menu de Veículos ====");
            System.out.println("1. ➕ Cadastrar Veículo");
            System.out.println("2. ✏️  Alterar Veículo");
            System.out.println("3. 🔍 Buscar Veículo por Nome");
            System.out.println("4. 🔙 Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarVeiculo();
                    break;
                case 2:
                    alterarVeiculo();
                    break;
                case 3:
                    buscarVeiculoPorNome();
                    break;
                case 4:
                    System.out.println("🔙 Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("❌ Opção inválida, tente novamente.");
            }
        }
    }

    private void cadastrarVeiculo() {
        System.out.print("📋 Placa: ");
        String placa = scanner.nextLine();
        System.out.print("📋 Modelo: ");
        String modelo = scanner.nextLine();
        System.out.print("📋 Marca: ");
        String marca = scanner.nextLine();

        System.out.println("Selecione o tipo de veículo:");
        System.out.println("🚗 Carro");
        System.out.println("🏍️ Moto");
        System.out.println("🚚 Caminhão");
        String tipoVeiculoStr = scanner.nextLine();

        TipoVeiculo tipoVeiculo = TipoVeiculo.fromDescricao(tipoVeiculoStr);

        if (tipoVeiculo == null) {
            System.out.println("❌ Tipo de veículo inválido!");
            return;
        }

        BigDecimal valorDiaria = BigDecimal.valueOf(tipoVeiculo.getValorDiaria());

        Veiculo veiculo = new Veiculo(placa, modelo, marca, true, valorDiaria);
        veiculoControlador.cadastrarVeiculo(veiculo);
        System.out.println("🚗 Veículo cadastrado com sucesso!");
    }

    private void alterarVeiculo() {
        System.out.print("Informe o nome do veículo a ser alterado: ");
        String nome = scanner.nextLine();
        Veiculo veiculo = veiculoControlador.buscarVeiculoPorNome(nome);

        if (veiculo == null) {
            System.out.println("❌ Veículo não encontrado!");
            return;
        }

        System.out.print("Novo modelo (" + veiculo.getModelo() + "): ");
        String modelo = scanner.nextLine();
        if (!modelo.trim().isEmpty()) veiculo.setModelo(modelo);

        System.out.print("Nova marca (" + veiculo.getMarca() + "): ");
        String marca = scanner.nextLine();
        if (!marca.trim().isEmpty()) veiculo.setMarca(marca);

        veiculoControlador.alterarVeiculo(veiculo);
        System.out.println("✏️  Veículo alterado com sucesso!");
    }

    private void buscarVeiculoPorNome() {
        System.out.print("🔍 Digite parte do nome do veículo: ");
        String nome = scanner.nextLine();

        Veiculo veiculo = veiculoControlador.buscarVeiculoPorNome(nome);
        if (veiculo != null) {
            System.out.println("🚗 Veículo encontrado: " + veiculo.getModelo() + " - Marca: " + veiculo.getMarca());
        } else {
            System.out.println("❌ Veículo não encontrado!");
        }
    }
}
