package ua.com.alevel.persistence.repository;

import org.springframework.data.repository.NoRepositoryBean;

import ua.com.alevel.persistence.entity.Operation;
import ua.com.alevel.persistence.repository.BaseRepository;

@NoRepositoryBean
public interface OperationRepository extends BaseRepository<Operation> { }