package greet.commands;

public class CommandExtractor {

    private String command;
    private String name;
    private String lang;
    String[] splitCommand;


public CommandExtractor(String enteredCommand){
    splitCommand = enteredCommand.split(" ");
    this.command = splitCommand[0];

    if (splitCommand.length >= 2){
        String toUpper = splitCommand[1];
        this.name = toUpper.substring(0,1).toUpperCase() + toUpper.substring(1).toLowerCase();
    } else{
        this.name = "";
    }

    if(splitCommand.length == 3){
        this.lang = splitCommand[2].toUpperCase();
    } else {
        this.lang = "ENGLISH";
    }
}

    public String getCommand() {
        return command;
    }

    public String getName() {
        return name;
    }

    public String getLang() {
        return lang;
    }
}
