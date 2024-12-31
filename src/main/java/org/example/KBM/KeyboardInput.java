package org.example.KBM;

import org.example.GamePanel;
import org.example.Organism;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;

public class KeyboardInput implements KeyListener {
    Organism org;
    public KeyboardInput(Organism org){
        this.org = org;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
