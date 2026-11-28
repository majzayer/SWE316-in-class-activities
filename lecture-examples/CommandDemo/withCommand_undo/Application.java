public class Application {
    public static void main(String[] args) {
        Editor editor = new Editor();
        CommandManager manager = new CommandManager();

        Button insertButton = new Button("Insert", manager);
        Button deleteButton = new Button("Delete", manager);
        MenuItem insertMenuItem = new MenuItem("Insert", manager);
        MenuItem deleteMenuItem = new MenuItem("Delete", manager);

        editor.setCursorPosition(0);
        editor.setInsertionText("Hello,");
        insertButton.onClick(new InsertCommand(editor));
        editor.setCursorPosition(editor.getText().length());
        System.out.println("Inserted: Hello,");

        editor.setSelection(0, editor.getText().length());
        deleteButton.onClick(new DeleteCommand(editor));
        System.out.println("Deleted: Hello,");

        editor.setInsertionText("Salam");
        insertMenuItem.onSelect(new InsertCommand(editor));
        editor.setCursorPosition(editor.getText().length());
        System.out.println("Inserted: Salam");

        editor.setInsertionText(" This");
        insertButton.onClick(new InsertCommand(editor));
        editor.setCursorPosition(editor.getText().length());
        System.out.println("Inserted: This");

        editor.setInsertionText(" is");
        insertMenuItem.onSelect(new InsertCommand(editor));
        editor.setCursorPosition(editor.getText().length());
        System.out.println("Inserted: is");

        editor.setInsertionText(" is");
        insertButton.onClick(new InsertCommand(editor));
        editor.setCursorPosition(editor.getText().length());
        System.out.println("Inserted: is");

        editor.setInsertionText(" SWE422");
        insertMenuItem.onSelect(new InsertCommand(editor));
        editor.setCursorPosition(editor.getText().length());
        System.out.println("Inserted: SWE422");

        int textLength = editor.getText().length();
        editor.setSelection(textLength - "SWE422".length(), textLength);
        deleteMenuItem.onSelect(new DeleteCommand(editor));
        System.out.println("Deleted: SWE422");

        editor.setInsertionText("SWE316");
        insertButton.onClick(new InsertCommand(editor));
        System.out.println("Inserted: SWE316");

        System.out.println("Current text: " + editor.getText());

        manager.undo();
        System.out.println("After undo 1: " + editor.getText());

        manager.undo();
        System.out.println("After undo 2: " + editor.getText());

        manager.undo();
        System.out.println("After undo 3: " + editor.getText());

        manager.undo();
        System.out.println("After undo 4: " + editor.getText());
    }
}
