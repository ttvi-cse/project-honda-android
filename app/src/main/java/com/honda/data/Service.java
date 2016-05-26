package com.honda.data;

/**
 * Created by John on 4/20/2016.
 */
public class Service {
    private String title;
    private String lastFinish;
    private String timeRemaining;
    private String dueMileage;
    private String curMileage;

    public Service() {
    }

    public Service(String title, String lastFinish, String timeRemaining, String dueMileage) {
        this.title = title;
        this.lastFinish = lastFinish;
        this.timeRemaining = timeRemaining;
        this.dueMileage = dueMileage;
    }

    public Service(String title, String lastFinish, String timeRemaining, String dueMileage, String curMileage) {
        this.title = title;
        this.lastFinish = lastFinish;
        this.timeRemaining = timeRemaining;
        this.dueMileage = dueMileage;
        this.curMileage = curMileage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLastFinish() {
        return lastFinish;
    }

    public void setLastFinish(String lastFinish) {
        this.lastFinish = lastFinish;
    }

    public String getTimeRemaining() {
        return timeRemaining;
    }

    public void setTimeRemaining(String timeRemaining) {
        this.timeRemaining = timeRemaining;
    }

    public String getDueMileage() {
        return dueMileage;
    }

    public void setDueMileage(String dueMileage) {
        this.dueMileage = dueMileage;
    }

    public String getCurMileage() {
        return curMileage;
    }

    public void setCurMileage(String curMileage) {
        this.curMileage = curMileage;
    }
}
