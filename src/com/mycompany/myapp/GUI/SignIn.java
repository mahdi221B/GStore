/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myapp.GUI;

import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;

/**
 *
 * @author mahdi
 */
public class SignIn extends Form{
    private Image img;
    private ImageViewer imgV;
    private TextField userName;
    private TextField email;
    private TextField password;
    private Picker brithDate;
    private TextArea adressFact;
    private Container buttonsContainer;
    private Button inscriBtn;
    private Button cancelBtn;
    
    public SignIn(Resources theme){
    this.setLayout(BoxLayout.y());
    this.setTitle("Inscription");
    img = theme.getImage("img.jpg");
    imgV = new ImageViewer(img);
    this.add(imgV);
    
    userName = new TextField("", "Username", 20,TextField.ANY);
    email = new TextField("", "Email", 20,TextField.ANY);
    password = new TextField("", "mot de passe", 20,TextField.PASSWORD);
    brithDate = new Picker();
    brithDate.setType(Display.PICKER_TYPE_DATE);
    adressFact = new TextArea("", 7,7,TextField.ANY);
    adressFact.setHint("Adresse de facturation");
    this.add(userName);
    this.add(email);
    this.add(password);
    this.add(brithDate);
    this.add(adressFact);
    inscriBtn = new Button("S'inscrire");
    cancelBtn = new Button("Cancel");
    buttonsContainer = new Container(new FlowLayout(CENTER));
    buttonsContainer.add(inscriBtn);
    buttonsContainer.add(cancelBtn);  
    this.add(buttonsContainer);  
    
    cancelBtn.addActionListener(e -> {
           SignUp sig = new SignUp(theme);
           sig.show();
       });
    }

}
