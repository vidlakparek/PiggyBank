package cz.zcu.marekvidlak.piggybank.entity;

// An enum type.
public enum AccountType {
    STANDARD, SAVING, STOCK;

    @Override
    public String toString() {
        return this.name() + " Account";
    }
}
