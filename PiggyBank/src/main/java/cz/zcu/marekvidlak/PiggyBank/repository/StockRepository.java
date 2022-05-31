package cz.zcu.marekvidlak.PiggyBank.repository;

import cz.zcu.marekvidlak.PiggyBank.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
}
