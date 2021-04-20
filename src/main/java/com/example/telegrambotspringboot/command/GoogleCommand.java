package com.example.telegrambotspringboot.command;

import com.example.telegrambotspringboot.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class GoogleCommand implements Command{

    private final static String URL_MESSAGE = "Google our god >>>";
    private final static String URL = "https://www.google.com/";

    private final SendBotMessageService sendBotMessageService;

    public GoogleCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessageWithButton(update.getMessage().getChatId().toString(),
                URL_MESSAGE,URL);
    }
}
