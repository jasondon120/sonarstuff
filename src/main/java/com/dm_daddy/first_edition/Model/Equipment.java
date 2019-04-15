package com.dm_daddy.first_edition.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column
    private String name;

    @Column
    private Long weight;

    @Column
    private Long cost;

    @Column
    private String type;

    @ManyToOne
    @JoinColumn(name = "weightType", referencedColumnName = "ID")
    private RefCode weightType;

    @ManyToOne
    @JoinColumn(name = "costType", referencedColumnName = "ID")
    private RefCode costType;

    @Column
    private String attribute;

    @Lob
    private String notes;

    @Lob
    private String description;
}
