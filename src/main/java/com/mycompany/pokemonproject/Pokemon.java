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
    protected int energy;
    protected int energyMax;
    private int strength;
    private int speed;
    ArrayList<Item> inventory = new ArrayList<Item>();
    
    public int getEnergy() {
        return this.energy;
    }
    
    public void setRoom(Room room2) {
        this.location = room2;
    }
    
    public Room getRoom() {
        return this.location;
    }
    
    public void getHealedPotion() {
    energy = Math.min(energy + PokemonProject.potion.value, PokemonProject.player.energyMax);
    }
    public void getHealedBerry() {
    energy = Math.min(energy + PokemonProject.oranberry.value, PokemonProject.player.energyMax);
    }
    
    public Pokemon(String name, int value, int energy, int energyMax, int strength, int speed, Room location) {
        assert energy >= 1;
        assert energy <= 100;
        
        this.name = name;
        this.value = value;
        this.energy = energy;
        this.energyMax = energyMax;
        this.strength = strength;
        this.speed = speed;
        this.location = location;
    }
}
