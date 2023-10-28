package crv;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BotMM extends TelegramLongPollingBot {
    private final String name;
    private final String ResMessage="something wrong";
    //private Map<Long, List<String>> UsersData = new HashMap<>(); //have all chat tokens and their state + needed prev data
    public BotMM(String token, String name) {
        super(token);
        this.name = name;
    }
    /*public List<String> GetUserData(Long UserID){
        return UsersData.get(UserID);
    }*/
    public static void main(String[] args) throws IOException, TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);

        var token = "6570450285:AAHozEqDNeGulLwXAAuxCPHvE6hNqkL2lFw"; //need to change for file but for now will be empty and need to fill handy
        var name = "MM&DM";

        telegramBotsApi.registerBot(new BotMM(token, name));
    }
    public void onUpdateReceived(Update update) {
        var Objmessage = update.getMessage();
        var message = Objmessage.getText();
        if (message != null) {

            var chatId = Objmessage.getChatId();
            var MessgeResp = new MessageResponce(chatId, message);
            SendMessage response = new SendMessage();
            response.setText(MessgeResp.getMessage());
            response.setChatId(chatId);
            try {
                execute(response);
            } catch (TelegramApiException e) {
                e.printStackTrace();
                //throw new RuntimeException(e);

            }
        }
    }

    public String getBotUsername() {
        return name;
    }
}