package com.game.PNG;


import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountHolderRepository extends
CrudRepository<AccountHolder, Long>{

    AccountHolder findByUid(long uid);

    //List<AccountHolder> getAll();

    //Game findGameByGid();


}
