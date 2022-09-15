package pl.lukbol.TimeTracking.models;


import javax.persistence.*;

@Entity
public class TimeEntry {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long Id;
    public String opis;
    public int czas;
    @ManyToOne()
    @JoinColumn(name="workday_id")

    private Workday workday;

    public TimeEntry(){}

    public TimeEntry(String opis, int czas)
    {
        this.opis=opis;
        this.czas=czas;
    }
    public Long getId() {return this.Id;}

    public void setId(Long Id) {this.Id=Id;}

    public String getOpis(){return this.opis;}

    public void setOpis(String opis) {this.opis=opis;}

    public int getCzas(){return this.czas;}

    public void setCzas(int czas) {this.czas=czas;}
    public void setWorkday(Workday workday) {
        this.workday = workday;
    }
}
