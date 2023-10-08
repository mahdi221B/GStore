package com.mycompany.myapp.GUI;
import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;

/**
 *
 * @author mahdi
 */
public class SignUp extends Form{
    private TextField email;
    private TextField password;
    private Button inscriBtn;
    private Button loginBtn;
    private Button forgetPassBtn;
    private Image img;
    private ImageViewer imgV;
    
    public SignUp(Resources theme) {
       this.setLayout(BoxLayout.y());
       this.setTitle("S'authentifier");
       
       
       img = theme.getImage("img.jpg");
       imgV = new ImageViewer(img);
       this.add(imgV);
       email = new TextField("","Email",20,TextField.ANY);
       password = new TextField("","Password",20,TextField.PASSWORD);
       loginBtn = new Button("S'authentifier");
       inscriBtn = new Button("Créer un compte");
       forgetPassBtn = new Button("Mot passe oublié");
       this.add(email);
       this.add(password);
       this.add(loginBtn);
       this.add(inscriBtn);
       this.add(forgetPassBtn);
       
       
       loginBtn.addActionListener(e -> {
           GameList gameList = new GameList(theme);
           gameList.show();
       });
       inscriBtn.addActionListener(e -> {
           SignIn sig = new SignIn(theme);
           sig.show();
       });
       forgetPassBtn.addActionListener(e -> {
           ResetPassword resetPassword = new ResetPassword(theme);
           resetPassword.show();
       });
    }
    
}