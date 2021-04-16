package com.example.telegrambotspringboot.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Joke {
    private String setup;
    private String punchline;

    public Joke() {

    }

    public String getSetup() {
        if(setup.isBlank()) {
            return "<none>";
        } else {
            return setup;
        }
    }

    public String getPunchline() {
        if(punchline.isBlank()) {
            return "<none>";
        } else {
            return punchline;
        }
    }
}
