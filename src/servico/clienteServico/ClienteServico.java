package servico.clienteServico;

import modelo.pessoa.Pessoa;
import java.util.List;

public interface ClienteServico<T extends Pessoa> {
    public T cadastrarCliente(T cliente);
    public T alterarCliente(T cliente);
    public List<T> listarClientes();
    public T buscarClientePorNome(String nome);
}
