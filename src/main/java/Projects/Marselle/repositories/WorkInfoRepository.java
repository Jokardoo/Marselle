package Projects.Marselle.repositories;

import Projects.Marselle.models.Person;
import Projects.Marselle.models.furniture.WorkInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface WorkInfoRepository extends JpaRepository<WorkInfo, Integer> {
    List<WorkInfo> findAllByDate(Date date);

    @Query("SELECT o from WorkInfo o WHERE MONTH(o.date) = :month and YEAR(o.date) = :year and o.worker =:worker")
    List<WorkInfo> findWorkInfoByDateAndWorker(@Param("month") int month, @Param("year") int year, @Param("worker") String worker);
}
