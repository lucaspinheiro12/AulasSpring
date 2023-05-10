package com.lucas.jogos.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.jogos.dto.GameMinDTO;
import com.lucas.jogos.intities.Game;
import com.lucas.jogos.repositories.GameRepository;

@Service
public class GameService {
    
    @Autowired
    GameRepository gameRepository;

    public List<GameMinDTO> findAll(){
       List <Game> result = gameRepository.findAll() ;
       List <GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
       return dto;
    }
}
