
package com.mycompany.artbalear.Models;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author sergi
 */
public class Comment {
    private int id;
    private int user_id;
    private int site_id;
    private String text;
    private LocalDate date;
    private LocalTime hour;

    public Comment(int id, int user_id, int site_id, String text, LocalDate date, LocalTime hour) {
        this.id = id;
        this.user_id = user_id;
        this.site_id = site_id;
        this.text = text;
        this.date = date;
        this.hour = hour;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getSite_id() {
        return site_id;
    }

    public void setSite_id(int site_id) {
        this.site_id = site_id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getHour() {
        return hour;
    }

    public void setHour(LocalTime hour) {
        this.hour = hour;
    }

    @Override
    public String toString() {
        return "Comment{" + "id=" + id + ", user_id=" + user_id + ", site_id=" + site_id + ", text=" + text + ", date=" + date + ", hour=" + hour + '}';
    }
    
    
}
