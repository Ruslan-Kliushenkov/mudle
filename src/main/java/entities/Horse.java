package entities;


import javax.persistence.*;

@Entity
@Table(name = "Horses")
public class Horse {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int place;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "horse_race")
    private Trace race;

    private String name;

    public Horse(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public Trace getRace() {
        return race;
    }

    public void setRace(Trace race) {
        this.race = race;
    }

    public Horse() {
    }

    @Override
    public String toString() {
        return "Horse{" +
                "id=" + id +
                ", place=" + place +
                ", race=" + race +
                ", name='" + name + '\'' +
                '}';
    }

    public Horse(int id, int place, Trace race, String name) {
        this.id = id;
        this.place = place;
        this.race = race;
        this.name = name;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
