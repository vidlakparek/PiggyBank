package cz.zcu.marekvidlak.PiggyBank.repository;

import cz.zcu.marekvidlak.PiggyBank.entity.Stocks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StocksRepository extends JpaRepository<Stocks, Long> {
}
