package com.example.telegrambotspringboot.command;

import com.example.telegrambotspringboot.model.Joke;
import com.example.telegrambotspringboot.service.SendBotMessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.telegram.telegrambots.meta.api.objects.Update;

public class RandomJokeCommand implements Command {

    private final SendBotMessageService sendBotMessageService;
    private RestTemplate restTemplate;

    public RandomJokeCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        restTemplate = new RestTemplate();

        Joke joke = restTemplate.getForObject("https://official-joke-api.appspot.com/random_joke",Joke.class);
        String setup = joke.getSetup();
        String punchline = joke.getPunchline();

        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(),
                        "<u>Setup: </u> \n" +"<b>" + setup + "</b>" +
                        "\n\n<u>Punchline: </u>\n" +"<b>" + punchline + "</b>");
    }
}
