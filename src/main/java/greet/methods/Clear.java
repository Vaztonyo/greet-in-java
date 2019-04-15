package greet.methods;

import greet.Greet;
import greet.Greeted;

public class Clear {
//     Greeted greeted;

    public void clear(String[] splitCommand) {
        String name = null;

        if(splitCommand.length == 2) {
            for (int i = 0; i < splitCommand.length; i++) {
                name = splitCommand[1];
            }
            Greeted.getNameMap().remove(name);
            System.out.println("\nRemoved: " + name + "\n");
        } else if (splitCommand.length ==1){
            Greeted.getNameMap().clear();
            System.out.println("\nCleared!\n");
        }
    }
}
