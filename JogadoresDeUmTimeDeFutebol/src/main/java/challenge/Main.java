package challenge;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


public class Main {

    public List<Player> players;

    public Main() {
        this.players = ReadCSVPlayers.lerCSV("src/main/resources/data.csv");
    }

    // Quantas nacionalidades (coluna `nationality`) diferentes existem no arquivo?
    public int q1() {
        Set<String> nacionalidades = this.players.stream().map(Player::getNationality).collect(Collectors.toSet());
        return nacionalidades.size();
    }

    // Quantos clubes (coluna `club`) diferentes existem no arquivo?
    // Obs: Existem jogadores sem clube.
    public int q2() {
        Set<String> clubes = this.players.stream().filter(p -> !p.getClub().isEmpty()).map(Player::getClub).collect(Collectors.toSet());
        return clubes.size();
    }

    // Liste o nome completo (coluna `full_name`) dos 20 primeiros jogadores.
    public List<String> q3() {
        // Accumulate names into a List
        List<String> fullNames = players.subList(0, 20).stream().map(Player::getFullName).collect(Collectors.toList());
        return fullNames;
    }

    // Quem são os top 10 jogadores que possuem as maiores cláusulas de rescisão?
    // (utilize as colunas `full_name` e `eur_release_clause`)
    public List<String> q4() {
        List<String> fullNames = this.players.stream().sorted(Comparator.comparing(Player::getEurReleaseClause).reversed()).map(Player::getFullName).collect(Collectors.toList());
        return fullNames.subList(0, 10);
    }

    // Quem são os 10 jogadores mais velhos (use como critério de desempate o campo `eur_wage`)?
    // (utilize as colunas `full_name` e `birth_date`)
    public List<String> q5() {
        List<String> fullNames = this.players.stream().sorted(Comparator.comparing(Player::getBirthDate).thenComparing(Player::getEurWage)).map(Player::getFullName).collect(Collectors.toList());
        return fullNames.subList(0, 10);
    }

    // Conte quantos jogadores existem por idade. Para isso, construa um mapa onde as chaves são as idades e os valores a contagem.
    // (utilize a coluna `age`)
    public Map<Integer, Integer> q6() {
        Map<Integer, Long> m = this.players.stream().collect(Collectors.groupingBy(Player::getAge, Collectors.counting()));;
        Map<Integer, Integer> m2 = new HashMap<Integer, Integer>();
        m.entrySet().stream().forEach(e -> m2.put(e.getKey(), Integer.valueOf(Long.toString(e.getValue()))));
        return m2;
    }

}
