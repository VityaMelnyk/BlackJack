package edu.blackjack.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document
public class Round {
    @Id
    private String id;
    private String userName;
    private List<Card> delivery;
    private List<Card> deliveryComp;
    private Boolean isWinner;
    private String score;
    private LocalDateTime start;
    private LocalDateTime finish;

    public Round() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Card> getDelivery() {
        return delivery;
    }

    public void setDelivery(List<Card> delivery) {
        this.delivery = delivery;
    }

    public List<Card> getDeliveryComp() {
        return deliveryComp;
    }

    public void setDeliveryComp(List<Card> deliveryComp) {
        this.deliveryComp = deliveryComp;
    }

    public Boolean getWinner() {
        return isWinner;
    }

    public void setWinner(Boolean winner) {
        isWinner = winner;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getFinish() {
        return finish;
    }

    public void setFinish(LocalDateTime finish) {
        this.finish = finish;
    }

    @Override
    public String toString() {
        return "Round{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", delivery=" + delivery +
                ", deliveryComp=" + deliveryComp +
                ", isWinner=" + isWinner +
                ", score='" + score + '\'' +
                ", start=" + start +
                ", finish=" + finish +
                '}';
    }
}
