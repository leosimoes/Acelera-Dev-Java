package challenge;

import java.util.Objects;

public class MotoristaBuilder {

    private String nome;
    private int idade;
    public String habilitacao;

    private int pontos;

    public MotoristaBuilder withNome(String nome) {
        this.nome = nome;
        return this;
    }

    public MotoristaBuilder withIdade(int idade) {
        if (idade <= 0) {
            throw new IllegalArgumentException();
        }
        this.idade = idade;
        return this;
    }

    public MotoristaBuilder withHabilitacao(String habilitacao) {
        this.habilitacao = habilitacao;
        return this;
    }

    public MotoristaBuilder withPontos(int pontos) {
        if (pontos < 0) {
            throw new IllegalArgumentException();
        }
        this.pontos = pontos;
        return this;
    }

    public Motorista build() {
        Objects.requireNonNull(this.nome, "o nome é obrigatorio");
        Objects.requireNonNull(this.idade, "a idade é obrigatorio");
        Objects.requireNonNull(this.pontos, "os pontos são obrigatórios");
        Objects.requireNonNull(this.habilitacao, "a habilitação são obrigatórios");
        return new Motorista(this.nome, this.idade, this.habilitacao, this.pontos);
    }

}
