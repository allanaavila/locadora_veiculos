import menus.MenuVeiculo;
import menus.MenuCliente;
import menus.MenuAgencia;
import menus.MenuOperacoes;
import menus.MenuComprovante;
import controlador.veiculoControlador.VeiculoControlador;
import controlador.clienteControlador.ClienteControlador;
import controlador.agenciaControlador.AgenciaControlador;
import modelo.veiculo.Veiculo;
import modelo.pessoa.PessoaFisica;
import modelo.pessoa.PessoaJuridica;
import servico.veiculoServico.VeiculoServicoImplementacao;
import servico.clienteServico.ClienteServicoImplementacao;
import servico.agenciaServico.AgenciaServicoImplementacao;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        VeiculoControlador<Veiculo> veiculoControlador = new VeiculoControlador<>(new VeiculoServicoImplementacao<>());

        ClienteControlador<PessoaFisica> clienteFisicoControlador = new ClienteControlador<>(new ClienteServicoImplementacao<>());
        ClienteControlador<PessoaJuridica> clienteJuridicoControlador = new ClienteControlador<>(new ClienteServicoImplementacao<>());

        AgenciaControlador agenciaControlador = new AgenciaControlador(new AgenciaServicoImplementacao());

        MenuVeiculo menuVeiculo = new MenuVeiculo(veiculoControlador);
        MenuCliente menuCliente = new MenuCliente(clienteFisicoControlador, clienteJuridicoControlador);
        MenuAgencia menuAgencia = new MenuAgencia(agenciaControlador);
        MenuOperacoes menuOperacoes = new MenuOperacoes(veiculoControlador, clienteFisicoControlador, clienteJuridicoControlador, agenciaControlador);
        MenuComprovante menuComprovante = new MenuComprovante();

        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 6) {
            System.out.println("\n==== MENU PRINCIPAL ====");
            System.out.println("1. 🚗 Menu de Veículos");
            System.out.println("2. 👤 Menu de Clientes");
            System.out.println("3. 🏢 Menu de Agências");
            System.out.println("4. 📄 Menu de Operações");
            System.out.println("5. 📜 Menu de Comprovantes");
            System.out.println("6. ❌ Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    menuVeiculo.exibirMenu();
                    break;
                case 2:
                    menuCliente.exibirMenu();
                    break;
                case 3:
                    menuAgencia.exibirMenu();
                    break;
                case 4:
                    menuOperacoes.exibirMenu();
                    break;
                case 5:
                    menuComprovante.exibirMenu();
                    break;
                case 6:
                    System.out.println("Saindo... Até logo!");
                    break;
                default:
                    System.out.println("❌ Opção inválida, tente novamente.");
            }
        }

        scanner.close();
    }
}
