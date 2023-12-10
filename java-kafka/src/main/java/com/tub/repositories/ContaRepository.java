package com.tub.repositories;

import com.tub.models.Conta;
import org.springframework.data.repository.CrudRepository;

public interface ContaRepository extends CrudRepository<Conta, Integer> {
}
