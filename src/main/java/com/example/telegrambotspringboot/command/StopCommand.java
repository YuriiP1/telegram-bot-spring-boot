package com.example.telegrambotspringboot.command;

import com.example.telegrambotspringboot.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class StopCommand implements Command{

    private final static String STOP_MESSAGE = "NOOoooo, don't leave me. \ud83d\ude22";

    private final SendBotMessageService sendBotMessageService;

    public StopCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(),
                STOP_MESSAGE);
    }
}
