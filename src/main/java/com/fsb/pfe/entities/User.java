package com.fsb.pfe.entities;

import javax.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "cin", nullable = false)
    private Integer cin;

    @Column(name = "poste", nullable = false)
    private String poste;

    @Column(name = "numtel", nullable = false)
    private Integer numtel;

    @Column(name = "mail", nullable = false)
    private String mail;

    @Column
    private String name ;
    @Column (name="password", nullable =false)
    private String password;
    @Column(name ="is_sactive", columnDefinition = "tinyint(1) default 1")
    private boolean isActive;

    @Column
    private String code;
    @ManyToMany
    @JoinTable(name = "user_courrierexes",
            joinColumns = @JoinColumn(name = "user_cin"),
            inverseJoinColumns = @JoinColumn(name = "courrierexes_numCourrier"))
    private Set<Courrierex> courrierexes = new LinkedHashSet<>();

    @ManyToMany
    @JoinTable(name = "user_courrierrecus",
            joinColumns = @JoinColumn(name = "user_cin"),
            inverseJoinColumns = @JoinColumn(name = "courrierrecus_numinscri"))
    private Set<Courrierrecu> courrierrecus = new LinkedHashSet<>();

}
