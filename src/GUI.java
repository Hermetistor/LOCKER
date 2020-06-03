import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GUI implements ActionListener {
  int counts = 10;
  JLabel lable;
  JLabel username = new JLabel("Username");
  JLabel password = new JLabel("Password");
  JButton button = new JButton();
  JTextField userTextField = new JTextField();
  JTextField passwordTextField = new JTextField();

  public GUI() {
    //frame
    JFrame frame = new JFrame();
    //button
    button.setText("Login");
    button.addActionListener(this);

    //panel
    JPanel panel = new JPanel();
    //lable
    username.setBounds(10, 20, 80, 25);
    password.setBounds(10, 50, 80, 25);
    lable = new JLabel("Chances left: 10");

    //textfield
    userTextField.setBounds(10, 20, 80, 25);


    panel.setBorder(BorderFactory.createEmptyBorder(200, 200, 200, 200));
    panel.setLayout(new GridLayout(0, 1));
    panel.add(username);
    panel.add(userTextField);
    panel.add(password);
    panel.add(passwordTextField);
    panel.add(button);
    panel.add(lable);
    frame.add(panel, BorderLayout.CENTER);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("GUI");
    frame.pack();
    frame.setVisible(true);
  }

  public static void main(String[] args) {
    new GUI();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if(counts-1>=0){
      this.counts--;
      this.lable.setText("Chances left: " + counts);

    }
    else{
      this.lable.setText("Login forbidden");
      try {
        Runtime.getRuntime().exec("rundll32 user32.dll,LockWorkStation");
      } catch (IOException ioException) {
        ioException.printStackTrace();
      }
    }
  }
}
