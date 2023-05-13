package com.lucas.jogos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucas.jogos.entities.Game;

public interface GameRepository extends JpaRepository <Game, Long>{
    
}
