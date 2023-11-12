/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myapp.GUI;

import com.codename1.ui.Form;
import com.mycompany.myapp.Entite.Game;
import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.SelectionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.list.DefaultListModel;
import com.codename1.ui.list.MultiList;
import com.codename1.ui.util.Resources; 
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author mahdi
 */
//MUltilist savei el array list de map 5ater multi liste bech savugardi el données kolhom fi map => mouch Game mara hethy 5ate bceh nsavi f map el jaw bech naccidilhom wa9teli n7ebo 
public class GameMultiList extends Form{
    EncodedImage enc;
    Image img=null;
     
    public GameMultiList(Resources theme) {
      Toolbar tb =new Toolbar();
      setToolbar(tb);
      tb.addMaterialCommandToSideMenu("accueil", FontImage.MATERIAL_ACCESS_ALARM,  (e) ->new SignUp(theme).showBack());
      // tb.addMaterialCommandToSideMenu("panier", FontImage.MATERIAL_SHOPPING_BASKET,  (e) ->  new Paniers(theme).showBack());
      //tb.addCommandToLeftBar("List view",null, (e) -> new GamesList(theme).showBack());
      
        ArrayList<Map<String, Object>> data = new ArrayList<>();
        Game game1 = new Game("Devil May Cry 5", 200, "/dmc5.jpg", "Even with the best gameplay footage and screenshots to entice players to dive deeper on your game page, you can’t just stick a basic marketplace description and count on the visuals to pull more than their fair share of the weight to convince players to choose your game.","http://localhost/Gstore/dmc5.jpg");
        Game game2 = new Game("Resident Evill VIII", 200, "/re8.jpg", "Even with the best gameplay footage and screenshots to entice players to dive deeper on your game page, you can’t just stick a basic marketplace description and count on the visuals to pull more than their fair share of the weight to convince players to choose your game.","http://localhost/Gstore/re8.jpg");
        Game game3 = new Game("Need For Speed Heat", 100, "/nfs.jpg", "Even with the best gameplay footage and screenshots to entice players to dive deeper on your game page, you can’t just stick a basic marketplace description and count on the visuals to pull more than their fair share of the weight to convince players to choose your game.","http://localhost/Gstore/nfs.jpg");
        Game game4 = new Game("Red Dead Redemption II", 150, "/rdr2.jpg", "Even with the best gameplay footage and screenshots to entice players to dive deeper on your game page, you can’t just stick a basic marketplace description and count on the visuals to pull more than their fair share of the weight to convince players to choose your game.","http://localhost/Gstore/rdre2.jpg");
        Game game5 = new Game("FIFA 22", 100, "/fifa.jpg", "Even with the best gameplay footage and screenshots to entice players to dive deeper on your game page, you can’t just stick a basic marketplace description and count on the visuals to pull more than their fair share of the weight to convince players to choose your game.","http://localhost/Gstore/fifa.jpg");        
        Game game6 = new Game("Minecraft", 200, "/minecraft.jpg", "Even with the best gameplay footage and screenshots to entice players to dive deeper on your game page, you can’t just stick a basic marketplace description and count on the visuals to pull more than their fair share of the weight to convince players to choose your game.","http://localhost/Gstore/minecraft.jpg");
        data.add(createListEntry(game1));
        data.add(createListEntry(game2));
        data.add(createListEntry(game3));
        data.add(createListEntry(game4));
        data.add(createListEntry(game5));
        data.add(createListEntry(game6));
        
        DefaultListModel<Map<String, Object>> model = new DefaultListModel<>(data);
        MultiList ml = new MultiList(model);


        //Add a selection listener to the MultiList
        ml.addSelectionListener(new SelectionListener() {
            @Override
            public void selectionChanged(int oldSelected, int newSelected) {
                // Get the selected game's details from the data
                System.out.println("selected index"+newSelected);
                Map<String, Object> selectedEntry = data.get(newSelected);
                Game selectedGame = (Game) selectedEntry.get("game"); // Assuming you store the Game object in the entry
                // Navigate to the GameDetails form with the selected game's details
              new GameDetali(theme, selectedGame).show();
            }
        });
               this.add( ml);
    }
    
     private Map<String, Object> createListEntry(Game game) {
        Map<String, Object> entry = new HashMap<>();
        entry.put("Line1", game.getName());
        entry.put("Line2", game.getPrice() + " TND");
        // You can set the "icon" entry with the image associated with the game
        entry.put("icon", getImage(game.getUrl())); // Assuming theme contains the images
        entry.put("game", game); // Store the Game object for later retrieval
        return entry;
    }
    public Image getImage(String url){
         //EncodedImage enc= null;
        try {
            enc = EncodedImage.create("/load.png");
        }
        catch (IOException ex){
        }
        //URLImage img = URLImage.createToStorage(enc, "test"+url, url);
        img = URLImage.createToStorage(enc,url, url,URLImage.RESIZE_SCALE);
        return img;
     }

    
}
