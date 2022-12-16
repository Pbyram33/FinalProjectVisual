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
    
    public Room(String name, String text, int n, int s, int w, int e) {
        this.name = name;
        this.text = text;
        this.n = n;
        this.s = s;
        this.e = e;
        this.w = w;       
    }
    
    public Item getItem() {
        return this.item;
    }
     
    public void setItem(Item item2) {
        item = item2;
    }
    // code from https://www.youtube.com/watch?v=EluNyKun6Lk&t=48s
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
    // code ends
}
