package com.dm_daddy.first_edition.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class PlayerCampaigns {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @ManyToOne
    @JoinColumn(name = "campaign", referencedColumnName = "ID")
    private Campaign campaign;

    @ManyToOne
    @JoinColumn(name = "playerCharacter", referencedColumnName = "ID")
    private PlayerCharacter playerCharacter;

    @Column
    private String dungeonMaster;

}
