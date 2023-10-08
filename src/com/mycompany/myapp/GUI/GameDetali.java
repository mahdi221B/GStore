/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myapp.GUI;

import Entite.Game;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.util.Resources;
import java.io.IOException;

/**
 *
 * @author mahdi
 */
public class GameDetali extends Form{
    private Image image;
    private SpanLabel description;
    private Label price;
    private Button btn;

    public GameDetali(Resources theme, Game game) {
       this.setLayout(BoxLayout.y());
       Toolbar tb = new Toolbar();
       this.setToolbar(tb);
       tb.setTitle(game.getName());
       tb.addCommandToLeftBar("back",null,ev-> new GameList(theme).showBack());
       
       Container content = new Container(BoxLayout.y());
        try {
            image = Image.createImage(game.getImg());
            int width = Display.getInstance().getDisplayWidth() / 2;
            int height = Display.getInstance().getDisplayHeight() / 3;
            image = image.scaledWidth(width).scaledHeight(height);
        } catch (IOException ex) {
            System.out.println(ex);
        }

        description = new SpanLabel(game.getDescription());

        Container priceContainer = new Container(new FlowLayout(CENTER));
        price = new Label(game.getPrice() + " TND");
        priceContainer.add(price);
        
        
        content.add(image);
        content.add(description);
        content.add(priceContainer);

        Container buttonContainer = new Container(new FlowLayout(CENTER));
        btn = new Button("Buy");
        buttonContainer.add(btn);
        LayeredLayout ll = new LayeredLayout();
        setLayout(ll);
        this.add(content);
        this.add(buttonContainer);

        ll.setInsets(buttonContainer, "auto auto 0 auto");
    }
}