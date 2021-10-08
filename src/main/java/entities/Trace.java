package entities;

import entities.Horse;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "Races")
public class Trace {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "Date")
    private String time;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setHorseList(List<Horse> horseList) {
        this.horseList = horseList;
    }

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "race",cascade = CascadeType.ALL)
    private List<Horse> horseList = new ArrayList<>();

    private String betOn;

    @Override
    public String toString() {
        return "Trace{" +
                "id=" + id +
                ", horseList=" + horseList +
                ", betOn='" + betOn + '\'' +
                '}';
    }

    public Trace() {
    }

    public void addToList(Horse horse){
        this.horseList.add(horse);
    }

    public Trace(int id, ArrayList<Horse> horseList, String betOn) {
        this.id = id;
        this.horseList = horseList;
        this.betOn = betOn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Horse> getHorseList() {
        return horseList;
    }

    public void setHorseList(ArrayList<Horse> horseList) {

        this.horseList.addAll(horseList);

    }

    public String getBetOn() {
        return betOn;
    }

    public void setBetOn(String betOn) {
        this.betOn = betOn;
    }
}
