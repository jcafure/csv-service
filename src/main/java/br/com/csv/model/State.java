package br.com.csv.model;


import java.io.Serializable;


public class State implements Serializable {

    private String state;
    private Long number;

    public State() {
    }

    public State(String state, Long number) {
        this.state = state;
        this.number = number;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

}
