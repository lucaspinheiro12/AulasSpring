package com.lucas.jogos.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucas.jogos.dto.GameListDTO;
import com.lucas.jogos.dto.GameMinDTO;
import com.lucas.jogos.services.GameListService;
import com.lucas.jogos.services.GameService;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {
    
    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping()
    public List<GameListDTO> findAll(){
        List<GameListDTO> result = gameListService.findAll();
        return result;
    }

    @GetMapping(value= "/{listId}/games")
    public List<GameMinDTO> findList(@PathVariable Long listId){
        List<GameMinDTO> result = gameService.findList(listId);
        return result;
    }

}