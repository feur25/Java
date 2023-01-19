package sample.View;

import javafx.scene.image.Image;

public class TrapCard {
    private String name;
    private String Lore;
    private int position;
    private Image image;

    public TrapCard(String name, String lore, Image image) {
        this.name = name;
        this.Lore = lore;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getLore() {
        return Lore;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPosition(int i){ //0 == attacco, 1 == difesa
        position = i;
    }

    public int getPosition(){
        return position;
    }

    public Image getImage() {
        return image;
    }
}
