package com.example.telegrambotspringboot.command;

import com.example.telegrambotspringboot.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.example.telegrambotspringboot.command.CommandName.*;

public class HelpCommand implements Command{

    private final static String HELP_MESSAGE = String.format("<b>Available commands: </b>\n\n" +
            "%s - start working with me\n" +
            "%s - stop working with me\n\n" +
            "%s - get help with existing commands\n\n" +
            "%s - some random general joke\n" +
            "%s - some random programming joke\n\n" +
                    "%s - get google url\n",
            START.getCommandName(),
            STOP.getCommandName(),
            HELP.getCommandName(),
            RANDOMPROGRAMMINGJOKE.getCommandName(),
            RANDOMJOKE.getCommandName(),
            GOOGLE.getCommandName());

    private final SendBotMessageService sendBotMessageService;

    public HelpCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(),
                HELP_MESSAGE);
    }
}
