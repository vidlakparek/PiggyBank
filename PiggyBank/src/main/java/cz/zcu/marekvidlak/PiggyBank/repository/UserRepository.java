package cz.zcu.marekvidlak.PiggyBank.repository;

import cz.zcu.marekvidlak.PiggyBank.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {
}
