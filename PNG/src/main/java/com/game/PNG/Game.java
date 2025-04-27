package com.game.PNG;

import jakarta.persistence.*;

@Entity
public class Game {

    public static final Integer MAX_NUM = 10000;    //default 10000
    public static final Integer MIN_NUM = 0; //default 0

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long gid;
    private Integer goalnum = null;
    private boolean victory = false;
    private Integer lastguess = null;


    @ManyToOne
    private AccountHolder owner;

    protected Game() {}

    public Game(Integer goalnum) {
        this.goalnum = goalnum;
    }

    public Game(int goalnum, Long gid, Integer lastguess, boolean victory, AccountHolder user)
    {
        this.goalnum = goalnum;
        this.gid = gid;
        this.lastguess = lastguess;
        this.victory = victory;
        this.owner = user;
    }

    public Long getGid() {
        return gid;
    }
    public void setGid(long gid) {
        this.gid = gid;
    }

    public Integer getGoalnum() {
        return goalnum;
    }

    public void setGoalnum(Integer goalnum) {
        this.goalnum = goalnum;
    }

    public boolean getVictory() {
        return victory;
    }
    public void setVictory(boolean victory) {
        this.victory = victory;
    }

    public Integer getLastguess() {
        return lastguess;
    }
    public void setLastguess(Integer lastguess) {
        this.lastguess = lastguess;
    }

    public AccountHolder getOwner() {
        return owner;
    }

    public void setOwner(AccountHolder owner) {
        this.owner = owner;
    }

    public Game copy()
    {
        return new Game(goalnum, gid, lastguess, victory, owner);
    }

    @Override
    public String toString() {
        Long uid;
        if(owner == null)
            uid = null;
        else
            uid = owner.getUid();
        return String.format(
                "Game[gid='%d', goalnum='%d', victory='%s', lastguess='%d', uid='%d']",
                gid, goalnum, Boolean.toString(victory), lastguess, uid);
    }

}
