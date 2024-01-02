package Projects.Marselle.services;

import Projects.Marselle.models.furniture.WorkInfo;
import Projects.Marselle.repositories.WorkInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class WorkInfoService {
    private final WorkInfoRepository workInfoRepository;

    @Autowired
    public WorkInfoService(WorkInfoRepository workInfoRepository) {
        this.workInfoRepository = workInfoRepository;
    }

    public WorkInfoRepository getWorkInfoRepository() {
        return workInfoRepository;
    }

    public List<WorkInfo> findAllByDate(Date date) {
        return workInfoRepository.findAllByDate(date);
    }

    public void save(WorkInfo workInfo) {
        workInfoRepository.save(workInfo);
    }

    public List<WorkInfo> findWorkInfoByDateAndWorker(int month, int year, String worker) {
        return workInfoRepository.findWorkInfoByDateAndWorker(month, year,  worker);
    }
}
