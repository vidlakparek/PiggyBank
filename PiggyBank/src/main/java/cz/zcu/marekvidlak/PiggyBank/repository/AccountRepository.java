package cz.zcu.marekvidlak.PiggyBank.repository;

import cz.zcu.marekvidlak.PiggyBank.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
