package com.example.exercise;

public class Tramvai {

    private String number;
    private String hour;
    private String positions;
    private String taken_positions;

    public Tramvai (String number, String hour, String positions, String taken_positions) {
        number=this.number;
        hour = this.hour;
        positions = this.positions;
        taken_positions = this.taken_positions;
    }

    public String getNumber() {
        return number;
    }

    public String getHour() {
        return hour;
    }

    public String getPositions() {
        return positions;
    }

    public String getTaken_positions() {
        return taken_positions;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public void setPositions(String positions) {
        this.positions = positions;
    }

    public void setTaken_positions(String taken_positions) {
        this.taken_positions = taken_positions;
    }
}
