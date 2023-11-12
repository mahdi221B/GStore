/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myapp.GUI;
import com.mycompany.myapp.Entite.Game;
import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources; 
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author mahdi
 */
public class GameList extends Form {
    
     public GameList(Resources theme) {
       this.setLayout(BoxLayout.y());
       Toolbar tb = new Toolbar();
       this.setToolbar(tb);
       tb.setTitle("G-Store Esprit");
       tb.addCommandToLeftBar("back",null, ev-> new SignUp(theme).showBack());
        
       ArrayList<Game> games = new ArrayList<>();
       Game game1 = new Game("Devil May Cry 5", 200, "/dmc5.jpg", "Even with the best gameplay footage and screenshots to entice players to dive deeper on your game page, you can’t just stick a basic marketplace description and count on the visuals to pull more than their fair share of the weight to convince players to choose your game.",null);
       Game game2 = new Game("Resident Evill VIII", 200, "/re8.jpg", "Even with the best gameplay footage and screenshots to entice players to dive deeper on your game page, you can’t just stick a basic marketplace description and count on the visuals to pull more than their fair share of the weight to convince players to choose your game.",null);
       Game game3 = new Game("Need For Speed Heat", 100, "/nfs.jpg", "Even with the best gameplay footage and screenshots to entice players to dive deeper on your game page, you can’t just stick a basic marketplace description and count on the visuals to pull more than their fair share of the weight to convince players to choose your game.",null);
       Game game4 = new Game("Red Dead Redemption II", 150, "/rdr2.jpg", "Even with the best gameplay footage and screenshots to entice players to dive deeper on your game page, you can’t just stick a basic marketplace description and count on the visuals to pull more than their fair share of the weight to convince players to choose your game.",null);
       Game game5 = new Game("FIFA 22", 100, "/fifa.jpg", "Even with the best gameplay footage and screenshots to entice players to dive deeper on your game page, you can’t just stick a basic marketplace description and count on the visuals to pull more than their fair share of the weight to convince players to choose your game.",null);        
       Game game6 = new Game("Minecraft", 200, "/minecraft.jpg", "Even with the best gameplay footage and screenshots to entice players to dive deeper on your game page, you can’t just stick a basic marketplace description and count on the visuals to pull more than their fair share of the weight to convince players to choose your game.",null);
       Collections.addAll(games,game1,game2,game3,game4,game5,game6);
       
       for (Game game : games) {
            Container gameItem = addItem(game, theme);
            Button myBtn = new Button();
            myBtn.addActionListener(e -> {new GameDetali(theme, game).show();});
            gameItem.setLeadComponent(myBtn);
            this.add(gameItem);
       }
    }
     
     public Container addItem(Game game, Resources theme){
        Container c1 = new Container(BoxLayout.x());
        // direct
        Image im = null;
         /* try {
              im = Image.createImage(game.getImg());
          } catch (IOException ex) {
              System.out.println(ex);
          }*/
         //M2 du serveur  
          im = getImage("http://localhost/Gstore/"+game.getImg());
          ImageViewer img = new ImageViewer(im);
          Container c2 = new Container(BoxLayout.y());
          Label name = new Label(game.getName());
          Label price = new Label(game.getPrice()+" TND");
          c2.add(name);
          c2.add(price);
          c1.add(img);
          c1.add(c2);
        return c1;
     }
     
     public Image getImage(String url){
         EncodedImage enc= null;
        try {
            enc = EncodedImage.create("/load.png");
        }
        catch (IOException ex){
        }
        URLImage img = URLImage.createToStorage(enc, "test"+url, url);
        return img;
     }
     
     
}
