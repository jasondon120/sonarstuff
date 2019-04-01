package com.dm_daddy.first_edition.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "homebrew_items")
@Getter
@Setter
public class HomebrewItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column
    private String name;

    @Column
    private String creator;


    @ManyToOne
    @JoinColumn(name = "type", referencedColumnName = "ID")
    private RefCode type;

    @ManyToOne
    @JoinColumn(name = "rarity", referencedColumnName = "ID")
    private RefCode rarity;

    @Lob
    private String description;

    @Lob
    private String notes;

    @ManyToOne
    @JoinColumn(name = "attunement", referencedColumnName = "ID")
    private RefCode attunement;

    @ManyToOne
    @JoinColumn(name = "armorType", referencedColumnName = "ID")
    private RefCode armorType;

    @ManyToOne
    @JoinColumn(name = "weaponType", referencedColumnName = "ID")
    private RefCode weaponType;

}
