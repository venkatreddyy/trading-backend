package com.venkat.repository;

import com.venkat.model.Coin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CoinRepository extends JpaRepository<Coin,Long> {
    Optional<Coin> findById(String id);
    // Custom query method example
    @Query("SELECT c FROM Coin c WHERE c.id = :id")
    Optional<Coin> findCoinByCustomId(@Param("id") String id);
}
