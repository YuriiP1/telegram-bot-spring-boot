package com.example.telegrambotspringboot.command;

import com.example.telegrambotspringboot.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class UnknownCommand implements Command{

    private final static String UNKNOWN_MESSAGE="Oops...If you don't know how to use this bot, type /help.\n\n" +
            "GoGoGoGoGo\u26f7";

    private final SendBotMessageService sendBotMessageService;

    public UnknownCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(),
                UNKNOWN_MESSAGE);
    }
}
