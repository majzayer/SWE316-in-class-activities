package app;

import homeTheater.Amplifier;
import homeTheater.Lights;
import homeTheater.Player;
import homeTheater.Projector;
import homeTheater.Screen;

public class PhoneClient {
    public static void main(String[] args) {
        String selectedMovie = args.length > 0 ? args[0] : "Inception";

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
        player.play(selectedMovie);
    }
}
