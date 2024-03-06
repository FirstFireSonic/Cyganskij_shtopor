package com.example.Cyganskij_shtopor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import settings.CommandsBot;

@SpringBootApplication
public class CyganskijShtoporApplication {
	public static void main(String[] args) throws TelegramApiException {
		SpringApplication.run(CyganskijShtoporApplication.class, args);
		CommandsBot bot = new CommandsBot();
		TelegramBotsApi telegramBot = new TelegramBotsApi(DefaultBotSession.class);
		telegramBot.registerBot(bot);
	}

}
