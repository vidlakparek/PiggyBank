package cz.zcu.marekvidlak.piggybank.repository;

import cz.zcu.marekvidlak.piggybank.entity.CardPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

// A Spring Data JPA repository. It is a Spring Data interface that provides CRUD operations for the entity class that is
// being managed.
@Repository
public interface CardPaymentRepository extends JpaRepository<CardPayment, UUID> {
}