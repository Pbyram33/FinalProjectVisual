/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pokemonproject;

/**
 *
 * @author pbyra
 */
import java.util.ArrayList;
public class Room {
    protected String name;
    protected String text;
    private Item item;
    private int n, s, w, e;
    ArrayList<Path> Paths = new ArrayList<Path>();
    
    public Room(String name, String text, int n2, int s2, int w2, int e2) {
        this.name = name;
        this.text = text;
        this.n = n2;
        this.s = s2;
        this.e = e2;
        this.w = w2;       
    }
    
    public Item getItem() {
        return this.item;
    }
    
    public void setItem(Item item2) {
        item = item2;
    }
    
    public int getN() {
        return n;
    }
    
    public void setN(int n2) {
        this.n = n2;
    }
    
    public int getS() {
        return s;
    }
    
    public void setS(int s2) {
        this.s = s2;
    }
    
    public int getW() {
        return w;
    }
    
    public void setW(int w2) {
        this.w = w2;
    }
    
    public int getE() {
        return e;
    }
    
    public void setE(int e2) {
        this.e = e2;
    }
}
