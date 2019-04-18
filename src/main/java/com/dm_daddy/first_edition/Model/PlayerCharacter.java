package com.dm_daddy.first_edition.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
public class PlayerCharacter implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    @ManyToOne
    @JoinColumn(name = "campId", referencedColumnName = "ID")
    private Campaign campId;

    @ManyToOne
    @JoinColumn(name = "creatorId", referencedColumnName = "ID")
    private User creatorId;


    @Column
    private String characterNm;

    @ManyToOne
    @JoinColumn(name = "raceId", referencedColumnName = "ID")
    private Race raceId;

    @ManyToOne
    @JoinColumn(name = "classId", referencedColumnName = "ID")
    private RefCode classId;

    @ManyToOne
    @JoinColumn(name = "backgroundId", referencedColumnName = "ID")
    private Backgrounds backgroundId;

    @ManyToOne
    @JoinColumn(name = "alignment", referencedColumnName = "ID")
    private RefCode alignmentId;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "playerCharacter")
    @JsonIgnore
    private List<PlayerCampaigns> playerCampaigns;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "playerCharacter")
    private List<SkillBonus> skillBonus;

    @Column
    private Long level;

    @Column
    private Long ac;

    @Column
    private Long hp;

    @Column
    private Long passivePerception;

    @Column
    private String inspiration;

    @Lob
    private String backstory;

    @Column
    private Long initiative;

    @Column
    private Long speed;

    @Column
    private Long proficienyBonus;

    @Column
    private Long strength;

    @Column
    private Long dexterity;

    @Column
    private Long constitution;

    @Column
    private Long intelligence;

    @Column
    private Long wisdom;

    @Column
    private Long charisma;

    @Column
    private Long strengthBonus;

    @Column
    private Long dexterityBonus;

    @Column
    private Long constitutionBonus;

    @Column
    private Long intelligenceBonus;

    @Column
    private Long wisdomBonus;

    @Column
    private Long charismaBonus;

    @Column
    private Long acrobaticsBonus;

    @Column
    private Long animalHandlinBonus;

    @Column
    private Long arcanaBonus;

    @Column
    private Long athleticsBonus;

    @Column
    private Long deceptionBonus;

    @Column
    private Long historyBonus;

    @Column
    private Long insightBonus;

    @Column
    private Long intimidationBonus;

    @Column
    private Long investigationBonus;

    @Column
    private Long medicineBonus;

    @Column
    private Long natureBonus;

    @Column
    private Long perceptionBonus;

    @Column
    private Long performanceBonus;

    @Column
    private Long persuasionBonus;

    @Column
    private Long religionBonus;

    @Column
    private Long sleightOfHandBonus;

    @Column
    private Long stealthBonus;

    @Column
    private Long survivalBonus;










}
