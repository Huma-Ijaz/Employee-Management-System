package employee.management.system;
import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame {
    Splash() {
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/front.gif")); // get image from source
        Image i2 = i1.getImage().getScaledInstance(1170, 650, Image.SCALE_DEFAULT); // Image Scaled
        ImageIcon i3 = new ImageIcon(i2); // image i2 is placed into icon
        JLabel image = new JLabel(i3); // Place i3 JFrame to display on our screen
        image.setBounds(0, 0, 1170, 650);
        add(image);

        setSize(1170, 650);
        setLocation(150, 50);
        setLayout(null);
        setVisible(true);

        try {
            Thread.sleep(5000); // To show JFrame visibility
            setVisible(false); // Stop showing splash after given time
            new Login();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        new Splash();
    }
}


