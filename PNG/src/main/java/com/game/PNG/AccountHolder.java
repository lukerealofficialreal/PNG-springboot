package com.game.PNG;

import jakarta.persistence.*;
import org.springframework.hateoas.RepresentationModel;

import java.util.ArrayList;
import java.util.List;

@Entity
public class AccountHolder extends RepresentationModel<AccountHolder> {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long uid;                        //User has an ID
    protected String name = "DEFAULT_NAME";   //The name of the user (situationally optional)

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private List<Game> games = new ArrayList<>();

    public AccountHolder() {}


    public AccountHolder(String name) {
        this.name = name;
    }

    //Getters
    public Long getUid() {return uid;}
    public String getName() {return name;}

    public boolean userHasGame(Game game) {
        return games.contains(game);
    }

    //Setters
    public void setName(String name)
    {
        this.name = name;
    }
    public void setUid(long uid) {
        this.uid = uid;
    }
    public void putGame(Game game) {
        this.games.add(game);
    }

}
