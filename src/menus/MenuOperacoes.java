package menus;

import modelo.aluguel.ComprovanteAluguel;
import modelo.pessoa.PessoaFisica;
import modelo.pessoa.PessoaJuridica;
import modelo.pessoa.Pessoa;
import modelo.veiculo.Veiculo;
import controlador.veiculoControlador.VeiculoControlador;
import controlador.clienteControlador.ClienteControlador;
import controlador.agenciaControlador.AgenciaControlador;
import modelo.agencia.Agencia;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuOperacoes {

    private VeiculoControlador<Veiculo> veiculoControlador;
    private ClienteControlador<PessoaFisica> clienteFisicoControlador;
    private ClienteControlador<PessoaJuridica> clienteJuridicoControlador;
    private AgenciaControlador agenciaControlador;
    private List<ComprovanteAluguel> listaComprovantes = new ArrayList<>(); // Lista para armazenar os comprovantes de aluguel
    private Scanner scanner = new Scanner(System.in);

    public MenuOperacoes(VeiculoControlador<Veiculo> veiculoControlador, ClienteControlador<PessoaFisica> clienteFisicoControlador,
                         ClienteControlador<PessoaJuridica> clienteJuridicoControlador, AgenciaControlador agenciaControlador) {
        this.veiculoControlador = veiculoControlador;
        this.clienteFisicoControlador = clienteFisicoControlador;
        this.clienteJuridicoControlador = clienteJuridicoControlador;
        this.agenciaControlador = agenciaControlador;
    }

    public void exibirMenu() {
        int opcao = 0;
        while (opcao != 3) {
            System.out.println("\n==== 📄 Menu de Operações ====");
            System.out.println("1. 🚗 Alugar Veículo");
            System.out.println("2. 📝 Devolver Veículo");
            System.out.println("3. 🔙 Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    alugarVeiculo();
                    break;
                case 2:
                    devolverVeiculo();
                    break;
                case 3:
                    System.out.println("🔙 Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("❌ Opção inválida, tente novamente.");
            }
        }
    }

    private void alugarVeiculo() {
        System.out.print("Informe o nome do veículo a ser alugado: ");
        String nome = scanner.nextLine();
        Veiculo veiculo = veiculoControlador.buscarVeiculoPorNome(nome);

        if (veiculo == null || !veiculo.getDisponivel()) {
            System.out.println("❌ Veículo não encontrado ou indisponível para aluguel!");
            return;
        }

        System.out.print("Nome do cliente (Pessoa Física ou Jurídica): ");
        String nomeCliente = scanner.nextLine();

        Pessoa cliente = buscarClientePorNome(nomeCliente);
        if (cliente == null) {
            System.out.println("❌ Cliente não encontrado!");
            return;
        }

        System.out.print("Nome da agência de retirada: ");
        String nomeAgencia = scanner.nextLine();
        Agencia agencia = agenciaControlador.buscarAgenciaPorNome(nomeAgencia);
        if (agencia == null) {
            System.out.println("❌ Agência não encontrada!");
            return;
        }

        System.out.print("Informe o número de dias de aluguel: ");
        int diasAluguel = scanner.nextInt();
        scanner.nextLine();

        veiculo.setDisponivel(false);
        LocalDateTime dataAluguel = LocalDateTime.now();
        LocalDateTime dataDevolucao = dataAluguel.plusDays(diasAluguel);

        double valorTotal = calcularValorTotal(veiculo, diasAluguel);

        ComprovanteAluguel comprovante = new ComprovanteAluguel(cliente, veiculo, dataAluguel, dataDevolucao, valorTotal);
        listaComprovantes.add(comprovante);

        System.out.println("🚗 Veículo alugado com sucesso!");
        System.out.println(comprovante);
    }

    private void devolverVeiculo() {
        System.out.print("Informe o nome do veículo a ser devolvido: ");
        String nome = scanner.nextLine();
        Veiculo veiculo = veiculoControlador.buscarVeiculoPorNome(nome);

        if (veiculo == null || veiculo.getDisponivel()) {
            System.out.println("❌ Veículo não encontrado ou já está disponível!");
            return;
        }

        ComprovanteAluguel comprovante = buscarComprovantePorVeiculo(veiculo);
        if (comprovante == null) {
            System.out.println("❌ Comprovante de aluguel não encontrado para este veículo!");
            return;
        }

        veiculo.setDisponivel(true);

        int diasAluguel = calcularDiasEntre(comprovante.getDataAluguel(), LocalDateTime.now());
        double valorTotalComDesconto = aplicarDesconto(comprovante.getCliente(), comprovante.getValorTotal(), diasAluguel);

        comprovante.setValorTotal(valorTotalComDesconto);
        comprovante.setDataDevolucao(LocalDateTime.now());

        System.out.println("📝 Veículo devolvido com sucesso!");
        System.out.println(comprovante);
    }

    private Pessoa buscarClientePorNome(String nomeCliente) {
        PessoaFisica clienteFisico = clienteFisicoControlador.buscarClientePorNome(nomeCliente);
        if (clienteFisico != null) return clienteFisico;

        return clienteJuridicoControlador.buscarClientePorNome(nomeCliente);
    }

    private ComprovanteAluguel buscarComprovantePorVeiculo(Veiculo veiculo) {
        for (ComprovanteAluguel comprovante : listaComprovantes) {
            if (comprovante.getVeiculo().equals(veiculo)) {
                return comprovante;
            }
        }
        return null;
    }

    private double calcularValorTotal(Veiculo veiculo, int dias) {
        double valorDiaria;

        if (veiculo.getModelo().equalsIgnoreCase("carro")) {
            valorDiaria = 150.0;
        } else if (veiculo.getModelo().equalsIgnoreCase("moto")) {
            valorDiaria = 100.0;
        } else if (veiculo.getModelo().equalsIgnoreCase("caminhão")) {
            valorDiaria = 200.0;
        } else {
            valorDiaria = 0.0;
        }

        return valorDiaria * dias;
    }

    private double aplicarDesconto(Pessoa cliente, double valorTotal, int diasAluguel) {
        if (cliente instanceof PessoaFisica && diasAluguel > 5) {
            return valorTotal * 0.95;
        } else if (cliente instanceof PessoaJuridica && diasAluguel > 3) {
            return valorTotal * 0.90;
        }
        return valorTotal;
    }

    private int calcularDiasEntre(LocalDateTime dataInicio, LocalDateTime dataFim) {
        return (int) java.time.Duration.between(dataInicio, dataFim).toDays();
    }
}
