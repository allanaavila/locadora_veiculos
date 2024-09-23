package controlador.clienteControlador;

import modelo.pessoa.Pessoa;
import servico.clienteServico.ClienteServico;
import java.util.List;

public class ClienteControlador<T extends Pessoa> {

    private ClienteServico<T> clienteServico;

    public ClienteControlador(ClienteServico<T> clienteServico) {
        this.clienteServico = clienteServico;
    }

    public T cadastrarCliente(T cliente) {
        return clienteServico.cadastrarCliente(cliente);
    }

    public T alterarCliente(T cliente) {
        return clienteServico.alterarCliente(cliente);
    }

    public List<T> listarClientes() {
        return clienteServico.listarClientes();
    }

    public T buscarClientePorNome(String nome) {
        return clienteServico.buscarClientePorNome(nome);
    }
}
