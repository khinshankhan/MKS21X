import javax.swing.*;
public class Window extends JFrame {
    public Window() {
        this.setTitle("My first GUI");
        this.setSize(600,400);
        this.setLocation(100,100);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        Window g = new Window();
        g.setVisible(true);
    }
}
