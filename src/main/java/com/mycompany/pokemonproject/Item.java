/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pokemonproject;

/**
 *
 * @author pbyra
 */
public class Item {
    protected String name;
    private String desc;
    private int value;    
    
    public String getDesc() {
    return this.desc;
    }
    
    public Item(String name, String desc, int value) {
        this.name = name;
        this.desc = desc;
        this.value = value;
    }
}
