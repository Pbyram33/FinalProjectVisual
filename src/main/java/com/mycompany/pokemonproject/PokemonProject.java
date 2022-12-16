/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.pokemonproject;
import java.awt.Image;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author pbyra
 */
public class PokemonProject {
    protected static Pokemon player = null;
    protected static ArrayList<Room> map = new ArrayList<Room>();
    
    
    protected static Item potion = new Item("Potion", "A healing device that can be used to heal 20 HP.", 20);
    protected static Item oranberry = new Item("Oran Berry", "A berry that can be eaten to heal 10 HP.", 10);
    protected static Item plush = new Item("Old Plush", "A worn out plush that is comforting to look at.", 0);
    protected static Item baseball = new Item("Baseball", "A ragged baseball that reminds you of playing cath with your parents.", 0);
    
    public static void endGame(int playerHealth) {
        if (playerHealth <= 0) {
            
            JOptionPane.showMessageDialog(null, "Game Over");
            System.exit(0);
        }
    }
    
    ArrayList getMap() {
        return map;
    }
    
    public String getItemDesc(Item item2) {
        return item2.desc;
    }
    
    public static Pokemon getPlayer() {
        return player;
    }
    // code from https://www.youtube.com/watch?v=EluNyKun6Lk&t=48s
    static void moveThingTo(Pokemon x, Room aRoom) {
        x.setRoom(aRoom);
    }
    
    static int moveTo(Pokemon y, Path dir) {
        Room r = y.getRoom();
        int exit;
        
        switch (dir) {
            case NORTH:
                exit = r.getN();
                if (exit == -1) {
                    break;
                }
                else {
                player.energy = player.energy - 2;
                int healthVal = PokemonProject.player.getEnergy();
                NewJFrame.healthLabel.setText(String.valueOf(healthVal));
                endGame(player.energy);
                break;
                }
            case SOUTH:
                exit = r.getS();
                if (exit == -1) {
                    break;
                }
                else {
                player.energy = player.energy - 2;
                int healthVal2 = PokemonProject.player.getEnergy();
                NewJFrame.healthLabel.setText(String.valueOf(healthVal2));
                endGame(player.energy);
                break;
                }
            case WEST:
                exit = r.getW();
                if (exit == -1) {
                    break;
                }
                else {
                player.energy = player.energy - 2;
                int healthVal3 = PokemonProject.player.getEnergy();
                NewJFrame.healthLabel.setText(String.valueOf(healthVal3));
                endGame(player.energy);
                break;
                }
            case EAST:
                exit = r.getE();
                if (exit == -1) {
                    break;
                }
                else {
                player.energy = player.energy - 2;
                int healthVal4 = PokemonProject.player.getEnergy();
                NewJFrame.healthLabel.setText(String.valueOf(healthVal4));
                endGame(player.energy);
                break;
                }
            default:
                exit=Path.NoPath;
                break;
        }
        if (exit != Path.NoPath) {
            moveThingTo(y, (Room) map.get(exit));
        }
        return exit;
    }
    
