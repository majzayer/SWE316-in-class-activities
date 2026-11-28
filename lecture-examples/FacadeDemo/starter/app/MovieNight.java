package app;

import homeTheater.Amplifier;
import homeTheater.Lights;
import homeTheater.Player;
import homeTheater.Projector;
import homeTheater.Screen;

public class MovieNight {
    public static void main(String[] args) {
        Lights lights = new Lights();
        Screen screen = new Screen();
        Projector projector = new Projector();
        Amplifier amplifier = new Amplifier();
        Player player = new Player();

        lights.dim(10);
        screen.down();
        projector.on();
        amplifier.on();
        amplifier.setVolume(5);
        player.play("Inception");
    }
}
