package challenge;

import java.util.ArrayList;
import java.util.List;

public class Estacionamento {

    public final int NUM_MAX_CARROS = 10;
    private List<Carro> carrosEstacionados = new ArrayList<>();

    public void estacionar(Carro carro) throws EstacionamentoException {
        if (carro.isAutonomo() || carro.hasMotoristaIrregular()) {
            throw new EstacionamentoException();
        }
        boolean lotado = this.carrosEstacionados.size() == NUM_MAX_CARROS;
        boolean todosSeniores = lotado && this.carrosEstacionados.stream().filter(c -> c.hasMotoristaSenior()).count() == NUM_MAX_CARROS;
        if (todosSeniores) {
            throw new EstacionamentoException();
        }
        if (lotado) {
            Carro carroRemocao = this.carrosEstacionados.stream().filter(c -> !c.hasMotoristaSenior()).findFirst().get();
            this.carrosEstacionados.remove(carroRemocao);
        }
        this.carrosEstacionados.add(carro);
    }

    public int carrosEstacionados() {
        return this.carrosEstacionados.size();
    }

    public boolean carroEstacionado(Carro carro) {
        return this.carrosEstacionados.contains(carro);
    }

}
