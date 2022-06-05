package cz.zcu.marekvidlak.piggybank.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.util.Objects;
import java.util.UUID;

/**
 * It represents a payment made with a card
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "card_pyment")
public class CardPayment implements Serializable {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Getter
    @ManyToOne(optional = false)
    @JoinColumn(name = "card_number", nullable = false)
    private Card card;

    @Getter
    @Column(name = "amount", nullable = false)
    @NumberFormat(pattern = "#,###,###,###.##", style = NumberFormat.Style.CURRENCY)
    private @Positive BigDecimal amount;

    @Getter
    @Column(name = "merchant")
    private String merchant;

    @Getter
    @Column(name = "date", nullable = false)
    private Date date;

    @Getter
    @Column(name = "time", nullable = false)
    private Time time;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CardPayment that = (CardPayment) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}