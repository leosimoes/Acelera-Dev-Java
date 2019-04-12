package br.com.codenation;

/**
 * @author Leonardo Simões
 */
import br.com.codenation.desafio.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.desafio.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.desafio.exceptions.TimeNaoEncontradoException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;

public class DesafioTimeApplicationTest {
    
    public static DesafioMeuTimeApplication main;
    public static Time timeT;
    
    @Before
    public void setUp() {
        main = new DesafioMeuTimeApplication();
        timeT = new Time(1L, "TimeTeste", LocalDate.MIN, "corUniformePrincipal", "corUniformeSecundario");
        Jogador jogadorT = new Jogador(1L, 1L, "JogadorTeste", LocalDate.MIN, Integer.MIN_VALUE, BigDecimal.ZERO);
    }

    //-----------------------------------incluirTime-----------------------------------//
    @Test
    public void incluirTime_Sucesso() {
        main.incluirTime(timeT.getId(), timeT.getNome(), timeT.getDataCriacao(), timeT.getCorUniformePrincipal(), timeT.getCorUniformeSecundario());
        assertTrue(main.getTimes().contains(timeT));
    }
    
    @Test(expected = IdentificadorUtilizadoException.class)
    public void incluirTime_Falha_IdRepetido() {
        main.incluirTime(1L, "Nome", LocalDate.MIN, "Cor1", "Cor2");
        main.incluirTime(1L, "Nome", LocalDate.MIN, "Cor1", "Cor2");
    }

    //-----------------------------------incluirJogador-----------------------------------//
    @Test
    public void incluirJogador_Sucesso() {
        main.incluirTime(timeT.getId(), timeT.getNome(), timeT.getDataCriacao(), timeT.getCorUniformePrincipal(), timeT.getCorUniformeSecundario());
        main.incluirJogador(1L, 1L, "A", LocalDate.MIN, Integer.MIN_VALUE, BigDecimal.ZERO);
    }
    
    @Test(expected = IdentificadorUtilizadoException.class)
    public void incluirJogador_Falha_IdRepetido() {
        main.incluirTime(timeT.getId(), timeT.getNome(), timeT.getDataCriacao(), timeT.getCorUniformePrincipal(), timeT.getCorUniformeSecundario());
        main.incluirJogador(1L, 1L, "A", LocalDate.MIN, Integer.MIN_VALUE, BigDecimal.ZERO);
        main.incluirJogador(1L, 1L, "A", LocalDate.MIN, Integer.MIN_VALUE, BigDecimal.ZERO);
    }
    
    @Test(expected = TimeNaoEncontradoException.class)
    public void incluirJogador_Falha_SemTime() {
        main.incluirJogador(1L, 1L, "A", LocalDate.MIN, Integer.MIN_VALUE, BigDecimal.ZERO);
    }

    //-----------------------------------definirCapitao-----------------------------------//
    @Test
    public void definirBuscarCapitaoTime_Sucesso() {
        main.incluirTime(timeT.getId(), timeT.getNome(), timeT.getDataCriacao(), timeT.getCorUniformePrincipal(), timeT.getCorUniformeSecundario());
        main.incluirJogador(1L, 1L, "A", LocalDate.MIN, Integer.MIN_VALUE, BigDecimal.ZERO);
        main.definirCapitao(1L);
        main.buscarCapitaoDoTime(1L);
        assertEquals(Long.valueOf(1L), main.buscarCapitaoDoTime(1L));
    }
    
    @Test(expected = JogadorNaoEncontradoException.class)
    public void definirBuscarCapitaoTime_FalhaJogador() {
        main.incluirTime(timeT.getId(), timeT.getNome(), timeT.getDataCriacao(), timeT.getCorUniformePrincipal(), timeT.getCorUniformeSecundario());
        main.definirCapitao(1L);
    }

    //---**CapitaoDoTime
    @Test(expected = TimeNaoEncontradoException.class)
    public void definirBuscarCapitaoTime_FalhaTime() {
        main.buscarCapitaoDoTime(1L);
    }
    
    @Test(expected = CapitaoNaoInformadoException.class)
    public void definirBuscarCapitaoTime_FalhaCapitao() {
        main.incluirTime(timeT.getId(), timeT.getNome(), timeT.getDataCriacao(), timeT.getCorUniformePrincipal(), timeT.getCorUniformeSecundario());
        main.buscarCapitaoDoTime(1L);
    }

