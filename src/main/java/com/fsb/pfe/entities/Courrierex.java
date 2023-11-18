package com.fsb.pfe.entities;

import javax.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "courrierex")
public class Courrierex implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "numCourrier", nullable = false)
    private Integer numCourrier;

    @Column(name = "datelivraison")
    private LocalDate datelivraison;

    @Column(name = "sujet", nullable = false)
    private String sujet;

    @Column(name = "destinataire", nullable = false)
    private String destinataire;

    @Column(name = "docaccompa", nullable = false)
    private String docaccompa;

    @Column(name = "refUser", nullable = false)
    private Integer refUser;

    @ManyToMany(mappedBy = "courrierexes")
        private List<User> users ;

}
