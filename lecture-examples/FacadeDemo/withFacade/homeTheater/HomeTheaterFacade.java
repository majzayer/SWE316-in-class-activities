package homeTheater;

public class HomeTheaterFacade {
    private final Lights lights = new Lights();
    private final Screen screen = new Screen();
    private final Projector projector = new Projector();
    private final Amplifier amplifier = new Amplifier();
    private final Player player = new Player();

    public void watchMovie(String movie) {
        lights.dim(10);
        screen.down();
        projector.on();
        amplifier.on();
        amplifier.setVolume(5);
        player.play(movie);
    }

    public void endMovie() {
        player.stop();
        amplifier.off();
        projector.off();
        screen.up();
        lights.on();
    }
}
