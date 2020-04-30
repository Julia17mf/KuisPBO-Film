import javax.swing.*;

public class LoginView extends JFrame {
    JLabel ljudul, lusername, lpassword;
    JTextField username;
    JButton login;
    JPasswordField  password;

    public LoginView() {
        setTitle("Login Admin");

        //LABEL
        ljudul      = new JLabel("LOGIN ADMIN");
        lusername   = new JLabel("Username");
        lpassword   = new JLabel("Password");

        //TEXT FIELD
        username    = new JTextField();

        //PASSWORD FIELD
        password    = new JPasswordField();

        //BUTTON
        login       = new JButton("Login");

        setLayout(null);
        add(ljudul);
        add(lusername);
        add(lpassword);
        add(username);
        add(password);
        add(login);

        ljudul.setBounds(100, 20, 200, 20);
        lusername.setBounds(20, 50, 100, 20);
        username.setBounds(120, 50, 140, 20);
        lpassword.setBounds(20, 80, 100, 20);
        password.setBounds(120, 80, 140, 20);
        login.setBounds(100, 110, 80, 20);

        setSize(300, 200);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public String getUsername() {
        return username.getText();
    }

    public String getPassword() {
        return password.getPassword().toString();
    }
}
