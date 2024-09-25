import principal.principalVeiculo.PrincipalVeiculo;
import principal.principalPessoa.PrincipalPessoa;
import repositorio.veiculoRepositorio.VeiculoRepositorioImplementacao;
import servico.veiculoServico.VeiculoServicoImplementacao;
import repositorio.pessoaRepositorio.PessoaRepositorioImplementacao;
import servico.pessoaServico.PessoaServicoImplementacao;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);

        VeiculoRepositorioImplementacao veiculoRepositorio = new VeiculoRepositorioImplementacao();
        VeiculoServicoImplementacao veiculoServico = new VeiculoServicoImplementacao(veiculoRepositorio);
        PrincipalVeiculo principalVeiculo = new PrincipalVeiculo(veiculoServico);

        PessoaRepositorioImplementacao pessoaRepositorio = new PessoaRepositorioImplementacao();
        PessoaServicoImplementacao pessoaServico = new PessoaServicoImplementacao(pessoaRepositorio);
        PrincipalPessoa principalPessoa = new PrincipalPessoa(pessoaServico);

        int opcao;
        do {
            System.out.println("\n==== 🎬 MENU PRINCIPAL ====");
            System.out.println("1️⃣  Gerenciar Veículos");
            System.out.println("2️⃣  Gerenciar Pessoas");
            System.out.println("0️⃣  Sair");
            System.out.print("Escolha uma opção: ");
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao) {
                case 1:
                    principalVeiculo.exibirMenu();
                    break;
                case 2:
                    principalPessoa.exibirMenuPessoa();
                    break;
                case 0:
                    System.out.println("👋 Saindo... Até a próxima!");
                    break;
                default:
                    System.out.println("❌ Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        leitura.close();
    }
}
