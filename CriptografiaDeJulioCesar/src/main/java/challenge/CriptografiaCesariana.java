package challenge;

import java.util.function.Function;

public class CriptografiaCesariana implements Criptografia {

    private String crip(String texto, Function<Integer, Integer> f) {
        return texto.chars().map((c) -> {
            if (Character.isLetter((char) c)) {
                return f.apply(c);
            }
            return c;
        }).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
    }

    @Override
    public String criptografar(String texto) {
        if (texto.equals("")) {
            throw new IllegalArgumentException();
        } else if (texto == null) {
            throw new NullPointerException();
        }
        return crip(texto.toLowerCase(),
                caracter -> {
                    caracter = caracter + 3;
                    if (!Character.isLetter(caracter)) {
                        caracter = ((int) 'a' - 1) + (caracter - (int) 'z');
                    }
                    return caracter;
                }
        );
    }

    @Override
    public String descriptografar(String texto) {
        if (texto.equals("")) {
            throw new IllegalArgumentException();
        } else if (texto == null) {
            throw new NullPointerException();
        }
        return crip(texto.toLowerCase(),
                caracter -> {
                    caracter = caracter - 3;
                    if (!Character.isLetter(caracter)) {
                        caracter = ((int) 'z' + 1) + (((int) 'a') - caracter);
                    }
                    return caracter;
                }
        );
    }
}
