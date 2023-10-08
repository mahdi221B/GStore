/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myapp.GUI;

import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;

/**
 *
 * @author mahdi
 */
public class ResetPassword extends Form{
    private Image img;
    private ImageViewer imgV;
    private TextField userName;
    private Button resetBtn;
    private Button backBtn;

    public ResetPassword(Resources theme) {
       this.setLayout(BoxLayout.y());
       this.setTitle("Réinstaller le mot de passe");
       img = theme.getImage("img.jpg");
       imgV = new ImageViewer(img);
       this.add(imgV);
       userName = new TextField("", "Username", 20,TextField.ANY);
       this.add(userName);
       resetBtn = new Button("Réinstaller le mot de passe");
       this.add(resetBtn);
       
        Toolbar titleBar = this.getToolbar();
        //titleBar.setTitleComponent(createTitleComponent(theme,backBtn));
        setToolbar(titleBar);
        titleBar.addCommandToLeftBar("", theme.getImage("backArrow.png").scaledWidth(100), 
                ev-> new SignUp(theme).showBack());
    }
    
    /*private Component createTitleComponent(Resources theme, Button backBtn) {
        Container c = new Container(BoxLayout.x());
        backBtn = new Button(theme.getImage("backArrow.png").scaledWidth(100));
        backBtn.addActionListener(e -> {
            SignUp s = new SignUp(theme);
            s.show();
        });
        c.add(backBtn);
        Label titleLabel = new Label("Réinstaller le mot de passe");
        c.add(titleLabel);
        return c;
    }*/
}
