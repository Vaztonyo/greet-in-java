package greet.methods;
import greet.Greeted;

public class Counter {

    int greetCount = 0;

    public int counter(){
        greetCount = Greeted.getNameMap().size();

        System.out.println("\n" + greetCount + "\n");
        return greetCount;
    }
}
