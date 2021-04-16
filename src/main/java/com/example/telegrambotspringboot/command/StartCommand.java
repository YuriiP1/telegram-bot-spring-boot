package com.example.telegrambotspringboot.command;

import com.example.telegrambotspringboot.model.Joke;
import com.example.telegrambotspringboot.service.SendBotMarkupService;
import com.example.telegrambotspringboot.service.SendBotMessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class StartCommand implements Command{

    private RestTemplate restTemplate;

    private final static String START_MESSAGE = "Hello! My name is RandomBot, and i have some surprise for you." +
            "\ud83d\udc6f\n\n" +
            "Check it out, buddy!" +
            "\ud83d\udcb8\n";


    private final SendBotMarkupService sendBotMarkupService;

    public StartCommand(SendBotMarkupService sendBotMarkupService) {
        this.sendBotMarkupService = sendBotMarkupService;
    }

    @Override
    public void execute(Update update) {

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRowList = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        row.add("/randomjoke");
        row.add("/randomprogrammingjoke");
        keyboardRowList.add(row);

        replyKeyboardMarkup.setKeyboard(keyboardRowList);
        sendBotMarkupService.sendMarkup(update.getMessage().getChatId().toString(),
                START_MESSAGE,
                replyKeyboardMarkup);
    }

}
