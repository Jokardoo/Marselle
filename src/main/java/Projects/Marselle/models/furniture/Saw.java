package Projects.Marselle.models.furniture;

import Projects.Marselle.models.Person;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Table(name = "saw")
@Entity
public class Saw {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "saw_id")
    private int id;


    @Column(name = "count")
    private Integer count;

    @Column(name = "date")
    private Date date;

    @Column(name = "type")
    private String type;

    @ManyToMany(fetch = FetchType.LAZY,  cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name = "person_saw",
            joinColumns = @JoinColumn(name = "saw_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id"))
    private List<Person> people;

    public Saw() {

    }



    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
