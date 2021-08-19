package edu.blackjack.service.round;

import edu.blackjack.model.Round;
import edu.blackjack.repository.RoundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RoundService {
    @Autowired
    RoundRepository repository;
    public static Round initRound() {
        Round round = new Round();
        round.setUserName("Alex");
        round.setStart(LocalDateTime.now());
        return round;
    }

    public Round create(Round round){

        System.out.println(round);
        return repository.save(round);
    }

    public List<Round> getAll() {
        return  repository.findAll();
    }

    public Round get(String id) {
        return repository.findById(id).get();
    }
}
