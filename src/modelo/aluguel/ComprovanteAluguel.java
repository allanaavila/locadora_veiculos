package modelo.aluguel;

import modelo.pessoa.Pessoa;
import modelo.veiculo.Veiculo;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ComprovanteAluguel {
    private Pessoa cliente;
    private Veiculo veiculo;
    private LocalDateTime dataAluguel;
    private LocalDateTime dataDevolucao;
    private double valorTotal;

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public ComprovanteAluguel(Pessoa cliente, Veiculo veiculo, LocalDateTime dataAluguel, LocalDateTime dataDevolucao, double valorTotal) {
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.dataAluguel = dataAluguel;
        this.dataDevolucao = dataDevolucao;
        this.valorTotal = valorTotal;
    }

    // Getters
    public Pessoa getCliente() {
        return cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public LocalDateTime getDataAluguel() {
        return dataAluguel;
    }

    public LocalDateTime getDataDevolucao() {
        return dataDevolucao;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    // Setters
    public void setCliente(Pessoa cliente) {
        this.cliente = cliente;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public void setDataAluguel(LocalDateTime dataAluguel) {
        this.dataAluguel = dataAluguel;
    }

    public void setDataDevolucao(LocalDateTime dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    @Override
    public String toString() {
        return "Comprovante de Aluguel: \n" +
                "Cliente: " + cliente.getNomePessoa() + "\n" +
                "Veículo: " + veiculo.getModelo() + " - Placa: " + veiculo.getPlaca() + "\n" +
                "Data do Aluguel: " + dataAluguel.format(formatter) + "\n" +
                "Data da Devolução: " + dataDevolucao.format(formatter) + "\n" +
                String.format("Valor Total: R$ %.2f", valorTotal);
    }
}
