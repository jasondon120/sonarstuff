package com.dm_daddy.first_edition.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class RacialFeatures {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @ManyToOne
    @JoinColumn(name ="race", referencedColumnName = "ID")
    private Race race;

    @ManyToOne
    @JoinColumn(name = "feature", referencedColumnName = "ID")
    private RefCode feature;
}
