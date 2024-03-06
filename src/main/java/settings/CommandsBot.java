package settings;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class CommandsBot extends TelegramLongPollingBot {

	@Override
	public String getBotUsername() {
		return "Cyganskij_shtopor_bot";
	}
	@Override
	public String getBotToken() {
		return "6869961428:AAHDEN-_Qihj8XV2mB8HvFB0Zqtnw-4zw38";
	}
	
	private void sendWithOutURL (Message message) {
		InlineKeyboardMarkup keyboard = new InlineKeyboardMarkup();
		InlineKeyboardButton button = new InlineKeyboardButton();
		
		button.setText("Кнопка");
		button.setCallbackData("start0");
		
		List<InlineKeyboardButton> keyboardButtonRow = new ArrayList<>();
		keyboardButtonRow.add(button);
		
		List<List<InlineKeyboardButton>> rowlist = new ArrayList<>();
		rowlist.add(keyboardButtonRow);
		
		keyboard.setKeyboard(rowlist);
		try {
			execute(
				SendMessage.builder()
				.chatId(message.getChatId())
				.parseMode("Markdown")
				.text("Текст над кнопкой")
				.replyMarkup(keyboard)
				.build());
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
		
		
	}
	
	public void onUpdateReceived(Update update) {
		 if (update.hasMessage() && update.getMessage().hasText()) {
			 String messageText = update.getMessage().getText();
			 Message command = update.getMessage();
			 long chatID = update.getMessage().getChatId();
			 
			 switch (messageText) {
			 case "/start":
				 startAnswer(command, chatID);
				 break;
			default:
				try {
					execute(
						SendMessage.builder()
						.chatId(command.getChatId())
						.parseMode("Markdown")
						.text("Текст над кнопкой")
						.build());
					} catch (TelegramApiException e) {
						e.printStackTrace();
					}
				break;
			 
			 }
		 }
		 else if (update.hasCallbackQuery()) {
			 if (update.getCallbackQuery().getData().equals("start0")) {
				 try {
					 execute(
							 SendMessage.builder()
							 .chatId(update.getCallbackQuery().getMessage().getChatId())
							 .parseMode("Markdown")
							 .text("_Результат нажатия кнопки_")
							 .build());
				 } catch (TelegramApiException e) {
					 e.printStackTrace();
				 }			 
			 }
		 }
	}
	
	public void startAnswer(Message command, long chatID) {
		
		sendWithOutURL(command);

		try {
		execute(
			SendMessage.builder()
			.chatId(command.getChatId())
			.parseMode("Markdown")
			.text("_Результат нажатия кнопки_")
			.build());
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
