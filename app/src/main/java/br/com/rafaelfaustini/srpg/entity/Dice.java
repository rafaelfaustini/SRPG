package br.com.rafaelfaustini.srpg.entity;
import java.lang.Math;

public class Dice {
    private int faces;

    public Dice(int faces) {
        this.faces = faces;
    }

    public int getFaces() {
        return faces;
    }

    public void setFaces(int faces) {
        this.faces = faces;
    }

    private int random(int max){
        return (int) (Math.random()*(max-1+1)+1);
    }

    public int roll(){
        return random(faces);
    }
}