    //-----------------------------------buscarNomeJogador-----------------------------------//
    @Test
    public void buscarNomeJogador_Sucesso() {
        
        main.incluirTime(timeT.getId(), timeT.getNome(), timeT.getDataCriacao(), timeT.getCorUniformePrincipal(), timeT.getCorUniformeSecundario());
        main.incluirJogador(1L, 1L, "A", LocalDate.MIN, Integer.MIN_VALUE, BigDecimal.ZERO);
        assertEquals("A", main.buscarNomeJogador(1L));
    }
    
    @Test(expected = JogadorNaoEncontradoException.class)
    public void buscarNomeJogador_Falha() {
        main.incluirTime(timeT.getId(), timeT.getNome(), timeT.getDataCriacao(), timeT.getCorUniformePrincipal(), timeT.getCorUniformeSecundario());
        //main.incluirJogador(1L, 1L, "A", LocalDate.MIN, Integer.MIN_VALUE, BigDecimal.ZERO);
        assertEquals("A", main.buscarNomeJogador(1L));
    }

    //-----------------------------------buscarNomeTime-----------------------------------//
    @Test
    public void buscarNomeTime_Sucesso() {
        main.incluirTime(timeT.getId(), timeT.getNome(), timeT.getDataCriacao(), timeT.getCorUniformePrincipal(), timeT.getCorUniformeSecundario());
        assertEquals(timeT.getNome(), main.buscarNomeTime(timeT.getId()));
    }
    
    @Test(expected = TimeNaoEncontradoException.class)
    public void buscarNomeTime_Falha() {
        main.buscarNomeTime(timeT.getId());
        
    }

    //-----------------------------------buscarJogadoresDoTime-----------------------------------//
    public void buscarJogadoresDoTime_Sucesso() {
        main.incluirTime(timeT.getId(), timeT.getNome(), timeT.getDataCriacao(), timeT.getCorUniformePrincipal(), timeT.getCorUniformeSecundario());
        main.incluirJogador(1L, 1L, "A", LocalDate.MIN, Integer.valueOf(10), BigDecimal.ZERO);
        main.incluirJogador(3L, 1L, "C", LocalDate.MIN, Integer.valueOf(100), BigDecimal.ZERO);
        main.incluirJogador(2L, 1L, "B", LocalDate.MIN, Integer.valueOf(100), BigDecimal.ZERO);
        
        List<Long> jogadores = Arrays.asList(1L, 2L, 3L);
        assertEquals(jogadores, main.buscarMelhorJogadorDoTime(1L));
    }
    
    @Test(expected = TimeNaoEncontradoException.class)
    public void buscarJogadoresDoTime_Falha() {
        main.buscarNomeTime(timeT.getId());
        
    }

    //-----------------------------------buscarMelhorJogadorDoTime-----------------------------------//
    public void buscarMelhorJogadorDoTime_Sucesso() {
        main.incluirTime(timeT.getId(), timeT.getNome(), timeT.getDataCriacao(), timeT.getCorUniformePrincipal(), timeT.getCorUniformeSecundario());
        main.incluirJogador(1L, 1L, "A", LocalDate.MIN, Integer.valueOf(10), BigDecimal.ZERO);
        main.incluirJogador(2L, 1L, "B", LocalDate.MIN, Integer.valueOf(100), BigDecimal.ZERO);
        main.incluirJogador(3L, 1L, "C", LocalDate.MIN, Integer.valueOf(50), BigDecimal.ZERO);
        assertEquals(Long.valueOf(2L), main.buscarMelhorJogadorDoTime(1L));
    }
    
    public void buscarMelhorJogadorDoTime_habilidadeIguais_Sucesso() {
        main.incluirTime(timeT.getId(), timeT.getNome(), timeT.getDataCriacao(), timeT.getCorUniformePrincipal(), timeT.getCorUniformeSecundario());
        main.incluirJogador(1L, 1L, "A", LocalDate.MIN, Integer.valueOf(10), BigDecimal.ZERO);
        main.incluirJogador(2L, 1L, "B", LocalDate.MIN, Integer.valueOf(100), BigDecimal.ZERO);
        main.incluirJogador(3L, 1L, "C", LocalDate.MIN, Integer.valueOf(100), BigDecimal.ZERO);
        assertEquals(Long.valueOf(2L), main.buscarMelhorJogadorDoTime(1L));
    }
    
