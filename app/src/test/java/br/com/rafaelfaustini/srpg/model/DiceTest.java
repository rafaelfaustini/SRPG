package br.com.rafaelfaustini.srpg.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DiceTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getFaces() {
        Dice d = new Dice(5);
        assertEquals(5, d.getFaces());
        d = new Dice(2);
        assertEquals(2, d.getFaces());
    }

    @Test
    void setFaces() {
        Dice d = new Dice(1);
        d.setFaces(7);
        assertEquals(7, d.getFaces());
        d = new Dice(8);
        assertEquals(8, d.getFaces());
    }

    @Test
    void roll() {
        Dice d = new Dice(10);
        List<Integer> rolls = new ArrayList<Integer>();
        for(int i =0; i< 100; i++){
            rolls.add(d.roll());
        }
        Collections.sort(rolls);
        int min = rolls.get(0);
        assertEquals(1, min);
        int max = rolls.get(rolls.size()-1);
        assertEquals(10, max);
    }
}