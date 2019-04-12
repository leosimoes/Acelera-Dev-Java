package challenge;

public class Carro {

    private Motorista motorista;
    private String placa;
    private Cor cor;

    Carro(Motorista motorista, String placa, Cor cor) {
        this.motorista = motorista;
        this.placa = placa;
        this.cor = cor;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public String getPlaca() {
        return placa;
    }

    public Cor getCor() {
        return cor;
    }

    public boolean isAutonomo() {
        return this.motorista == null;
    }

    public static CarroBuilder builder() {
        return new CarroBuilder();
    }

    public boolean hasMotoristaIrregular() {
        if (this.motorista == null) {
            return false;
        }
        return this.motorista.isIrregular();
    }

    public boolean hasMotoristaSenior() {
        if (this.motorista == null) {
            return false;
        }
        return this.motorista.isSenior();
    }

}
