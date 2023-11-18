package com.fsb.pfe.entities;

import javax.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "courrierrecu")
public class Courrierrecu implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long idCourrier;

    @Column(name = "numinscri", nullable = true)
    private String numinscri;

    @Column(name = "datepub")
    @Transient
    @Temporal(TemporalType.DATE)
    private LocalDate datepub;

    @Column(name = "sujet", nullable = true)
    private String sujet;

    @Column(name = "docaccompa", nullable = true)
    private String docaccompa;

    @Column(name = "expediteur", nullable = true)
    private String expediteur;

    @Column(name = "destinataire", nullable = true)
    private String destinataire;

    @Column(name = "remarque", nullable = true)
    private String remarque;


    @Column(name="filePath")
    private String  filePath;

    @ToString.Exclude
    @ManyToMany(mappedBy = "courrierrecus")
    private Set<User> users = new LinkedHashSet<>();

}
