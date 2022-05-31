package cz.zcu.marekvidlak.PiggyBank.repository;

import cz.zcu.marekvidlak.PiggyBank.entity.CardPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CardPaymentRepository extends JpaRepository<CardPayment, UUID> {
}