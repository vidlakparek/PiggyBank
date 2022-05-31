package cz.zcu.marekvidlak.PiggyBank.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "card")
public class Card {
    @OneToOne(optional = false, orphanRemoval = true)
    @JoinColumn(name = "account_number", nullable = false)
    private Account account;

    @Id
    @Getter
    @CreditCardNumber
    @Column(name = "number", nullable = false, unique = true)
    private Long number;

    @Size
    @Getter
    @OneToMany(mappedBy = "card", orphanRemoval = true)
    private Set<CardPayment> cardPayments = new LinkedHashSet<>();

}