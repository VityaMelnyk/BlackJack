package edu.blackjack.model;

import java.time.LocalDateTime;
import java.util.List;

public class Game {
    private List<Round> rounds;
    private String absoluteWinner;
    private String totalScore;
    private LocalDateTime start;
    private LocalDateTime finish;
}
