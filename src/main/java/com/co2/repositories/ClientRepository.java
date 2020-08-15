package com.co2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.co2.models.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
