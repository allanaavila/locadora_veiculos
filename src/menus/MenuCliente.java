package menus;

import controlador.clienteControlador.ClienteControlador;
import modelo.pessoa.PessoaFisica;
import modelo.pessoa.PessoaJuridica;

import java.util.Scanner;

public class MenuCliente {

    private ClienteControlador<PessoaFisica> clienteFisicoControlador;
    private ClienteControlador<PessoaJuridica> clienteJuridicoControlador;
    private Scanner scanner;

    public MenuCliente(ClienteControlador<PessoaFisica> clienteFisicoControlador, ClienteControlador<PessoaJuridica> clienteJuridicoControlador) {
        this.clienteFisicoControlador = clienteFisicoControlador;
        this.clienteJuridicoControlador = clienteJuridicoControlador;
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int opcao = 0;
        while (opcao != 4) {
            System.out.println("\n==== 👤 Menu de Clientes ====");
            System.out.println("1. ➕ Cadastrar Cliente");
            System.out.println("2. ✏️  Alterar Cliente");
            System.out.println("3. 🧾 Listar Clientes");
            System.out.println("4. 🔙 Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    alterarCliente();
                    break;
                case 3:
                    listarClientes();
                    break;
                case 4:
                    System.out.println("🔙 Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("❌ Opção inválida, tente novamente.");
            }
        }
    }

    private void cadastrarCliente() {
        System.out.println("Qual tipo de cliente deseja cadastrar?");
        System.out.println("1. Pessoa Física");
        System.out.println("2. Pessoa Jurídica");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        if (tipo == 1) {
            System.out.print("CPF: ");
            String cpf = scanner.nextLine();
            PessoaFisica clienteFisico = new PessoaFisica();
            clienteFisico.setNomePessoa(nome);
            clienteFisico.setTelefone(telefone);
            clienteFisico.setEmail(email);
            clienteFisico.setCpf(cpf);
            clienteFisicoControlador.cadastrarCliente(clienteFisico);
            System.out.println("Cliente (Pessoa Física) cadastrado com sucesso!");
        } else if (tipo == 2) {
            System.out.print("CNPJ: ");
            String cnpj = scanner.nextLine();
            PessoaJuridica clienteJuridico = new PessoaJuridica();
            clienteJuridico.setNomePessoa(nome);
            clienteJuridico.setTelefone(telefone);
            clienteJuridico.setEmail(email);
            clienteJuridico.setCnpj(cnpj);
            clienteJuridicoControlador.cadastrarCliente(clienteJuridico);
            System.out.println("Cliente (Pessoa Jurídica) cadastrado com sucesso!");
        } else {
            System.out.println("Tipo de cliente inválido!");
        }
    }

    private void alterarCliente() {
        System.out.print("Informe o nome do cliente a ser alterado: ");
        String nome = scanner.nextLine();

        PessoaFisica clienteFisico = clienteFisicoControlador.buscarClientePorNome(nome);
        if (clienteFisico != null) {
            System.out.print("Novo telefone: ");
            String telefone = scanner.nextLine();
            System.out.print("Novo email: ");
            String email = scanner.nextLine();
            clienteFisico.setTelefone(telefone);
            clienteFisico.setEmail(email);
            clienteFisicoControlador.alterarCliente(clienteFisico);
            System.out.println("Cliente alterado com sucesso!");
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    private void listarClientes() {
        System.out.println("Clientes cadastrados (Pessoa Física):");
        for (PessoaFisica cliente : clienteFisicoControlador.listarClientes()) {
            System.out.println(cliente.getNomePessoa() + " - CPF: " + cliente.getCpf());
        }
        System.out.println("\nClientes cadastrados (Pessoa Jurídica):");
        for (PessoaJuridica cliente : clienteJuridicoControlador.listarClientes()) {
            System.out.println(cliente.getNomePessoa() + " - CNPJ: " + cliente.getCnpj());
        }
    }
}
