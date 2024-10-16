package com.ssafy.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("audience")
public class Audience {

    private Movie movie;

    @Autowired
    public Audience(@Qualifier("action")Movie movie) {
        this.movie = movie;
    }

    public void watchMovie() {
        System.out.println(movie.getInfo());
    }
}