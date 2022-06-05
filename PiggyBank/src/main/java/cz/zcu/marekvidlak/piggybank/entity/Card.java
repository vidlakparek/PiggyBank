package cz.zcu.marekvidlak.piggybank.entity;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

/**
 * It's a class that represents a card, and it has a number, an account, and a set of card payments
 */
@Transactional
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "card")
public class Card implements Serializable {
    @OneToOne(optional = false, orphanRemoval = true)
    @JoinColumn(name = "account_number", nullable = false)
    private Account account;

    @CreditCardNumber
    @Column(name = "number", nullable = false, unique = true)
    private Long number;

    @Size
    @Getter
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "card", orphanRemoval = true)
    private Set<CardPayment> cardPayments = new LinkedHashSet<>();

    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Card card = (Card) o;
        return number != null && Objects.equals(number, card.number);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    public CensoredCard getCensored() {
        return new CensoredCard(("XXXX XXXX XXXX " + number % 10000), account.toString());
    }
}