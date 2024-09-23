package modelo.veiculo;

public enum TipoVeiculo {
    CARRO("Carro", 150),
    MOTO("Moto", 100),
    CAMINHAO("Caminhão", 200);

    private String descricao;
    private double valorDiaria;

    TipoVeiculo(String descricao, double valorDiaria) {
        this.descricao = descricao;
        this.valorDiaria = valorDiaria;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public static TipoVeiculo fromDescricao(String descricao) {
        for (TipoVeiculo tipo : TipoVeiculo.values()) {
            if (tipo.getDescricao().equalsIgnoreCase(descricao)) {
                return tipo;
            }
        }
        return null; // Caso não seja encontrado um tipo válido
    }
}
