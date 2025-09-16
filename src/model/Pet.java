package model;

public class Pet {
    private String name;
    private int level;
    private int happiness;
    private int health;
    private int energy;

    // Constructor for new pet
    public Pet(String name) {
        this.name = name;
        this.level = 1;
        this.happiness = 50;
        this.health = 50;
        this.energy = 50;
    }

    // Constructor for loading pet from database
    public Pet(String name, int level, int happiness, int health, int energy) {
        this.name = name;
        this.level = level;
        this.happiness = happiness;
        this.health = health;
        this.energy = energy;
    }

    // === Getters ===
    public String getName() { return name; }
    public int getLevel() { return level; }
    public int getHappiness() { return happiness; }
    public int getHealth() { return health; }
    public int getEnergy() { return energy; }

    // === Setters ===
    public void setName(String name) { this.name = name; }
    public void setLevel(int level) { this.level = level; }
    public void setHappiness(int happiness) { this.happiness = happiness; }
    public void setHealth(int health) { this.health = health; }
    public void setEnergy(int energy) { this.energy = energy; }
}

