package cz.zcu.marekvidlak.piggybank.repository;

import cz.zcu.marekvidlak.piggybank.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// A repository for Card entity.
@Repository
public interface CardRepository extends JpaRepository<Card, String> {
}
