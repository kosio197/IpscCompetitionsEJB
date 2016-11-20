package bg.softuni.model.enumeration;

public enum Discipline {
    HANDGUN("Handgun"), SHOTGUN("Shotgun"), RIFLE("Rifle");

    private String value;

    private Discipline(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Discipline fromValue(String value) {
        if (value.equals("Handgun")) {
            return HANDGUN;
        }

        if (value.equals("Shotgun")) {
            return SHOTGUN;
        }

        if (value.equals("Rifle")) {
            return RIFLE;
        }

        throw new RuntimeException("Invalid discipline!");
    }
}
