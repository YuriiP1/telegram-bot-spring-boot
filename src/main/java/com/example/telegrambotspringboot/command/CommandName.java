package com.example.telegrambotspringboot.command;

public enum CommandName {
    START("/start"),
    STOP("/stop"),
    HELP("/help"),
    RANDOMPROGRAMMINGJOKE("/randomprogrammingjoke"),
    RANDOMJOKE("/randomjoke"),
    GOOGLE("/google");

    private String commandName;

    CommandName(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }
}
