/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pokemonproject;

import java.util.ArrayList;

/**
 *
 * @author pbyra
 */
public class Pokemon {
    protected String name;
    protected int value;
    protected Room location;
    private int health;
    private int strength;
    private int speed;
    ArrayList<Item> inventory = new ArrayList<Item>();
    
    public int getHealth() {
        return this.health;
    }
    
    public void setRoom(Room room2) {
        this.location = room2;
    }
    
    public Room getRoom() {
        return this.location;
    }
    
    public Pokemon(String name, int value, int health, int strength, int speed, Room location) {
        assert health >= 1;
        assert health <= 100;
        
        this.name = name;
        this.value = value;
        this.health = health;
        this.strength = strength;
        this.speed = speed;
        this.location = location;
    }
}
