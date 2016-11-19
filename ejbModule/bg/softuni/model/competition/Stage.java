package bg.softuni.model.competition;

public class Stage {

    private int number;
    private byte[] image;

    public Stage(int number, byte[] image) {
        super();
        this.number = number;
        this.image = image;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
