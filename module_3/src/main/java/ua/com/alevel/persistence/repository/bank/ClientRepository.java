package ua.com.alevel.persistence.repository.bank;

import org.springframework.stereotype.Repository;

import ua.com.alevel.persistence.entity.bank.Client;
import ua.com.alevel.persistence.repository.BaseRepository;

@Repository("uniqueClientRepository")
public interface ClientRepository extends BaseRepository<Client> {
}
