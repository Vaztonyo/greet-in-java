package greet;

enum Languages {
    ENGLISH("Hello, how are you "),
    FRENCH("Bonjour, comment vas-tu "),
    AFRIKAANS("Hallo, hoe gaan dit met jou ");

    private final String greeting;

    Languages(String greeting) {
        this.greeting = greeting;
    }

    public String getGreeting(){
        return this.greeting;
    }
}





