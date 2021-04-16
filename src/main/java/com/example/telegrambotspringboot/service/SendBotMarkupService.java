package com.example.telegrambotspringboot.service;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;

public interface SendBotMarkupService {

    void sendMarkup(String chatId, String message, ReplyKeyboard replyKeyboard);
}
