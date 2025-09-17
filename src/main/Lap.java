package main;

public class Lap {
    private String leiras;

    public Lap(String leiras) {
        this.leiras = leiras;
    }

    public String getLeiras() {
        return leiras;
    }

    @Override
    public String toString() {
        return leiras;
    }
}
