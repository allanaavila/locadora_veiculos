package menus;

import controlador.agenciaControlador.AgenciaControlador;
import modelo.agencia.Agencia;
import modelo.endereco.Endereco;

import java.util.Scanner;

public class MenuAgencia {

    private AgenciaControlador agenciaControlador;
    private Scanner scanner = new Scanner(System.in);

    public MenuAgencia(AgenciaControlador agenciaControlador) {
        this.agenciaControlador = agenciaControlador;
    }

    public void exibirMenu() {
        int opcao = 0;
        while (opcao != 4) {
            System.out.println("\n==== 🏢 Menu de Agências ====");
            System.out.println("1. ➕ Cadastrar Agência");
            System.out.println("2. ✏️  Alterar Agência");
            System.out.println("3. 🔍 Buscar Agência por Nome/Logradouro");
            System.out.println("4. 🔙 Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir o newline

            switch (opcao) {
                case 1:
                    cadastrarAgencia();
                    break;
                case 2:
                    alterarAgencia();
                    break;
                case 3:
                    buscarAgencia();
                    break;
                case 4:
                    System.out.println("🔙 Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("❌ Opção inválida, tente novamente.");
            }
        }
    }

    private void cadastrarAgencia() {
        System.out.print("Nome da agência: ");
        String nomeAgencia = scanner.nextLine();
        System.out.print("Logradouro: ");
        String logradouro = scanner.nextLine();
        System.out.print("Número: ");
        String numero = scanner.nextLine();
        System.out.print("CEP: ");
        String cep = scanner.nextLine();
        System.out.print("Bairro: ");
        String bairro = scanner.nextLine();
        System.out.print("Cidade: ");
        String cidade = scanner.nextLine();
        System.out.print("Estado: ");
        String estado = scanner.nextLine();

        Endereco endereco = new Endereco();
        endereco.setLogradouro(logradouro);
        endereco.setNumero(numero);
        endereco.setCEP(cep);
        endereco.setBairro(bairro);
        endereco.setCidade(cidade);
        endereco.setEstado(estado);

        Agencia agencia = new Agencia();
        agencia.setNomeAgencia(nomeAgencia);
        agencia.setEndereco(endereco);

        agenciaControlador.cadastrarAgencia(agencia);
        System.out.println("🏢 Agência cadastrada com sucesso!");
    }

    private void alterarAgencia() {
        System.out.print("Informe o nome da agência a ser alterada: ");
        String nomeAgencia = scanner.nextLine();

        Agencia agencia = agenciaControlador.buscarAgenciaPorNome(nomeAgencia);
        if (agencia == null) {
            System.out.println("❌ Agência não encontrada!");
            return;
        }

        System.out.println("Informe os novos dados da agência (ou pressione Enter para manter o valor atual):");

        System.out.print("Novo nome (" + agencia.getNomeAgencia() + "): ");
        String novoNome = scanner.nextLine();
        if (!novoNome.trim().isEmpty()) agencia.setNomeAgencia(novoNome);

        System.out.print("Novo logradouro (" + agencia.getEndereco().getLogradouro() + "): ");
        String logradouro = scanner.nextLine();
        if (!logradouro.trim().isEmpty()) agencia.getEndereco().setLogradouro(logradouro);

        System.out.print("Novo número (" + agencia.getEndereco().getNumero() + "): ");
        String numero = scanner.nextLine();
        if (!numero.trim().isEmpty()) agencia.getEndereco().setNumero(numero);

        System.out.print("Novo CEP (" + agencia.getEndereco().getCEP() + "): ");
        String cep = scanner.nextLine();
        if (!cep.trim().isEmpty()) agencia.getEndereco().setCEP(cep);

        System.out.print("Novo bairro (" + agencia.getEndereco().getBairro() + "): ");
        String bairro = scanner.nextLine();
        if (!bairro.trim().isEmpty()) agencia.getEndereco().setBairro(bairro);

        System.out.print("Nova cidade (" + agencia.getEndereco().getCidade() + "): ");
        String cidade = scanner.nextLine();
        if (!cidade.trim().isEmpty()) agencia.getEndereco().setCidade(cidade);

        System.out.print("Novo estado (" + agencia.getEndereco().getEstado() + "): ");
        String estado = scanner.nextLine();
        if (!estado.trim().isEmpty()) agencia.getEndereco().setEstado(estado);

        agenciaControlador.alterarAgencia(agencia);
        System.out.println("✏️  Agência alterada com sucesso!");
    }

    private void buscarAgencia() {
        System.out.print("🔍 Digite o nome ou logradouro da agência: ");
        String termo = scanner.nextLine();

        Agencia agencia = agenciaControlador.buscarAgenciaPorNome(termo);
        if (agencia == null) {
            agencia = agenciaControlador.buscarAgenciaPorLogradouro(termo);
        }

        if (agencia != null) {
            System.out.println("🏢 Agência encontrada: " + agencia.getNomeAgencia());
            System.out.println("📍 Endereço: " + agencia.getEndereco().getLogradouro() + ", " + agencia.getEndereco().getNumero() + " - " + agencia.getEndereco().getCidade());
        } else {
            System.out.println("❌ Agência não encontrada!");
        }
    }
}
