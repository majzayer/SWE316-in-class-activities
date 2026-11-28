package app;

import homeTheater.HomeTheaterFacade;

public class PhoneClient {
    public static void main(String[] args) {

        HomeTheaterFacade theater = new HomeTheaterFacade();
        theater.watchMovie("Inception");
        theater.endMovie();
    }
}
