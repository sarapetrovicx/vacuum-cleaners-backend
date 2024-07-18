package rs.raf.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import rs.raf.demo.model.ScheduledOperation;
import rs.raf.demo.model.User;
import rs.raf.demo.model.VacuumCleaner;
import rs.raf.demo.model.enums.Status;
import rs.raf.demo.repositories.ScheduledOperationRepository;
import rs.raf.demo.repositories.VacuumRepository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@Transactional
public class ScheduledOperationService implements IService<ScheduledOperation, Long>{

    private ScheduledOperationRepository vacuumRepository;


    @Autowired
    public ScheduledOperationService(ScheduledOperationRepository vacuumRepository) {
        this.vacuumRepository = vacuumRepository;
    }

    @Override
    public <S extends ScheduledOperation> S save(S var1) {
        return vacuumRepository.save(var1);
    }

    @Override
    public Optional<ScheduledOperation> findById(Long var1) {
        return vacuumRepository.findById(var1);
    }

    @Override
    public List<ScheduledOperation> findAll() {
        return vacuumRepository.findAll();
    }

    @Override
    public ResponseEntity<?> deleteById(Long var1) {
        vacuumRepository.deleteById(var1);
        return null;
    }


}
