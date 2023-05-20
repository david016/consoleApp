import services.AppHandler;

public class Main {
    public static void main(String[] args) {
        AppHandler ah = new AppHandler();
        ah.startApp();
        System.out.println(ah.getPeople());
    }
}
