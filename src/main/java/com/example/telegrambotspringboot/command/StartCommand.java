package com.example.telegrambotspringboot.command;

import com.example.telegrambotspringboot.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class StartCommand implements Command{

    private final static String START_MESSAGE = "Hello! My name is RandomBot, and i have some surprise for you." +
            "\ud83d\udc6f\n\n" +
            "Check it out, buddy!" +
            "\ud83d\udcb8\n";

    private final SendBotMessageService sendBotMessageService;

    public StartCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(),
                START_MESSAGE);
    }
}
