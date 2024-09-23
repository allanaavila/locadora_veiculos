package controlador.agenciaControlador;

import modelo.agencia.Agencia;
import servico.agenciaServico.AgenciaServico;
import java.util.List;

public class AgenciaControlador {

    private AgenciaServico agenciaServico;

    public AgenciaControlador(AgenciaServico agenciaServico) {
        this.agenciaServico = agenciaServico;
    }

    public Agencia cadastrarAgencia(Agencia agencia) {
        return agenciaServico.cadastrarAgencia(agencia);
    }

    public Agencia alterarAgencia(Agencia agencia) {
        return agenciaServico.alterarAgencia(agencia);
    }

    public List<Agencia> listarAgencias() {
        return agenciaServico.listarAgencias();
    }

    public Agencia buscarAgenciaPorNome(String nome) {
        return agenciaServico.buscarAgenciaPorNome(nome);
    }

    public Agencia buscarAgenciaPorLogradouro(String logradouro) {
        return agenciaServico.buscarAgenciaPorLogradouro(logradouro);
    }
}
