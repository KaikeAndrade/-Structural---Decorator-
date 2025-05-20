((Structural - Decorator))

interface Carro {
    String montar();
}

class CarroBase implements Carro {
    public String montar() {
        return "Modelo base";
    }
}

abstract class CarroDecorator implements Carro {
    protected Carro carro;

    public CarroDecorator(Carro carro) {
        this.carro = carro;
    }
}

class TetoSolar extends CarroDecorator {
    public TetoSolar(Carro carro) {
        super(carro);
    }

    public String montar() {
        return carro.montar() + ", com teto solar";
    }
}

class PilotoAutomatico extends CarroDecorator {
    public PilotoAutomatico(Carro carro) {
        super(carro);
    }

    public String montar() {
        return carro.montar() + ", com piloto automático";
    }
}

public class ClienteDecorator {
    public static void main(String[] args) {
        Carro carro = new CarroBase();
        carro = new TetoSolar(carro);
        carro = new PilotoAutomatico(carro);

        System.out.println(carro.montar());
    }
}