    @Test(expected = TimeNaoEncontradoException.class)
    public void buscarMelhorJogadorDoTime_Falha() {
        main.buscarNomeTime(timeT.getId());
        
    }

    //-----------------------------------buscarJogadorMaisVelho-----------------------------------//
    @Test
    public void buscarJogadorMaisVelho_DatasDiferentes() {
        main.incluirTime(1L, "Nome", LocalDate.MIN, "Cor1", "Cor2");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate parsedDate = LocalDate.parse("01/05/2001", formatter);
        LocalDate parsedDate2 = LocalDate.parse("01/05/2000", formatter);
        LocalDate parsedDate3 = LocalDate.parse("01/05/2050", formatter);
        main.incluirJogador(3L, 1L, "C", parsedDate3, 5, BigDecimal.ZERO);
        main.incluirJogador(1L, 1L, "A", parsedDate, 5, BigDecimal.ZERO);
        main.incluirJogador(2L, 1L, "B", parsedDate2, 5, BigDecimal.ZERO);
        assertEquals(Long.valueOf(2L), main.buscarJogadorMaisVelho(1L));
    }
    
    @Test
    public void buscarJogadorMaisVelho_DatasIguais() {
        main.incluirTime(1L, "Nome", LocalDate.MIN, "Cor1", "Cor2");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate parsedDate = LocalDate.parse("01/05/2000", formatter);
        main.incluirJogador(3L, 1L, "C", parsedDate, 5, BigDecimal.ZERO);
        main.incluirJogador(1L, 1L, "A", parsedDate, 5, BigDecimal.ZERO);
        main.incluirJogador(2L, 1L, "B", parsedDate, 5, BigDecimal.ZERO);
        assertEquals(Long.valueOf(1L), main.buscarJogadorMaisVelho(1L));
    }

    //-----------------------------------buscarTimes-----------------------------------//
    @Test
    public void buscarTimes() {
        main.incluirTime(1L, "Nome", LocalDate.MIN, "Cor1", "Cor2");
        main.incluirTime(3L, "Nome", LocalDate.MIN, "Cor1", "Cor2");
        main.incluirTime(2L, "Nome", LocalDate.MIN, "Cor1", "Cor2");
        assertEquals(Arrays.asList(1L, 2L, 3L), main.buscarTimes());
    }

    //-----------------------------------buscarJogadorMaiorSalario-----------------------------------//
    @Test
    public void buscarJogadorMaiorSalario_Sucesso() {
        main.incluirTime(1L, "Nome", LocalDate.MIN, "Cor1", "Cor2");
        main.incluirJogador(1L, 1L, "A", LocalDate.MIN, Integer.MIN_VALUE, BigDecimal.valueOf(300));
        main.incluirJogador(2L, 1L, "B", LocalDate.MIN, Integer.MIN_VALUE, BigDecimal.valueOf(600.00));
        main.incluirJogador(3L, 1L, "C", LocalDate.MIN, Integer.MIN_VALUE, BigDecimal.valueOf(600.00));
        main.incluirJogador(4L, 1L, "D", LocalDate.MIN, Integer.MIN_VALUE, BigDecimal.valueOf(500));
        assertEquals(Long.valueOf(2L), main.buscarJogadorMaiorSalario(timeT.getId()));
    }
    
    @Test(expected = TimeNaoEncontradoException.class)
    public void buscarJogadorMaiorSalario_Falha() {
        main.buscarJogadorMaiorSalario(timeT.getId());
    }

    //---------------------------------buscarSalarioDoJogador---------------------------------//
    @Test(expected = JogadorNaoEncontradoException.class)
    public void buscarSalarioDoJogador_Falha() {
        main.buscarSalarioDoJogador(Long.valueOf(1L));
    }
    
    @Test
    public void buscarSalarioDoJogador_Sucesso() {
        main.incluirTime(1L, "Nome", LocalDate.MIN, "Cor1", "Cor2");
        main.incluirJogador(1L, 1L, "A", LocalDate.MIN, Integer.MIN_VALUE, BigDecimal.valueOf(300));
        main.buscarSalarioDoJogador(Long.valueOf(1L));
        assertEquals(BigDecimal.valueOf(300), main.buscarSalarioDoJogador(1L));
    }

    //-----------------------------------buscarTopJogadores-----------------------------------//
    @Test
    public void buscarTopJogadores_SemJogadores() {
        assertTrue(main.buscarTopJogadores(5).isEmpty());
    }
    
