package com.lucas.jogos.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lucas.jogos.dto.GameListDTO;
import com.lucas.jogos.entities.GameList;
import com.lucas.jogos.repositories.GameListRepository;

@Service
public class GameListService {
    
    @Autowired
    GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
       List <GameList> result = gameListRepository.findAll() ;
       List<GameListDTO> dto = result.stream().map(x -> new GameListDTO(x)).toList();
       return dto;
    }

}
