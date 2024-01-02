package Projects.Marselle.models.furniture;

import Projects.Marselle.models.Person;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "workinfo")
public class WorkInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "work_info_id")
    private Integer workInfoId;


    @Column(name = "worker")
    private String worker;

    @Column(name = "date")
    private Date date;

    @Column(name = "nameofwork")
    private String nameOfWork;

    @Column(name = "count")
    private Integer count;

    @Column(name = "costofwork")
    private Integer costOfWork;

    @ManyToOne()
    @JoinColumn(name = "worker_id", referencedColumnName = "id")
    private Person personWork;

    public WorkInfo() {

    }
    @Autowired

    public WorkInfo(String worker, Date date, String nameOfWork, Integer count, Integer costOfWork, Person personWork) {
        this.worker = worker;
        this.date = date;
        this.nameOfWork = nameOfWork;
        this.count = count;
        this.costOfWork = costOfWork;
        this.personWork = personWork;
    }

    public Integer getWorkInfoId() {
        return workInfoId;
    }

    public void setWorkInfoId(Integer workInfoId) {
        this.workInfoId = workInfoId;
    }

    public Person getPersonWork() {
        return personWork;
    }

    public void setPersonWork(Person personWork) {
        this.personWork = personWork;
    }

    public String getWorker() {
        return worker;
    }

    public void setWorker(String worker) {
        this.worker = worker;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNameOfWork() {
        return nameOfWork;
    }

    public void setNameOfWork(String nameOfWork) {
        this.nameOfWork = nameOfWork;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getCostOfWork() {
        return costOfWork;
    }


    public void setCostOfWork(Integer costOfWork) {
        this.costOfWork = costOfWork;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkInfo workInfo = (WorkInfo) o;
        return Objects.equals(worker, workInfo.worker) && Objects.equals(date, workInfo.date) && Objects.equals(nameOfWork, workInfo.nameOfWork) && Objects.equals(count, workInfo.count) && Objects.equals(costOfWork, workInfo.costOfWork) && Objects.equals(personWork, workInfo.personWork);
    }

    @Override
    public int hashCode() {
        return Objects.hash(worker, date, nameOfWork, count, costOfWork, personWork);
    }


}
