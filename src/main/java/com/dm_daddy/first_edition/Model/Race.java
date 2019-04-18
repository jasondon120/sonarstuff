package com.dm_daddy.first_edition.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Race {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column
    private String name;

    @Column
    private Long strength;

    @Column
    private Long charisma;

    @Column
    private Long constitution;

    @Column
    private Long dexterity;

    @Column
    private Long wisdom;

    @Column
    private Long intelligence;

    @Column
    private Long speed;

    @Column
    private Long darkVision;

    @Lob
    private String bio;

    @Lob
    private String racialTrait;



}
