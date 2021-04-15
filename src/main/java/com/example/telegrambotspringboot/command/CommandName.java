package com.example.telegrambotspringboot.command;

public enum CommandName {
    START("/start"),
    STOP("/stop"),
    HELP("/help");

    private String commandName;

    CommandName(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }
}
