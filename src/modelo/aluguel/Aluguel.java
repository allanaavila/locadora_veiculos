package modelo.aluguel;

import modelo.pessoa.Pessoa;
import modelo.veiculo.Veiculo;
import modelo.agencia.Agencia;
import java.time.LocalDateTime;

public class Aluguel {
    private Pessoa cliente;
    private Veiculo veiculo;
    private Agencia agencia;
    private LocalDateTime dataAluguel;
    private LocalDateTime dataDevolucao;

    public Aluguel(Pessoa cliente, Veiculo veiculo, Agencia agencia, LocalDateTime dataAluguel, LocalDateTime dataDevolucao) {
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.agencia = agencia;
        this.dataAluguel = dataAluguel;
        this.dataDevolucao = dataDevolucao;
    }

    // Getters e Setters
    public Pessoa getCliente() { return cliente; }
    public Veiculo getVeiculo() { return veiculo; }
    public Agencia getAgencia() { return agencia; }
    public LocalDateTime getDataAluguel() { return dataAluguel; }
    public LocalDateTime getDataDevolucao() { return dataDevolucao; }

    public void setDataDevolucao(LocalDateTime dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    // Exibir os detalhes do aluguel
    @Override
    public String toString() {
        return "Aluguel:\n" +
                "Cliente: " + cliente.getNomePessoa() + "\n" +
                "Veículo: " + veiculo.getModelo() + " - Placa: " + veiculo.getPlaca() + "\n" +
                "Agência: " + agencia.getNomeAgencia() + "\n" +
                "Data do Aluguel: " + dataAluguel + "\n" +
                "Data da Devolução: " + dataDevolucao;
    }
}
