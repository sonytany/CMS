package com.contract.management.system.repository;

import com.contract.management.system.model.entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<Contract, Integer>
{}
