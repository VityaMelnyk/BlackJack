package edu.blackjack.controller.rest;

import edu.blackjack.model.BlackJackService;
import edu.blackjack.model.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cards")
public class BjRestController {

    @Autowired
    BlackJackService service;

    @RequestMapping("/pick")
    public Card pickCard(){
        return service.pickFirstCardFromShuffleDeck();
    }


}
