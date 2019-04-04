package greet;

public class Language {

    static Languages lang;

    enum Languages {
        ENGLISH, FRENCH, AFRIKAANS
    }
    
    Language(Languages lang) {
        this.lang = lang;
    }

    public static void main(String[] args) {

        switch (lang) {
            case ENGLISH:
                System.out.println("Hi " + "name" + ", how are you?");
                break;
            case FRENCH:
                System.out.println("Salut " + "name" + " comment vas-tu?");
                break;
            case AFRIKAANS:
                System.out.println("Hallo " + "name " + "hoe gaan dit met jou?");
                break;
                default:
                    System.out.println("Hi " + "name" + ", how are you?");
                    break;
        }

    }

}
