/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myapp.GUI;

import com.codename1.db.Cursor;
import com.codename1.db.Database;
import com.codename1.db.Row;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.Entite.Game;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author mahdi
 */
public class Panier extends Form {

    EncodedImage enc;
    Image img = null;
    Database db = null;
    ArrayList<Game> listGame;

    public Panier(Resources theme) {
       this.setLayout(BoxLayout.y());
       Toolbar tb = new Toolbar();
       this.setToolbar(tb);
       tb.setTitle("panier");
        try {
            db = Database.openOrCreate("G-store.db");
        } catch (IOException ex) {
            System.out.println(ex);
        }
        listGame = listGame();
        System.out.println(listGame);
        //listGame.forEach(e -> System.out.println(e));
    }

    public ArrayList<Game> listGame() {
        try {
            Cursor cur = db.executeQuery("select * from GAMES");
            System.out.println("Games selected");
            while (cur.next()) {
                Row row = cur.getRow();
                String name = row.getString(0);
                String price = row.getString(1);
                String url = row.getString(2);
                Game g = new Game(name, Float.parseFloat(price), url);
                listGame.add(g);
                System.out.println("Game added to the list");
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return listGame;
    }
    
    public Image getImage(String url){
        try {
            enc = EncodedImage.create("/load.png");
        }
        catch (IOException ex){
        }
        img = URLImage.createToStorage(enc, "test"+url, url);
        return img;
     }
}
