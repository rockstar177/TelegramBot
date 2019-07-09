package Weather;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;

public class Bot extends TelegramLongPollingBot
{

	public static void main(String[] args)
	{
		ApiContextInitializer.init();
		TelegramBotsApi tlgBot = new TelegramBotsApi();
		try
		{
			tlgBot.registerBot(new Bot());
		}
		catch(TelegramApiRequestException Exception)
		{
			Exception.printStackTrace();
		}
		
	}
	public void setButton(SendMessage sendMessage)
	{
		ReplyKeyboardMarkup replyKeyboard = new ReplyKeyboardMarkup();
		sendMessage.setReplyMarkup(replyKeyboard);
		replyKeyboard.setSelective(true);
		replyKeyboard.setResizeKeyboard(true);
		replyKeyboard.setOneTimeKeyboard(false);
		List <KeyboardRow> keyboardRowList = new ArrayList<>();
		KeyboardRow keyboardFirstRow = new KeyboardRow();
		keyboardFirstRow.add(new KeyboardButton("/Help"));
		keyboardFirstRow.add(new KeyboardButton("/Settings"));
		//keyboardFirstRow.add(new KeyboardButton("/Weather"));
		keyboardRowList.add(keyboardFirstRow);
		replyKeyboard.setKeyboard(keyboardRowList);
	}
	public void sendMsg(Message message, String Text)
	{
		SendMessage sendMessage = new SendMessage(); 
		sendMessage.enableMarkdown(true);
		sendMessage.setChatId(message.getChatId().toString());
		sendMessage.setReplyToMessageId(message.getMessageId());
		sendMessage.setText(Text);
		try
		{
			setButton(sendMessage);
			sendMessage(sendMessage);
		}
		catch(TelegramApiException Exception)
		{
			Exception.printStackTrace();
		}
	}
	@Override
	public String getBotUsername()
	{
		return "QuitBot";
	}

	@Override
	public void onUpdateReceived(Update update)
	{
		Model model = new Model();
		Message message = update.getMessage();
		if(message != null && message.hasText())
		{
			switch(message.getText())
			{
				case "/Help":
					sendMsg(message,"How can I help?");
					break;
				case "/Settings":
					sendMsg(message, "What are we going to customize?");
					break;
				default: //"/Weather":
					try
					{
						sendMsg(message,Weather.getWeather(message.getText(), model));
					}
					catch(IOException e)
					{
						sendMsg(message,"City is not found!");
					}
					break;
				//default:
			}
		}
	}

	@Override
	public String getBotToken()
	{
		return "807174479:AAEP0wnJmFMsU8jPi9lNOuSVVHaJcxd5KAI";
	}

}
