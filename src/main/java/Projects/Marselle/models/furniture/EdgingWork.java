package Projects.Marselle.models.furniture;

import Projects.Marselle.models.Person;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "edging_work")
public class EdgingWork {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "edging_id")
    private Integer id;

    @Column(name = "count")
    private Integer count;

    @Column(name = "date")
    private Date date;

    @ManyToMany(fetch = FetchType.LAZY,  cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name = "person_saw",
            joinColumns = @JoinColumn(name = "edging_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id"))
    private List<Person> peopleEdging;

    public EdgingWork() {

    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Person> getPeopleEdging() {
        return peopleEdging;
    }

    public void setPeopleEdging(List<Person> peopleEdging) {
        this.peopleEdging = peopleEdging;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
