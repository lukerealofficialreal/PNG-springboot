package com.game.PNG;


import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends
CrudRepository<Game, Long>{

    Game findByGid(long gid);
}
