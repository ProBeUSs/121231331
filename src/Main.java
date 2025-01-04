import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JComponent {
    private int value = 50;
    private static final int MIN = 0;
    private static final int MAX = 100;
    private static final int SLIDER_WIDTH = 300;
    private static final int SLIDER_HEIGHT = 30;

    public Main() {
        this.setPreferredSize(new Dimension(SLIDER_WIDTH, SLIDER_HEIGHT));


        this.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int newValue = Math.max(MIN, Math.min(MAX, (e.getX() * (MAX - MIN)) / SLIDER_WIDTH));
                setValue(newValue);
            }
        });
    }


    public void setValue(int newValue) {
        if (newValue != value) {
            value = newValue;
            repaint();  // Перемалювати компонент
        }
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);


        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, SLIDER_HEIGHT / 4, SLIDER_WIDTH, SLIDER_HEIGHT / 2);


        g.setColor(Color.BLUE);
        int thumbX = (value * SLIDER_WIDTH) / (MAX - MIN);
        g.fillRect(thumbX - 5, SLIDER_HEIGHT / 4, 10, SLIDER_HEIGHT / 2);


        g.setColor(Color.BLACK);
        g.drawString("Value: " + value, SLIDER_WIDTH / 2 - 20, SLIDER_HEIGHT / 2);
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Custom Slider");
        Main slider = new Main();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new FlowLayout());
        frame.add(slider);
        frame.setVisible(true);
    }
}

//git init
//git add README.md
//git commit -m "first commit"
//git branch -M main
//git remote add origin https://github.com/ProBeUSs/custom.git
//git push -u origin main