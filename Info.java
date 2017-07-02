package com.example.goople4;

public class Info {
    private int id;
    private String meeting;

    public Info(int id, String meeting, String time) {
        this.id = id;
        this.meeting = meeting;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getMeeting() {
        return meeting;
    }
    public void setMeeting(String meeting) {
        this.meeting = meeting;
    }
    public String toString() {
        return String.format("[%s]", meeting);
    }
}
