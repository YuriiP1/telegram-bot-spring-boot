package com.example.telegrambotspringboot.command;

import com.example.telegrambotspringboot.service.SendBotMessageService;
import com.google.common.collect.ImmutableMap;

import static com.example.telegrambotspringboot.command.CommandName.*;

public class CommandContainer {
    private final ImmutableMap<String, Command> commandMap;

    public CommandContainer(SendBotMessageService sendBotMessageService) {
        commandMap = ImmutableMap.<String, Command>builder()
                .put(START.getCommandName(), new StartCommand(sendBotMessageService))
                .put(STOP.getCommandName(), new StopCommand(sendBotMessageService))
                .put(HELP.getCommandName(), new HelpCommand(sendBotMessageService))
                .build();
    }

    public Command retrieveCommand(String commandIdentifier) {
        return commandMap.get(commandIdentifier);
    }
}
