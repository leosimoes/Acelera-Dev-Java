package challenge;

/**
 *
 * @author Leonardo Simões
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class ReadCSVPlayers {

    public static List<Player> lerCSV(String diretorioRelativo) {
        List<Player> players = new ArrayList<Player>();
        try {
            String diretorio = new File(diretorioRelativo).getCanonicalPath();
            BufferedReader reader = new BufferedReader(new FileReader(diretorio));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                    .withHeader("ID", "name", "full_name", "club", "club_logo", 
                            "special", "age", "league", "birth_date", "height_cm", 
                            "weight_kg", "body_type", "real_face", "flag", "nationality", 
                            "photo", "eur_value", "eur_wage", "eur_release_clause", 
                            "overall", "potential", "pac", "sho", "pas", "dri", "def", 
                            "phy", "international_reputation", "skill_moves", "weak_foot", 
                            "work_rate_att", "work_rate_def", "preferred_foot", "crossing", 
                            "finishing", "heading_accuracy", "short_passing", "volleys", 
                            "dribbling", "curve", "free_kick_accuracy", "long_passing", 
                            "ball_control", "acceleration", "sprint_speed", "agility", 
                            "reactions", "balance", "shot_power", "jumping", "stamina", 
                            "strength", "long_shots", "aggression", "interceptions", 
                            "positioning", "vision", "penalties", "composure", "marking", 
                            "standing_tackle", "sliding_tackle", "gk_diving", "gk_handling", 
                            "gk_kicking", "gk_positioning", "gk_reflexes", "rs", "rw", "rf", 
                            "ram", "rcm", "rm", "rdm", "rcb", "rb", "rwb", "st", "lw", "cf", 
                            "cam", "cm", "lm", "cdm", "cb", "lb", "lwb", "ls", "lf", "lam", 
                            "lcm", "ldm", "lcb", "gk", "1_on_1_rush_trait", 
                            "acrobatic_clearance_trait", "argues_with_officials_trait", 
                            "avoids_using_weaker_foot_trait", "backs_into_player_trait", 
                            "bicycle_kicks_trait", "cautious_with_crosses_trait", 
                            "chip_shot_trait", "chipped_penalty_trait", 
                            "comes_for_crosses_trait", "corner_specialist_trait", 
                            "diver_trait", "dives_into_tackles_trait", "diving_header_trait", 
                            "driven_pass_trait", "early_crosser_trait", "fan's_favourite_trait", 
                            "fancy_flicks_trait", "finesse_shot_trait", "flair_trait", 
                            "flair_passes_trait", "gk_flat_kick_trait", "gk_long_throw_trait", 
                            "gk_up_for_corners_trait", "giant_throw_in_trait", "inflexible_trait", 
                            "injury_free_trait", "injury_prone_trait", "leadership_trait", 
                            "long_passer_trait", "long_shot_taker_trait", "long_throw_in_trait", 
                            "one_club_player_trait", "outside_foot_shot_trait", "playmaker_trait", 
                            "power_free_kick_trait", "power_header_trait", "puncher_trait",
                            "rushes_out_of_goal_trait", "saves_with_feet_trait", "second_wind_trait", 
                            "selfish_trait", "skilled_dribbling_trait", "stutter_penalty_trait",
                            "swerve_pass_trait", "takes_finesse_free_kicks_trait", "target_forward_trait", 
                            "team_player_trait", "technical_dribbler_trait", "tries_to_beat_defensive_line_trait", 
                            "poacher_speciality", "speedster_speciality", "aerial_threat_speciality", 
                            "dribbler_speciality", "playmaker_speciality", "engine_speciality", 
                            "distance_shooter_speciality", "crosser_speciality", "free_kick_specialist_speciality", 
                            "tackling_speciality", "tactician_speciality", "acrobat_speciality", 
                            "strength_speciality", "clinical_finisher_speciality", "prefers_rs", 
                            "prefers_rw", "prefers_rf", "prefers_ram", "prefers_rcm", "prefers_rm", 
                            "prefers_rdm", "prefers_rcb", "prefers_rb", "prefers_rwb", "prefers_st", 
                            "prefers_lw", "prefers_cf", "prefers_cam", "prefers_cm", "prefers_lm", "prefers_cdm", 
                            "prefers_cb", "prefers_lb", "prefers_lwb", "prefers_ls", "prefers_lf", "prefers_lam", 
                            "prefers_lcm", "prefers_ldm", "prefers_lcb", "prefers_gk")
                    .withIgnoreHeaderCase().withSkipHeaderRecord().withTrim());
            for (CSVRecord csvRecord : csvParser) {
                Player player = new Player();
                player.setID(Long.parseLong(csvRecord.get("ID")));
                player.setFullName(csvRecord.get("full_name"));
                player.setClub(csvRecord.get("club"));
                player.setAge(Integer.parseInt(csvRecord.get("age")));
                DateTimeFormatter formatador = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate data = LocalDate.parse(csvRecord.get("birth_date"), formatador);
                player.setBirthDate(data);
                player.setNationality(csvRecord.get("nationality"));
                player.setEurWage(Double.parseDouble(csvRecord.get("eur_wage")));
                player.setEurReleaseClause(csvRecord.get("eur_release_clause"));               
                players.add(player);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Erro de arquivo não encontrado");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro na leitura do arquivo");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro");
        }
        return players;
    }
}
