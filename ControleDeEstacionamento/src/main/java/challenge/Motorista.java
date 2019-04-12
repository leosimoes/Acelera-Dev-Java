package challenge;

public class Motorista {

    private String nome;
    private int idade;
    private int pontos;
    public String habilitacao;

    Motorista(String nome, int idade, String habilitacao, int pontos) {
        this.nome = nome;
        this.idade = idade;
        this.habilitacao = habilitacao;
        this.pontos = pontos;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        if (idade <= 0) {
            throw new IllegalArgumentException();
        }
        return idade;
    }

    public int getPontos() {
        return pontos;
    }

    public String getHabilitacao() {
        return habilitacao;
    }

    public boolean isIrregular() {
        return this.idade < 18 || this.pontos > 20;
    }

    public boolean isSenior() {
        return this.idade >= 55;
    }

    public static MotoristaBuilder builder() {
        return new MotoristaBuilder();
    }

}