    @Test
    public void buscarTopJogadores_Sucesso() {
        main.incluirTime(1L, "Nome", LocalDate.MIN, "Cor1", "Cor2");
        main.incluirJogador(1L, 1L, "A", LocalDate.MIN, Integer.valueOf(500), BigDecimal.ZERO);
        assertEquals(Arrays.asList(1L), main.buscarTopJogadores(1));
    }
    
    @Test
    public void buscarTopJogadores_Sucesso2() {
        main.incluirTime(1L, "Nome", LocalDate.MIN, "Cor1", "Cor2");
        main.incluirJogador(1L, 1L, "A", LocalDate.MIN, Integer.valueOf(600), BigDecimal.ZERO);
        main.incluirJogador(2L, 1L, "A", LocalDate.MIN, Integer.valueOf(400), BigDecimal.ZERO);
        main.incluirJogador(3L, 1L, "A", LocalDate.MIN, Integer.valueOf(500), BigDecimal.ZERO);
        assertEquals(Arrays.asList(1L, 3L, 2L), main.buscarTopJogadores(3));
    }
    
    @Test
    public void buscarTopJogadores_Sucesso3() {
        main.incluirTime(1L, "Nome", LocalDate.MIN, "Cor1", "Cor2");
        main.incluirJogador(3L, 1L, "A", LocalDate.MIN, Integer.valueOf(600), BigDecimal.ZERO);
        main.incluirJogador(2L, 1L, "A", LocalDate.MIN, Integer.valueOf(600), BigDecimal.ZERO);
        main.incluirJogador(1L, 1L, "A", LocalDate.MIN, Integer.valueOf(600), BigDecimal.ZERO);
        assertEquals(Arrays.asList(1L, 2L, 3L), main.buscarTopJogadores(3));
    }

    //-----------------------------------buscarCorCamisaTimeDeFora"-----------------------------------//
    @Test(expected = TimeNaoEncontradoException.class)
    public void BuscarCorCamisaTimeDeFora_SemTimeCasa() {
        //Time timeT1 = new Time(2L, "TimeTeste", LocalDate.MIN, "corUniformePrincipal", "corUniformeSecundario");
        //Time timeT2 = new Time(3L, "TimeTeste", LocalDate.MIN, "corUniformePrincipal", "corUniformeSecundario");
        main.buscarCorCamisaTimeDeFora(2L, 1L);
    }
    
    @Test(expected = TimeNaoEncontradoException.class)
    public void BuscarCorCamisaTimeDeFora_SemTimeFora() {
        //Time timeT1 = new Time(2L, "TimeTeste", LocalDate.MIN, "corUniformePrincipal", "corUniformeSecundario");
        //Time timeT2 = new Time(3L, "TimeTeste", LocalDate.MIN, "corUniformePrincipal", "corUniformeSecundario");
        main.buscarCorCamisaTimeDeFora(1L, 3L);
    }
    
    @Test(expected = TimeNaoEncontradoException.class)
    public void BuscarCorCamisaTimeDeFora_SemTimeCaseEFora() {
        //Time timeT1 = new Time(2L, "TimeTeste", LocalDate.MIN, "corUniformePrincipal", "corUniformeSecundario");
        //Time timeT2 = new Time(3L, "TimeTeste", LocalDate.MIN, "corUniformePrincipal", "corUniformeSecundario");
        main.buscarCorCamisaTimeDeFora(2L, 3L);
    }
    
    @Test
    public void BuscarCorCamisaTimeDeFora_CamisaPrincipal() {
        main.incluirTime(50L, "TimeCasa", LocalDate.MIN, "corUniformePrincipalCasa", "corUniformeSecundarioCasa");
        main.incluirTime(51L, "TimeFora", LocalDate.MIN, "corUniformePrincipalFora", "corUniformeSecundarioFora");
        assertEquals("corUniformePrincipalFora", main.buscarCorCamisaTimeDeFora(50L, 51L));
    }
    
    @Test
    public void testaBuscarCorCamisaTimeDeFora_CamisaSecundaria() {
        main.incluirTime(50L, "TimeCasa", LocalDate.MIN, "corUniformePrincipal", "corUniformeSecundarioCasa");
        main.incluirTime(51L, "TimeFora", LocalDate.MIN, "corUniformePrincipal", "corUniformeSecundarioFora");
        assertEquals("corUniformeSecundarioFora", main.buscarCorCamisaTimeDeFora(50L, 51L));
    }
    
}
