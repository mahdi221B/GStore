/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myapp.GUI;
import com.mycompany.myapp.Entite.Game;
import com.codename1.components.SpanLabel;
import com.codename1.db.Database;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
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
       tb.addCommandToLeftBar("back",null,ev-> new GameMultiList(theme).showBack());
       
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
        btn.addActionListener(e -> {
            saveGameToDataBase(game);
            if (Dialog.show("succes", "Game ajoutée avec succé", "okAndGoBack", "cancelAndExit")){
                new GameMultiList(theme);
            }else{
                Display.getInstance().exitApplication();
            }
        });
        LayeredLayout ll = new LayeredLayout();
        setLayout(ll);
        this.add(content);
        this.add(buttonContainer);

        ll.setInsets(buttonContainer, "auto auto 0 auto");
    }
    public void saveGameToDataBase (Game game) {
        Database db = null;
        try {
            db= Database.openOrCreate("G-store.db");
        } catch (IOException ex) {
            System.out.println(ex);
        }
        
        try {
            db.execute("create table if not exists GAMES (name varchar(100), price varchar(100), imageUrl varchar(100));");
            System.out.println("Table crée");
        } catch (IOException ex) {
            System.out.println(ex);
        }
        
        try {
            db.execute("insert into GAMES (name, price, imageUrl) values('"+game.getName()+"','"+game.getPrice()+"','"+game.getUrl()+"')");
            System.out.println("Game ajouté");
        } catch (IOException ex) {
            System.out.println(ex);
        }
    } 
}