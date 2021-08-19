package edu.blackjack.controller.web;

import edu.blackjack.model.BlackJackService;
import edu.blackjack.model.Card;
import edu.blackjack.model.Round;
import edu.blackjack.service.round.RoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/web/cards")
public class BjWebController {
 @Autowired
    BlackJackService service;
 @Autowired
    RoundService roundService;
    Round round;

    @RequestMapping("/game")
    public String showTable(Model model){
        List<Card> delivery = new ArrayList<>();
        service.playNext();
        int counterPlayer = service.counterPlayer;
        int counterPC = service.counterPC;
        round = roundService.initRound();
        String score = "" + counterPlayer + ":" + counterPC;
        int roundCounter = service.roundCounter;
        model.addAttribute("roundCounter", roundCounter);
        model.addAttribute("score", score);
        model.addAttribute("delivery", delivery);
        return "gametable";
    }
    @RequestMapping("/refresh")
    public String refresh(Model model) {
        List<Card> delivery = new ArrayList<>();
        List<Card> deck = service.getNewDeck();
        service.init();
        service.newGame();
        int counterPlayer = service.counterPlayer;
        int counterPC = service.counterPC;

        String score = "" + counterPlayer + ":" + counterPC;
        int roundCounter = service.roundCounter;
        model.addAttribute("roundCounter", roundCounter);
        model.addAttribute("score", score);
        model.addAttribute("deck", deck);
        model.addAttribute("delivery", delivery);
        return "gametable";
    }
    @RequestMapping("/deck")
    public String showDeck(Model model){
        List<Card> deck = service.getDeck();
        model.addAttribute("deck", deck);
        return "deck";
    }
    @RequestMapping("/pick")
    public String pick(Model model){
        round = RoundService.initRound();
        List<Card> delivery = service.getCardList();
        int sum = delivery.stream().mapToInt(card -> card.getValue()).sum();

        String massage = "";
        if (sum == 21){
            massage = "Winner";
        }if(sum > 21){
            massage = "Perebor";
        }if (sum < 21){
            massage = "WE";
        }
        if (sum >= 21){
            return "redirect:/web/cards/stop";
        }
        int getDeckSize = service.getDeckSize();
        int roundCounter = service.roundCounter;

        model.addAttribute("roundCounter", roundCounter);
        model.addAttribute("getDeckSize", getDeckSize);
        model.addAttribute("massage", massage);
        model.addAttribute("sum", sum);
        model.addAttribute("delivery", delivery);
        return "deck";
    }
    @RequestMapping("/stop")
    public String stop(Model model){
        List<Card> delivery = service.getDelivery();
        int sum = delivery.stream().mapToInt(Card::getValue).sum();
        List<Card> forComp = service.getDeliveryForComp();
        int sum1 = forComp.stream().mapToInt(Card::getValue).sum();

        String massageUlt = service.getWinner(sum, sum1);
        int getDeckSize = service.getDeckSize();
        int counterPlayer = service.counterPlayer;
        int counterPC = service.counterPC;
        String score = "" + counterPlayer + ":" + counterPC;
        int roundCounter = service.roundCounter;
        System.out.println(delivery);
        /*round.setDeliveryComp(forComp);*/
        round.setFinish(LocalDateTime.now());
        if (massageUlt.equals("You are Winner"))
        round.setWinner(true);
        if (massageUlt.equals("You are Loser"))
        round.setWinner(false);
        round.setScore(score);
        round.setDelivery(delivery);
        round.setDeliveryComp(forComp);

        roundService.create(round);
        model.addAttribute("roundCounter", roundCounter);
        model.addAttribute("score", score);
        model.addAttribute("getDeckSize", getDeckSize);
        model.addAttribute("massageUlt", massageUlt);
        model.addAttribute("sum", sum);
        model.addAttribute("sum1", sum1);
        model.addAttribute("delivery", delivery);
        model.addAttribute("forComp", forComp);
        return "finaldeck";
    }
    @RequestMapping("/history")
    public String showHistory(Model model){
        List<Round> rounds = roundService.getAll();
        model.addAttribute("rounds", rounds);
        return "history";
    }
    @RequestMapping("/history/{id}")
    public String showRounds(@PathVariable String id, Model model){
        Round round = roundService.get(id);
        List<Card> delivery = round.getDelivery();
        model.addAttribute("delivery", delivery);
        System.out.println(delivery.size());
        model.addAttribute("round", round);
        return "round";
    }
}
