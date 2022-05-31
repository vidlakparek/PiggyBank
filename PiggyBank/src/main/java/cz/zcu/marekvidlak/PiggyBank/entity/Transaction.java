package cz.zcu.marekvidlak.PiggyBank.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.UUID;

@Entity
@EqualsAndHashCode
@Table(name = "transaction")
public class Transaction {
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

}