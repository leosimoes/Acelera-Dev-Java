package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author L30
 */
public class Main {
    public static void main(String[] args) {
        DesafioMeuTimeApplication d = new DesafioMeuTimeApplication();
        d.incluirJogador(1L, 1L, "Messi", LocalDate.now(), 900, BigDecimal.valueOf(2000));
    }
 
}
