package app;

import homeTheater.HomeTheaterFacade;

public class MovieNight {
    public static void main(String[] args) {
        HomeTheaterFacade theater = new HomeTheaterFacade();
        theater.watchMovie("Inception");
        theater.endMovie();
    }
}
