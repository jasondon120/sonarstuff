package com.dm_daddy.first_edition.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
public class PendingCampaign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column
    private Timestamp requestDate;

    @Column
    private String dungeonMaster;

    @Column
    private String player;

    @ManyToOne
    @JoinColumn(name = "campaign", referencedColumnName = "ID")
    private Campaign campaign;

}
