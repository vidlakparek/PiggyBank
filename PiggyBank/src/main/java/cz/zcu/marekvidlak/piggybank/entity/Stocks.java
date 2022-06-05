package cz.zcu.marekvidlak.piggybank.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;


/**
 * It's a class that represents a row in the stocks_list table
 */
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "stocks_list")
@Entity
public class Stocks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "value", nullable = false)
    private Double value;

}
