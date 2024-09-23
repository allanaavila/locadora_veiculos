package servico.agenciaServico;

import modelo.agencia.Agencia;
import java.util.List;

public interface AgenciaServico {
    public Agencia cadastrarAgencia(Agencia agencia);
    public Agencia alterarAgencia(Agencia agencia);
    public List<Agencia> listarAgencias();
    public Agencia buscarAgenciaPorNome(String nome);
    public Agencia buscarAgenciaPorLogradouro(String logradouro);
}
