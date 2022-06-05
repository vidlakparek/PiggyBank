package cz.zcu.marekvidlak.piggybank.entity;

import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

/**
 * A Stock is a representation of a certain amount of a certain stock owned by a certain account
 */
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@ToString
@Table(name = "stock")
public class Stock {

    @Getter
    @ManyToOne(optional = false)
    @JoinColumn(name = "owner_ID", nullable = false, insertable = false, updatable = false)
    private Account owner;

    @Positive
    @Getter
    @Column(name = "amount", nullable = false, insertable = false)
    @NumberFormat(pattern = "000000.000")
    private BigDecimal amount;


    @Getter
    @Id
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Getter
    @ManyToOne(optional = false)
    @JoinColumn(name = "stocks_id", nullable = false)
    private Stocks stocks;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Stock stock = (Stock) o;
        return id != null && Objects.equals(id, stock.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}