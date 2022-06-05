package cz.zcu.marekvidlak.piggybank.entity;

import lombok.Data;

/**
 * CensoredCard is a class that has two fields, num and owner, and a constructor that initializes those fields.
 */
@Data
public class CensoredCard {
    private String num;
    private String owner;

    public CensoredCard(String num, String owner) {
        this.num = num;
        this.owner = owner;
    }
}
