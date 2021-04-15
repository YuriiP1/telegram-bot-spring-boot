package com.example.telegrambotspringboot.service;

public interface SendBotMessageService {

    void sendMessage(String chatId, String message);
}
