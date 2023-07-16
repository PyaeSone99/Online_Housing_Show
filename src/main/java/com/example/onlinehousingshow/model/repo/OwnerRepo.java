package com.example.onlinehousingshow.model.repo;

import com.example.onlinehousingshow.model.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OwnerRepo extends JpaRepository<Owner,Integer> {

    Optional<Owner> findByOwnerUserName(String ownerUserName);
}
