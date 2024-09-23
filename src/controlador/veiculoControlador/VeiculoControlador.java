package controlador.veiculoControlador;

import servico.veiculoServico.VeiculoServico;
import modelo.veiculo.Veiculo;
import java.util.List;

public class VeiculoControlador<T extends Veiculo> {

    private VeiculoServico<T> veiculoServico;

    public VeiculoControlador(VeiculoServico<T> veiculoServico) {
        this.veiculoServico = veiculoServico;
    }

    public T cadastrarVeiculo(T veiculo) {
        return veiculoServico.cadastrarVeiculo(veiculo);
    }

    public T alterarVeiculo(T veiculo) {
        return veiculoServico.alterarVeiculo(veiculo);
    }

    public T buscarVeiculoPorNome(String nome) {
        return veiculoServico.buscarVeiculoPorNome(nome);
    }

    public List<T> listarVeiculos() {
        return veiculoServico.listarVeiculos();
    }

    public void removerVeiculo(T veiculo) {
        veiculoServico.removerVeiculo(veiculo);
    }
}
