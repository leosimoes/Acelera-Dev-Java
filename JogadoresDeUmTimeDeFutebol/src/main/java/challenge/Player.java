package challenge;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author Leonardo Simões
 */
public class Player {

    public Player() {
    }

    private Long ID;
    private String fullName;
    private String club;
    private String nationality;
    private BigDecimal eurReleaseClause;
    private LocalDate birthDate;
    private Integer age;
    private Double eurWage;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public BigDecimal getEurReleaseClause() {
        return eurReleaseClause;
    }

    public void setEurReleaseClause(String eurReleaseClause) {
        if (eurReleaseClause.isEmpty()) {
            this.eurReleaseClause = BigDecimal.valueOf(0.0);
        } else {
            this.eurReleaseClause = new BigDecimal(eurReleaseClause);
        }

    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getEurWage() {
        return eurWage;
    }

    public void setEurWage(Double eurWage) {
        this.eurWage = eurWage;
    }

    @Override
    public String toString() {
        return "Player{" + "ID=" + ID + ", fullName=" + fullName + ", club=" + club + ", nationality=" + nationality + ", eurReleaseClause=" + eurReleaseClause + ", birthDate=" + birthDate + ", age=" + age + ", eurWage=" + eurWage + '}';
    }

}
