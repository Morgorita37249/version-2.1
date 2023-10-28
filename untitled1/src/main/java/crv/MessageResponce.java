package crv;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageResponce extends DataBase {
    private Long UserID;// Идентификатор пользователя
    private String Message;// Сообщение от пользователя
    private String FinalMessage="Oops,something wrong";



    // private Map<Integer, String> CabinetDecode= Map.of(0,"501",1,"502",2,"503",3,"504",4,"505",5,"506",6,"507",7,"508",8,"509",9,"510",10,"511",11,"512",12,"513",13,"514",14,"515",15,"516",16,"517",17,"518",18,"519",19,"520",20,"521",21,"522",22,"523",23,"524",24,"525",25,"526",26,"527",27,"528",28,"529",29,"530",30,"531",31,"532",32,"533",33,"534",34,"535",35,"536",36,"537",37,"538",38,"539",39,"540");
    //private Map<Integer, String> FirstCabinets = Map.of(0,"501",1,"502",2,"503");
    public MessageResponce(Long UserID,String Mes){
        this.UserID=UserID;
        this.Message=Mes;
        // Если пользователя нет в базе данных, добавляем его с начальными значениями
        if(!UsersData.containsKey(UserID)){
            List<String> temp = new ArrayList<>();
            temp.add(0,"new");
            UsersData.put(UserID,temp);
        }
        Command_Decode(Message,UserID);
    }
    public void Command_Decode(String message, Long UserID) {
        //CommandResponce output = new CommandResponce() {


        switch (message){
            case "/navigator":
                Navigation();
                break;
            case "/start":
                Start();
                break;
            case "/credits":
                Credits();
            default:
                Others();
        }
    }
    /*
    public interface CommandResponce {


        String Start();
        String Navigation();
        String Credits();
        String AddYourMap(); //for future
        void Exeptions();

    }
    */

    public void Start() {
        FinalMessage="Hello i'm MM bot";
    }
    public void Credits() {
        FinalMessage="I was made by";
    }
    public void Navigation() {
        List<String> temp=UsersData.get(UserID);
        temp.set(1,Message);
        temp.set(0,"navigation 1");
        UsersData.put(UserID,temp);
    }
    public void Others() {
        switch (UsersData.get(UserID).get(0)){
            case "navigation 1":
				/*
				 calculateDifference(Long source, Long target)
				*/
                FinalMessage = "здесь вывод пути";
                break;

            default:
                FinalMessage="Sorry i can't understand you";
        }
    }
    public String getMessage(){
        return FinalMessage;
    }
}