/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myapp.Service;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
import com.codename1.io.Util;

/**
 *
 * @author GAMING
 */
public class LoginService {
    Boolean res =false;
    public Boolean login(String username,String password){
        String  url = "http://localhost/Gstore/login.php?login=" + username + "&password=" + password;
        System.out.println(url);
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl(url);
        con.setPost(false);
        con.addResponseListener(e->{
        String reponse = new String(con.getResponseData());
        if ("OK".equals(reponse)) {
            System.out.println("Authentication successful");
            res=true;
        } else {
            System.out.println("Authentication failed");
        }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return res;
    }
}
