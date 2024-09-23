package servico;

import modelo.veiculo.Veiculo;
import modelo.pessoa.PessoaFisica;
import modelo.pessoa.PessoaJuridica;
import java.time.Duration;
import java.time.LocalDateTime;

public class RegraDeNegocio {

    public double calcularValorTotal(Veiculo veiculo, LocalDateTime dataAluguel, LocalDateTime dataDevolucao, Object cliente) {
        long dias = Duration.between(dataAluguel, dataDevolucao).toDays();
        double valorTotal = dias * veiculo.getValorDiaria().doubleValue();

        if (cliente instanceof PessoaFisica && dias > 5) {
            valorTotal *= 0.95;  // 5% de desconto
        } else if (cliente instanceof PessoaJuridica && dias > 3) {
            valorTotal *= 0.90;  // 10% de desconto
        }

        return valorTotal;
    }
}
