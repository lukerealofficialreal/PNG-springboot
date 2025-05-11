package com.game.PNG;

import jakarta.persistence.*;
import org.springframework.hateoas.RepresentationModel;

import java.util.ArrayList;
import java.util.List;

@Entity
public class AccountHolder extends RepresentationModel<AccountHolder> {

    @Id
    //@GeneratedValue(strategy= GenerationType.AUTO) //Use github's generated Id instead
    private Integer uid;                        //User has an ID
    protected String name = "DEFAULT_NAME";   //The name of the user (situationally optional)

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private List<Game> games = new ArrayList<>();

    public AccountHolder() {}


    public AccountHolder(String name, Integer uid) {
        this.name = name;
        this.uid = uid;
    }

    //Getters
    public Integer getUid() {return uid;}
    public String getName() {return name;}

    public boolean userHasGame(Game game) {
        return games.contains(game);
    }

    //Setters
    public void setName(String name)
    {
        this.name = name;
    }
    public void setUid(Integer uid) {
        this.uid = uid;
    }
    public void putGame(Game game) {
        this.games.add(game);
    }

}
