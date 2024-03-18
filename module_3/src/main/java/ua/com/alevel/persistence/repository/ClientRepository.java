package ua.com.alevel.persistence.repository;

import org.springframework.stereotype.Repository;

import ua.com.alevel.persistence.entity.Client;
import ua.com.alevel.persistence.repository.BaseRepository;

@Repository
public interface ClientRepository extends BaseRepository<Client> { }
