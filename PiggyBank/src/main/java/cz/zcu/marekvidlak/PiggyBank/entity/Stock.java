package cz.zcu.marekvidlak.PiggyBank.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Entity
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

}