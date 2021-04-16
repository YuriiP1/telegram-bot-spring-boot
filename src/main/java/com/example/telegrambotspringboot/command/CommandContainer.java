package com.example.telegrambotspringboot.command;

import com.example.telegrambotspringboot.service.SendBotMarkupService;
import com.example.telegrambotspringboot.service.SendBotMessageService;
import com.google.common.collect.ImmutableMap;

import static com.example.telegrambotspringboot.command.CommandName.*;

public class CommandContainer {
    private final ImmutableMap<String, Command> commandMap;
    private final Command defaultCommand;

    public CommandContainer(SendBotMessageService sendBotMessageService, SendBotMarkupService sendBotMarkupService) {
        commandMap = ImmutableMap.<String, Command>builder()
                .put(START.getCommandName(), new StartCommand(sendBotMarkupService))
                .put(STOP.getCommandName(), new StopCommand(sendBotMessageService))
                .put(HELP.getCommandName(), new HelpCommand(sendBotMessageService))
                .put(RANDOMPROGRAMMINGJOKE.getCommandName(), new RandomProgramingJokeCommand(sendBotMessageService))
                .put(RANDOMJOKE.getCommandName(), new RandomJokeCommand(sendBotMessageService))
                .build();
        this.defaultCommand = new UnknownCommand(sendBotMessageService);
    }

    public Command retrieveCommand(String commandIdentifier) {
        return commandMap.getOrDefault(commandIdentifier, defaultCommand);
    }
}
