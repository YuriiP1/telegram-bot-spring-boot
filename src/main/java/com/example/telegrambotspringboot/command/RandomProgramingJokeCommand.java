package com.example.telegrambotspringboot.command;

import com.example.telegrambotspringboot.model.Joke;
import com.example.telegrambotspringboot.service.SendBotMessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.telegram.telegrambots.meta.api.objects.Update;

public class RandomProgramingJokeCommand implements Command{

    private final SendBotMessageService sendBotMessageService;
    private RestTemplate restTemplate;

    public RandomProgramingJokeCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        restTemplate = new RestTemplate();
        String setup = "";
        String punchline = "";

        ResponseEntity<Joke[]> response = restTemplate.getForEntity("https://official-joke-api.appspot.com/jokes/programming/random",
                Joke[].class);
        Joke[] jokes = response.getBody();
        for(Joke j : jokes) {
            setup = j.getSetup();
            punchline = j.getPunchline();
        }
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(),
                        "<u>Setup: </u> \n" +"<b>" + setup + "</b>" +
                        "\n\n<u>Punchline: </u>\n" +"<b>" + punchline + "</b>");
    }
}
