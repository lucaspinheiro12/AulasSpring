package com.lucas.jogos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lucas.jogos.entities.GameList;

public interface GameListRepository extends JpaRepository < GameList, Long >{

}
