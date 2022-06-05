package cz.zcu.marekvidlak.piggybank.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;
import java.util.UUID;

/**
 * It's a class that represents a transaction between two accounts
 */
@Entity
@Getter
@Setter
@ToString
@Table(name = "transaction")
public class Transaction implements Serializable {
    @Getter
    @ManyToOne(optional = false)
    @JoinColumn(name = "sender_ID", nullable = false)
    private Account sender;

    @Getter
    @ManyToOne(optional = false)
    @JoinColumn(name = "recipient_ID", nullable = false)
    private Account recipient;

    @Getter
    @Column(name = "amount", nullable = false)
    @NumberFormat(pattern = "#,###,###,###.##", style = NumberFormat.Style.CURRENCY)
    private @Positive BigDecimal amount;

    @Getter
    @Column(name = "execution_date", nullable = false)
    private Date executionDate;

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Transaction that = (Transaction) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}