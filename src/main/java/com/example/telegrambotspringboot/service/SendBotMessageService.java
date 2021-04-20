package com.example.telegrambotspringboot.service;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;

public interface SendBotMessageService {

    void sendMessage(String chatId, String message);

    void sendMessageWithButton(String chatId, String message, String buttonText);

    void sendMessageWithMarkup(String chatId, String message, ReplyKeyboard replyKeyboard);
}
