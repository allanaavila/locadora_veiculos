package repositorio.agenciaRepositorio;

import exception.agenciaException.AgenciaDuplicadaException;
import modelo.agencia.Agencia;
import modelo.endereco.Endereco;

import java.util.ArrayList;
import java.util.List;

public class AgenciaRepositorioImplementacao<T extends Agencia> extends AgenciaRepositorio<T> {

    public List<T> bancoDados;

    public AgenciaRepositorioImplementacao() {
        bancoDados = new ArrayList<>();
    }


    @Override
    public T cadastrar(T agencia) throws AgenciaDuplicadaException {
        for (T a : bancoDados) {
            if (a.getNomeAgencia().equalsIgnoreCase(agencia.getNomeAgencia())) {
                throw new AgenciaDuplicadaException("Agência com nome " + agencia.getNomeAgencia() + " já existe.");
            }
            if (a.getEndereco().getCEP().equals(agencia.getEndereco().getCEP())) {
                throw new AgenciaDuplicadaException("Agência com CEP " + agencia.getEndereco().getCEP() + " já existe.");
            }
        }
        bancoDados.add(agencia);
        return agencia;
    }

    @Override
    public T atualizar(T agencia) {
        return null;
    }

    @Override
    public void remover(T agencia) {
        bancoDados.remove(agencia);
    }

    public T buscarPorId(Long idAgencia) {
        for (T agencia : bancoDados) {
            if (agencia.getIdAgencia().equals(idAgencia)) {
                return agencia;
            }
        }
        return null;
    }

    @Override
    public List<T> listar() {
        return new ArrayList<>(bancoDados);
    }

    @Override
    public T buscarPorEndereco(Endereco endereco) {
        for (T agencia : bancoDados) {
            if (agencia.getEndereco().getCEP().equals(endereco.getCEP())) {
                return agencia;
            }
        }
        return null;
    }
}
