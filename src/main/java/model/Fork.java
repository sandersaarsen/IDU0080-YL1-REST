package model;

import org.bson.Document;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Sander
 */
public class Fork {

    private String id;
    private int length;
    private int tines;
    private String material;
    private String description;

    public Fork(String id, int length, int tines, String material, String description) {
        this.id = id;
        this.length = length;
        this.tines = tines;
        this.material = material;
        this.description = description;
    }
    
    public Fork(int length, int tines, String material, String description) {
        this.length = length;
        this.tines = tines;
        this.material = material;
        this.description = description;
    }

    @Override
    public String toString() {
        Document kahvel = new Document()
                .append("id", this.id)
                .append("pikkus", this.length)
                .append("harusid", this.tines)
                .append("materjal", this.material)
                .append("kirjeldus", this.description);
        return kahvel.toJson(); //To change body of generated methods, choose Tools | Templates.
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getTines() {
        return tines;
    }

    public void setTines(int tines) {
        this.tines = tines;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}
