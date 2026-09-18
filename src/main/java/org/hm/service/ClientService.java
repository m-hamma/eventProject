package org.hm.service;

import jakarta.annotation.PostConstruct;
import org.hm.dto.ClientDto;
import org.hm.entities.ClientEntity;
import org.hm.mapper.ClientMapper;
import org.hm.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class ClientService {

    private final ClientRepository repository;
    private Map<Long, ClientEntity> clientsCache;
    private final ClientMapper clientMapper;

    public ClientService(
            ClientRepository repository,
            ClientMapper clientMapper) {
        this.repository = repository;
        this.clientMapper = clientMapper;
    }

    @PostConstruct
    public void init() {

        clientsCache = repository.findAll()
                .stream()
                .collect(Collectors.toMap(
                        ClientEntity::getId,
                        Function.identity()
                ));
    }

    public List<ClientDto> findAll() {
        return clientsCache.values()
                .stream()
                .map(clientMapper::toDto)
                .toList();
    }

    public ClientDto findById(Long id) {

        ClientEntity client = clientsCache.get(id);

        if (client == null) {
            throw new IllegalArgumentException(
                    "Client introuvable : " + id);
        }

        return clientMapper.toDto(client);
    }
}