    public static int movePlayerTo(Path dir) {
        return moveTo(player, dir);
    }
    // code from video ends
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        map.add(new Room("Intro", "<html>" + "You're out exploring the forest with your friends when suddenly, you fall into a pit and down into a cave. Your only choice is to go North." + "</html>", 1, Path.NoPath, Path.NoPath, Path.NoPath));
        map.add(new Room("Entrance", "<html>" + "The cave is well lit, like others have been down here before. The way back up is far too steep and the only path is to your north." +"</html>", 3, Path.NoPath, Path.NoPath, Path.NoPath));
        map.add(new Room("Potion Room", "<html>" + "Potions are stored against the wall ahead of you. The only path here is to the north." + "</html>", 6, Path.NoPath, Path.NoPath, 3));
        map.add(new Room("Main Pathway", "<html>" + "The cave opens up more and is well lit with torches hung on the wall. You may travel in any direction. You notice the East and West paths have a glimmering light coming from them." + "</html>", 7, 1, 2, 4));      
        map.add(new Room("Oran Berry Room", "<html>" + "Oran Berry bushes seem to be growing in this area with fixtures for heat and light. The only path here is to the north." + "</html>", 8, Path.NoPath, 3, Path.NoPath));
        map.add(new Room("Plush Room", "<html>" + "You find a Plush that looks worn. The only way to go is East." + "</html>", Path.NoPath, Path.NoPath, Path.NoPath, 6));
        map.add(new Room("Foggy Room", "<html>" + "You find yourself in a foggy room with paths going in every direction, but you notice something strange from the West." + "</html>", 9, 2, 5, 7));
        map.add(new Room("Fireplace", "<html>" + "This area has a firepit that isn't lit, but it seems like others have been there recently. There are paths going in every direction." + "</html>", 10, 3, 6, 8));      
        map.add(new Room("Rocky Tunnel", "<html>" + "You're in a rocky tunnel, but you may move North, South, or West." + "</html>", 11, 4, 7, Path.NoPath));
        map.add(new Room("Corner", "<html>" + "You seem to be at a corner and the only new way to go is East." + "</html>", Path.NoPath, 6, Path.NoPath, 10));
        map.add(new Room("Light Room", "<html>" + "The cave seems to have a more natural light coming from the North. You may also go East, West, or South" + "</html>", 13, 7, 9, 11));
        map.add(new Room("Fork in the Road", "<html>" + "You run into a fork in the road. you must go East or to the West where something catches your eye." + "</html>", Path.NoPath, 8, 10, 12));
        map.add(new Room("Baseball Room", "<html>" + "You see a worn out baseball and it reminds you of your dad. You wonder when you'll see him again" + "</html>", Path.NoPath, Path.NoPath, 11, Path.NoPath));   
        map.add(new Room("Exit", "<html>" + "You escaped the cave!" + "</html", Path.NoPath, Path.NoPath, Path.NoPath, Path.NoPath));
        
        
        
