package greet.methods;

public class Help {
    public void help() {
        System.out.println("\nHelp Menu: \n" +
                "\nThe following are commands you are able to enter in this program: \n" +
                "\n1.greet + your/or anyone's name(this will prompt a language choice and display a greeting of the selected language), " +
                "\n2.greeted will display a list of all people that has been greeted and how many time each person has been greeted, " +
                "\n3.greeted + your/or anyone's name will display how many times you/that person have been greeted " +
                "\n4.counter displays a count of how many people has been greeted " +
                "\n5.clear deletes all people that were greeted and then resets the greet counter to 0 " +
                "\n6.clear + your/or anyone's name will delete the greet counter for that person and decrement the greet counter by 1 " +
                "\n7.exit exits the program " +
                "\n8.help shows a person an overview of all possible commands(which is this help menu)\n" +
                "\nNote: Valid Languages are: English, French & Afrikaans\n");
    }
}
