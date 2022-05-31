package cz.zcu.marekvidlak.PiggyBank.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "account", indexes = {})
public class Account {
    @Getter
    @ManyToOne(optional = false)
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;

    @Getter
    @Setter
    @Column(name = "balance", nullable = false)
    @NumberFormat(pattern = "#,###,###,###.##", style = NumberFormat.Style.CURRENCY)
    private @Positive BigDecimal balance;

    @Id
    @Getter
    @Column(name = "number", nullable = false, unique = true)
    private Long number;

    @Getter
    @Enumerated
    @Column(name = "account_type", nullable = false)
    private AccountType accountType;

    @Getter
    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "card_number", unique = true)
    private Card card;

    @Getter
    @OneToMany(mappedBy = "sender", orphanRemoval = true)
    private Set<Transaction> outgoing_transactions = new LinkedHashSet<>();

    @Getter
    @OneToMany(mappedBy = "recipient", orphanRemoval = true)
    private Set<Transaction> incoming_transactions = new LinkedHashSet<>();

}