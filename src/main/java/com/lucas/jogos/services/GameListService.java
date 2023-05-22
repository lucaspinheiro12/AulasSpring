package com.lucas.jogos.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lucas.jogos.dto.GameListDTO;
import com.lucas.jogos.entities.GameList;
import com.lucas.jogos.projection.GameMinProjection;
import com.lucas.jogos.repositories.GameListRepository;
import com.lucas.jogos.repositories.GameRepository;

@Service
public class GameListService {
    
    @Autowired
    GameListRepository gameListRepository;

    @Autowired
    GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
       List <GameList> result = gameListRepository.findAll() ;
       List<GameListDTO> dto = result.stream().map(x -> new GameListDTO(x)).toList();
       return dto;
    }

    @Transactional
    public void move (Long listId, int sourceIndex, int destinationIndex){
        List <GameMinProjection> list = gameRepository.searchByList(listId) ;
        GameMinProjection obj =  list.remove(sourceIndex);
        list.add(destinationIndex, obj);
        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex > destinationIndex ? destinationIndex : sourceIndex;

        for(int i = min ; i <= max ; i++ ){
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    } 

}
