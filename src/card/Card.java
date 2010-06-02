package card;

public abstract class Card {

    public int id;
    public int cost;
    public String name;
    public String imagePath;

    public int getId() {
        return id;
    }

    public int getCost(){
        return cost;
    }

    public String getName() {
        return name;
    }

    public String getImagePath() {
        return imagePath;
    }
}
