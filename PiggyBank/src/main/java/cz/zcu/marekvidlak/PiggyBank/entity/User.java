package cz.zcu.marekvidlak.PiggyBank.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.sql.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotEmpty
    @Getter
    @Column(name = "name", nullable = false)
    private String name;

    @NotEmpty
    @Getter
    @Column(name = "surname", nullable = false)
    private String surname;

    @NotEmpty
    @Column(name = "password")
    private String password;

    @Getter
    @NotEmpty
    @Email
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Getter
    @Column(name = "birt_date", nullable = false)
    private Date birtDate;

    @Getter
    @Column(name = "phone_num", nullable = false, unique = true)
    private String phoneNum;

    @Getter
    @OneToMany(mappedBy = "owner", orphanRemoval = true)
    private Set<Account> accounts = new LinkedHashSet<>();



}