package pl.lukbol.TimeTracking.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Workday {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long Id;
    private String date;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "workday", cascade = CascadeType.ALL)

    private List<pl.lukbol.TimeTracking.models.TimeEntry> TimeEntry;
    public Workday()
    {
    }
    public Workday(String date)
    {
        this.date = date;
    }

    public Long getId() {return this.Id;}

    public void setId(Long id) {this.Id = id;}

    public String getDate() {return this.date;}

    public void setDate(String date) {this.date = date;}

    public List<TimeEntry> getTimeEntry() {return this.TimeEntry;}

    public void setTimeEntry(TimeEntry t_entry) {this.TimeEntry = (List<TimeEntry>) t_entry;}

}
