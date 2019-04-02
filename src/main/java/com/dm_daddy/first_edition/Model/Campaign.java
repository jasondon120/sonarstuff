package com.dm_daddy.first_edition.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;


@Entity
@Getter
@Setter
@Table(name = "campaign")
public class Campaign implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column
    private Timestamp startDate;

    @Column
    private String title;

    @Lob
    private String description;

    @Column
    private String player;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "campaign")
    private List<Campaign> campaign;


}

