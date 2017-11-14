package better;



import better.window.Window;
import better.controler.ViewControler;

public class Application {

    public static void main(String[] args) {

        Window window = new Window();
        ViewControler viewControler = new ViewControler(window);


        viewControler.displayDashboard();



    }
}
