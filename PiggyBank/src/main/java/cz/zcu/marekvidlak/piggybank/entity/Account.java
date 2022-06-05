package cz.zcu.marekvidlak.piggybank.entity;

import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

/**
 * It's a class that represents an account
 */
@Transactional
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "account")
public class Account implements Serializable {
    @ManyToOne(optional = false)
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;

    @Column(name = "balance", nullable = false)
    @NumberFormat(pattern = "#,###,###,###.##", style = NumberFormat.Style.CURRENCY)
    private @Positive BigDecimal balance;

    @Positive
    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "number", nullable = false, unique = true)
    private Long number;

    @ToString.Include
    @Enumerated
    @Column(name = "account_type", nullable = false)
    private AccountType accountType;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "card_number", unique = true, updatable = false)
    private Card card;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "sender", orphanRemoval = true)
    private Set<Transaction> outgoingTransactions = new LinkedHashSet<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "recipient", orphanRemoval = true)
    private Set<Transaction> incomingTransactions = new LinkedHashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Account account = (Account) o;
        return number != null && Objects.equals(number, account.number);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return accountType.toString();
    }

}