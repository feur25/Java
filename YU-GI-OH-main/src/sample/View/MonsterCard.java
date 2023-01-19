package sample.View;

import javafx.scene.image.Image;

public class MonsterCard {
    private String name;
    private int level;
    private int attack;
    private int defence;
    private String information;
    private int position;
    private String type;
    private String element;
    private String numberCard;
    private boolean oneTap;
    private Image image;

    public MonsterCard(String name, int level, int attack, int defence, String info, String type, String element, String numberCard, boolean oneTap, Image image) {
        this.name = name;
        this.level = level;
        this.attack = attack;
        this.defence = defence;
        this.image = image;
        this.information = info;
        this.type = type;
        this.element = element;
        this.numberCard = numberCard;
        this.oneTap = oneTap;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefence() {
        return defence;
    }
    public boolean getOneTap() {
        return oneTap;
    }

    public void setOneTap(boolean oneTap) {
        this.oneTap = oneTap;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public void setPosition(int i){ //0 == attacco, 1 == difesa
        position = i;
    }
    public String getInformation(){
        return information;
    }

    public int getPosition(){
        return position;
    }

    public Image getImage() {
        return image;
    }
}
