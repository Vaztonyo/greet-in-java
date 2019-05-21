package greet;

import java.util.HashMap;
import java.util.Map;

public class Greeted implements GreetInterface {
    public static Map<String, Integer> greeted = new HashMap<>();

    @Override
    public String greetPerson(String name, String language) {
        String greeting;

        if (greeted.containsKey(name)) {
            greeted.computeIfPresent(name, (k, v) -> v + 1);
        } else {
            greeted.put(name, 1);
        }
        greeting = "\n" + Languages.valueOf(language).getGreeting() + name + "\n";

        return greeting;
    }

    @Override
    public String greeted(String userName) {
        String message = "";
        String value = "";
        String key = "";

            try {
                if(userName.isEmpty()) {
                    for (String name: greeted.keySet()){
                        key = name;
                        value = greeted.get(name).toString();
                        message += "\nName: " + key + ", Times Greeted: " + value + "\n";
                    }
                }
                if (!userName.isEmpty()){
                    key = userName;
                    value = greeted.get(userName).toString();
                    message = "\nName: " + key + ", Times Greeted: " + value + "\n";
                }
                else if (userName.isEmpty() && greeted.isEmpty()) {
                    message = "\nNobody has been greeted yet";
                }
            } catch (NullPointerException e) {
                    message = "\nSorry " + userName + " you have not been greeted yet.\n";
            }
        return message;
    }

    @Override
    public String counter(){
        int count = greeted.size();
        return "Number of people that were greeted: " + count;
    }

    @Override

    public String clear(String userName) {
        String clearMsg = "";
            if(userName.isEmpty() && !greeted.isEmpty()) {
                greeted.clear();
                clearMsg = "\nCleared!\n";
            } else if (greeted.containsKey(userName)){
                greeted.remove(userName);
                clearMsg = "\nRemoved: " + userName + "\n";
            }
         else{
            clearMsg = "Cannot remove name(s) that has not been greeted";
        }
         return clearMsg;
    }

}
