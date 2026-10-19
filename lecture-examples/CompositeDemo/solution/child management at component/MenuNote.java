public class MenuNote extends MenuComponent {
    public MenuNote(String text) {
        super(text);
    }

    @Override
    public void print() {
        System.out.println("* " + name);
    }
}