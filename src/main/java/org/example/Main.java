package org.example;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import org.example.Models.Inv;
import org.example.Models.Invest;
import org.example.Models.KeyAnalyzers;

import java.util.HashMap;

@ApplicationPath("/calculateInvestments")
public class Main extends Application {
    private HashMap<String, Inv> hs;
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
    private void insert_invest(Invest invest){
         hs.put(lastKey(), invest);
    }
    private void insert_key(KeyAnalyzers key){
         hs.put(lastKey(), key);
    }

    private String lastKey(){
         return String.valueOf(hs.size());
    }
}