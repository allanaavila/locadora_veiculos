package servico.agenciaServico;

import modelo.agencia.Agencia;
import java.util.ArrayList;
import java.util.List;

public class AgenciaServicoImplementacao implements AgenciaServico {

    private List<Agencia> bancoDadosAgencias;

    public AgenciaServicoImplementacao() {
        this.bancoDadosAgencias = new ArrayList<>();
    }

    @Override
    public Agencia cadastrarAgencia(Agencia agencia) {
        bancoDadosAgencias.add(agencia);
        return agencia;
    }

    @Override
    public Agencia alterarAgencia(Agencia agencia) {
        Agencia agenciaExistente = buscarAgenciaPorNome(agencia.getNomeAgencia());
        if (agenciaExistente != null) {
            int index = bancoDadosAgencias.indexOf(agenciaExistente);
            bancoDadosAgencias.set(index, agencia);
            return agencia;
        }
        return null;
    }

    @Override
    public List<Agencia> listarAgencias() {
        return bancoDadosAgencias;
    }

    @Override
    public Agencia buscarAgenciaPorNome(String nome) {
        for (Agencia agencia : bancoDadosAgencias) {
            if (agencia.getNomeAgencia().equalsIgnoreCase(nome)) {
                return agencia;
            }
        }
        return null;
    }

    @Override
    public Agencia buscarAgenciaPorLogradouro(String logradouro) {
        for (Agencia agencia : bancoDadosAgencias) {
            if (agencia.getEndereco().getLogradouro().equalsIgnoreCase(logradouro)) {
                return agencia;
            }
        }
        return null;
    }
}
