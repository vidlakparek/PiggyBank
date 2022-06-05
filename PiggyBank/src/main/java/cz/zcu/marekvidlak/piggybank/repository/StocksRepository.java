package cz.zcu.marekvidlak.piggybank.repository;

import cz.zcu.marekvidlak.piggybank.entity.Stocks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// A repository for the Stocks entity.
@Repository
public interface StocksRepository extends JpaRepository<Stocks, Long> {
}
