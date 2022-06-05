package cz.zcu.marekvidlak.piggybank.repository;

import cz.zcu.marekvidlak.piggybank.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// A repository for the Stock entity.
@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
}
