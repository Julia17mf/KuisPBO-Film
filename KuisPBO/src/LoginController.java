import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController {
    LoginView loginView;

    public LoginController(LoginView loginView) {
        this.loginView = loginView;

        loginView.login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = loginView.getUsername();
                String password = loginView.getPassword();
                System.out.println(password);
                if(username.equals("admin")) {
                    loginView.setVisible(false);
                    new KuisMVC();
                }
                else {
                    JOptionPane.showMessageDialog(null, "Username atau Password salah");
                    loginView.username.setText(null);
                    loginView.password.setText(null);
                }
            }
        });
    }
}