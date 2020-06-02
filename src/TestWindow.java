import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestWindow extends JFrame {
    static String text ="";

    public TestWindow(){
        setTitle("TEST");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(800,300,416,633);

        JLabel label = new JLabel("Hello, World!");
        add(label);

        JButton[][] buttons = addButtons(5,4, 100);




        setVisible(true);
    }
    public JButton[][] addButtons( int height, int width, int buttonSize){
        JTextField field = new JTextField();
        field.setBounds(0,0,416,buttonSize);
        add(field );
        JButton[][] buttons = new JButton[height][width];
        setLayout(null);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                buttons[i][j] = new JButton(String.format("[%s][%s]",i,j));
                buttons[i][j].setBounds(j*buttonSize,i*buttonSize+buttonSize, buttonSize,buttonSize);
                add(buttons[i][j]);
                int finalI = i;
                int finalJ = j;
                buttons[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        text = text + buttons[finalI][finalJ].getText();
                        field.setText(text);


                    }
                    });
            }
        }
        return buttons;
    }
}
