package cz.zcu.marekvidlak.PiggyBank.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "card_pyment")
public class CardPayment {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

}