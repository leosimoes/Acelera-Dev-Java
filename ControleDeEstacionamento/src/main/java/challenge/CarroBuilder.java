package challenge;

import java.util.Objects;

public class CarroBuilder {

    private Motorista motorista;
    private String placa;
    private Cor cor;

    public CarroBuilder withCor(Cor cor) {
        this.cor = cor;
        return this;
    }

    public CarroBuilder withPlaca(String placa) {
        this.placa = placa;
        return this;
    }

    public CarroBuilder withMotorista(Motorista motorista) {
        this.motorista = motorista;
        return this;
    }

    public Carro build() {
        //Objects.requireNonNull(this.motorista, "o motorista é obrigatório");
        Objects.requireNonNull(this.placa, "a placa é obrigatória");
        Objects.requireNonNull(this.cor, "a cor é obrigatória");
        return new Carro(this.motorista, this.placa, this.cor);
    }

}