        map.get(2).setItem(potion);
        map.get(4).setItem(oranberry);
        map.get(5).setItem(plush);
        map.get(12).setItem(baseball);
        // Playable Pokemon
        Pokemon pikachu = new Pokemon("Pikachu", 0, 65, 65, 55, 90, map.get(0));
        Pokemon meowth = new Pokemon("Meowth", 0, 70, 70, 45, 90, map.get(0));
        Pokemon riolu = new Pokemon("Riolu", 0, 75, 75, 70, 60, map.get(0));
        Pokemon sneasel = new Pokemon("Sneasel", 0, 60, 60, 75, 100, map.get(0));
        Pokemon roselia = new Pokemon("Roselia", 0, 75, 75, 75, 65, map.get(0));
       
        
        //Game start
        JOptionPane.showMessageDialog(null, "To begin, we're going to ask you a few questions. Remember to answer honestly, your choices will determine your story");
        Object[] q1 = { "Adventurous", "Quiet", "Mischevious", "Friendly" };
        int response1 = JOptionPane.showOptionDialog(null, "What character trait most fits you?", "Question 1", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, q1, 0);
        switch (response1) {
                case 0: 
                    pikachu.value = pikachu.value + 5;
                    meowth.value = meowth.value + 2;
                    riolu.value = riolu.value + 4;
                    sneasel.value = sneasel.value + 3;
                    roselia.value = roselia.value + 1;
                    break;
                    
                case 1:
                    pikachu.value = pikachu.value + 2;
                    meowth.value = meowth.value + 1;
                    riolu.value = riolu.value + 4;
                    sneasel.value = sneasel.value + 3;
                    roselia.value = roselia.value + 5;
                    
                    break;
                    
                case 2:
                    pikachu.value = pikachu.value + 1;
                    meowth.value = meowth.value + 5;
                    riolu.value = riolu.value + 3;
                    sneasel.value = sneasel.value + 4;
                    roselia.value = roselia.value + 2;
                    
                    break;
                    
                case 3:
                    pikachu.value = pikachu.value + 4;
                    meowth.value = meowth.value + 2;
                    riolu.value = riolu.value + 3;
                    sneasel.value = sneasel.value + 1;
                    roselia.value = roselia.value + 5;
                    
                    break;
        }
        Object[] q2 = { "Go Out and Party", "Stay Home and Relax", "Hangout with your close friends"};
        int response2 = JOptionPane.showOptionDialog(null, "What is your idea of a fun night?", "Question 2", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, q2, 0);
        switch (response2) {
                case 0: 
                    pikachu.value = pikachu.value + 5;
                    meowth.value = meowth.value + 3;
                    riolu.value = riolu.value + 1;
                    sneasel.value = sneasel.value + 4;
                    roselia.value = roselia.value + 2;
                    break;
                    
                case 1:
                    pikachu.value = pikachu.value + 1;
                    meowth.value = meowth.value + 3;
                    riolu.value = riolu.value + 5;
                    sneasel.value = sneasel.value + 2;
                    roselia.value = roselia.value + 4;
                    
                    break;
                    
                case 2:
                    pikachu.value = pikachu.value + 4;
                    meowth.value = meowth.value + 5;
                    riolu.value = riolu.value + 2;
                    sneasel.value = sneasel.value + 1;
                    roselia.value = roselia.value + 3;
                    
                    break;
        }
        Object[] q3 = { "Yourself", "Family", "Friends", "Money" };
        int response3 = JOptionPane.showOptionDialog(null, "What do you care about most?", "Question 3", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, q3, 0);
        switch (response3) {
                case 0: 
                    pikachu.value = pikachu.value + 2;
                    meowth.value = meowth.value + 3;
                    riolu.value = riolu.value + 5;
                    sneasel.value = sneasel.value + 4;
                    roselia.value = roselia.value + 1;
                    break;
                    
                case 1:
                    pikachu.value = pikachu.value + 5;
                    meowth.value = meowth.value + 3;
                    riolu.value = riolu.value + 2;
                    sneasel.value = sneasel.value + 1;
                    roselia.value = roselia.value + 4;
                    
                    break;
                    
                case 2:
                    pikachu.value = pikachu.value + 4;
                    meowth.value = meowth.value + 2;
                    riolu.value = riolu.value + 1;
                    sneasel.value = sneasel.value + 3;
                    roselia.value = roselia.value + 5;
                    
                    break;
                    
                case 3:
                    pikachu.value = pikachu.value + 1;
                    meowth.value = meowth.value + 5;
                    riolu.value = riolu.value + 2;
                    sneasel.value = sneasel.value + 4;
                    roselia.value = roselia.value + 3;
                    
                    break;
        }
        Object[] q4 = { "Show it a little by talking to them more", "Make it obvious by playing a prank!", "Tell it so everybody can hear", "Keep it to yourself. Too risky!" };
        int response4 = JOptionPane.showOptionDialog(null, "You want to tell someone that you like them, what do you do?", "Question 4", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, q4, 0);
        switch (response4) {
                case 0: 
                    pikachu.value = pikachu.value + 2;
                    meowth.value = meowth.value + 3;
                    riolu.value = riolu.value + 5;
                    sneasel.value = sneasel.value + 4;
                    roselia.value = roselia.value + 1;
                    break;
                    
                case 1:
                    pikachu.value = pikachu.value + 5;
                    meowth.value = meowth.value + 3;
                    riolu.value = riolu.value + 2;
                    sneasel.value = sneasel.value + 1;
                    roselia.value = roselia.value + 4;
                    
                    break;
                    
                case 2:
                    pikachu.value = pikachu.value + 4;
                    meowth.value = meowth.value + 2;
                    riolu.value = riolu.value + 1;
                    sneasel.value = sneasel.value + 3;
                    roselia.value = roselia.value + 5;
                    
                    break;
                    
                case 3:
                    pikachu.value = pikachu.value + 1;
                    meowth.value = meowth.value + 5;
                    riolu.value = riolu.value + 2;
                    sneasel.value = sneasel.value + 4;
                    roselia.value = roselia.value + 3;
                    
                    break;
        }
        Object[] q5 = { "Ignore the conversation", "Join in and talk with them", "Eavesdrop from a distance"};
        int response5 = JOptionPane.showOptionDialog(null, "You overhear your friends talking near you, what do you do?", "Question 5", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, q5, 0);
        switch (response5) {
                case 0: 
                    pikachu.value = pikachu.value + 1;
                    meowth.value = meowth.value + 4;
                    riolu.value = riolu.value + 5;
                    sneasel.value = sneasel.value + 3;
                    roselia.value = roselia.value + 2;
                    break;
                    
                case 1:
                    pikachu.value = pikachu.value + 5;
                    meowth.value = meowth.value + 3;
                    riolu.value = riolu.value + 2;
                    sneasel.value = sneasel.value + 1;
                    roselia.value = roselia.value + 4;
                    
                    break;
                    
                case 2:
                    pikachu.value = pikachu.value + 1;
                    meowth.value = meowth.value + 5;
                    riolu.value = riolu.value + 2;
                    sneasel.value = sneasel.value + 3;
                    roselia.value = roselia.value + 4;
                    
                    break;
        }
        Object[] q6 = { "Look up to see who wrote it", "Ignore the prankster", "Get mad and yell at them"};
        int response6 = JOptionPane.showOptionDialog(null, "Someone shouts 'Who wrote gullible on the ceiling??' What do you do?", "Question 6", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, q6, 0);
        switch (response6) {
                case 0: 
                    pikachu.value = pikachu.value + 5;
                    meowth.value = meowth.value + 3;
                    riolu.value = riolu.value + 1;
                    sneasel.value = sneasel.value + 4;
                    roselia.value = roselia.value + 2;
                    break;
                    
                case 1:
                    pikachu.value = pikachu.value + 1;
                    meowth.value = meowth.value + 3;
                    riolu.value = riolu.value + 5;
                    sneasel.value = sneasel.value + 2;
                    roselia.value = roselia.value + 4;
                    
                    break;
                    
                case 2:
                    pikachu.value = pikachu.value + 1;
                    meowth.value = meowth.value + 4;
                    riolu.value = riolu.value + 3;
                    sneasel.value = sneasel.value + 5;
                    roselia.value = roselia.value + 2;
                    
                    break;
        }
        Object[] q7 = { "Don't eat it. Too full", "Eat it. There's always room for dessert", "Don't eat it. Too Fattening", "FOOD!!!!" };
        int response7 = JOptionPane.showOptionDialog(null, "You just ate so much you can't move, then your mom brings out dessert, what do you do?", "Question 7", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, q7, 0);
        switch (response7) {
                case 0: 
                    pikachu.value = pikachu.value + 1;
                    meowth.value = meowth.value + 4;
                    riolu.value = riolu.value + 5;
                    sneasel.value = sneasel.value + 3;
                    roselia.value = roselia.value + 2;
                    break;
                    
                case 1:
                    pikachu.value = pikachu.value + 3;
                    meowth.value = meowth.value + 2;
                    riolu.value = riolu.value + 4;
                    sneasel.value = sneasel.value + 5;
                    roselia.value = roselia.value + 1;
                    
                    break;
                    
                case 2:
                    pikachu.value = pikachu.value + 1;
                    meowth.value = meowth.value + 4;
                    riolu.value = riolu.value + 2;
                    sneasel.value = sneasel.value + 3;
                    roselia.value = roselia.value + 5;
                    
                    break;
                    
                case 3:
                    pikachu.value = pikachu.value + 5;
                    meowth.value = meowth.value + 3;
                    riolu.value = riolu.value + 2;
                    sneasel.value = sneasel.value + 4;
                    roselia.value = roselia.value + 1;
                    
                    break;
        }
        Object[] q8 = { "Clean up", "Call 911", "Find the person who did it"};
        int response8 = JOptionPane.showOptionDialog(null, "You come back to your room and see that you got robbed, what do you do first?", "Question 8", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, q8, 0);
        switch (response8) {
                case 0: 
                    pikachu.value = pikachu.value + 2;
                    meowth.value = meowth.value + 1;
                    riolu.value = riolu.value + 3;
                    sneasel.value = sneasel.value + 4;
                    roselia.value = roselia.value + 5;
                    break;
                    
                case 1:
                    pikachu.value = pikachu.value + 5;
                    meowth.value = meowth.value + 3;
                    riolu.value = riolu.value + 2;
                    sneasel.value = sneasel.value + 1;
                    roselia.value = roselia.value + 4;
                    
                    break;
                    
                case 2:
                    pikachu.value = pikachu.value + 2;
                    meowth.value = meowth.value + 3;
                    riolu.value = riolu.value + 4;
                    sneasel.value = sneasel.value + 5;
                    roselia.value = roselia.value + 1;
                    
                    break;
        }
         //JOptionPane.showMessageDialog(null, pikachu.value + " " + meowth.value + " " + riolu.value + " " + sneasel.value + " " + roselia.value);
        if(pikachu.value >= meowth.value & pikachu.value >= riolu.value & pikachu.value >= sneasel.value & pikachu.value >= roselia.value) {
            ImageIcon icon = new ImageIcon("Pikachu.png");
            Image pikaPic = icon.getImage();
            Image scaledPikaPic = pikaPic.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
            icon = new ImageIcon(scaledPikaPic);
            JOptionPane.showMessageDialog(null, "Your result: Pikachu!", "Result!", JOptionPane.INFORMATION_MESSAGE, icon);
            player = pikachu;
        }
        else if(meowth.value >= pikachu.value & meowth.value >= riolu.value & meowth.value >= sneasel.value & meowth.value >= roselia.value) {
            ImageIcon icon = new ImageIcon("Meowth.png");
            Image meowthPic = icon.getImage();
            Image scaledmeowthPic = meowthPic.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
            icon = new ImageIcon(scaledmeowthPic);
            JOptionPane.showMessageDialog(null, "Your result: Meowth!", "Result!", JOptionPane.INFORMATION_MESSAGE, icon);
            player = meowth;
        }
        else if(riolu.value >= meowth.value & riolu.value >= pikachu.value & riolu.value >= sneasel.value & riolu.value >= roselia.value) {
            ImageIcon icon = new ImageIcon("Riolu.png");
            Image rioluPic = icon.getImage();
            Image scaledrioluPic = rioluPic.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
            icon = new ImageIcon(scaledrioluPic);
            JOptionPane.showMessageDialog(null, "Your result: Riolu!", "Result!", JOptionPane.INFORMATION_MESSAGE, icon);       
            player = riolu;
        }
        else if(sneasel.value >= meowth.value & sneasel.value >= riolu.value & sneasel.value >= pikachu.value & sneasel.value >= roselia.value) {
            ImageIcon icon = new ImageIcon("Sneasel.png");
            Image sneaselPic = icon.getImage();
            Image scaledsneaselPic = sneaselPic.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
            icon = new ImageIcon(scaledsneaselPic);
            JOptionPane.showMessageDialog(null, "Your result: Sneasel!", "Result!", JOptionPane.INFORMATION_MESSAGE, icon);
            player = sneasel;
        }
        else if(roselia.value >= meowth.value & roselia.value >= riolu.value & roselia.value >= sneasel.value & roselia.value >= pikachu.value) {
            ImageIcon icon = new ImageIcon("Roselia.png");
            Image roseliaPic = icon.getImage();
            Image scaledroseliaPic = roseliaPic.getScaledInstance(130, 100, java.awt.Image.SCALE_SMOOTH);
            icon = new ImageIcon(scaledroseliaPic);
            JOptionPane.showMessageDialog(null, "Your result: Roselia!", "Result!", JOptionPane.INFORMATION_MESSAGE, icon);
            player = roselia;
        }
        NewJFrame frame = new NewJFrame();
        frame.setVisible(true);
    }
    }
    