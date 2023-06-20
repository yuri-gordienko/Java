package ua.com.alevel.persistence.repository;

import org.springframework.data.repository.NoRepositoryBean;
import ua.com.alevel.persistence.entity.Operation;

@NoRepositoryBean
public interface OperationRepository extends BaseRepository<Operation> {
}