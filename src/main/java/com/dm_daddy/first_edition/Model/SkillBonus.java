package com.dm_daddy.first_edition.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
public class SkillBonus implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    @ManyToOne
    @JoinColumn(name = "playerCharacter", referencedColumnName = "ID")
    private PlayerCharacter playerCharacter;

    @ManyToOne
    @JoinColumn(name = "profSkill", referencedColumnName = "ID")
    private RefCode profSkill;

    @JsonIgnore
    public PlayerCharacter getPlayerCharacter() {
        return playerCharacter;
    }

    public Long getPlayerCharacter_Id(){
        return playerCharacter.getId();
    }

    public void setPlayerCharacter(PlayerCharacter playerCharacter) {
        this.playerCharacter = playerCharacter;
    }
}
