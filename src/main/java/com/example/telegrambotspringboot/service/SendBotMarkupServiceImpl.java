package com.example.telegrambotspringboot.service;

import com.example.telegrambotspringboot.bot.RandomBot;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class SendBotMarkupServiceImpl implements SendBotMarkupService{

    private final RandomBot randomBot;

    public SendBotMarkupServiceImpl(RandomBot randomBot) {
        this.randomBot = randomBot;
    }

    @Override
    public void sendMarkup(String chatId, String message, ReplyKeyboard replyKeyboard) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setReplyMarkup(replyKeyboard);
        sendMessage.enableHtml(true);
        sendMessage.setText(message);
        try {
            randomBot.execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
