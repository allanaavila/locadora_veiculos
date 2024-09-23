package servico.clienteServico;

import modelo.pessoa.Pessoa;
import java.util.ArrayList;
import java.util.List;

public class ClienteServicoImplementacao<T extends Pessoa> implements ClienteServico<T> {

    private List<T> bancoDadosClientes;

    public ClienteServicoImplementacao() {
        this.bancoDadosClientes = new ArrayList<>();
    }

    @Override
    public T cadastrarCliente(T cliente) {
        bancoDadosClientes.add(cliente);
        return cliente;
    }

    @Override
    public T alterarCliente(T cliente) {
        T clienteExistente = buscarClientePorNome(cliente.getNomePessoa());
        if (clienteExistente != null) {
            int index = bancoDadosClientes.indexOf(clienteExistente);
            bancoDadosClientes.set(index, cliente);
            return cliente;
        }
        return null;
    }

    @Override
    public List<T> listarClientes() {
        return bancoDadosClientes;
    }

    @Override
    public T buscarClientePorNome(String nome) {
        for (T cliente : bancoDadosClientes) {
            if (cliente.getNomePessoa().equalsIgnoreCase(nome)) {
                return cliente;
            }
        }
        return null;
    }
}
