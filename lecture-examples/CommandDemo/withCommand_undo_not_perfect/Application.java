public class Application {
    public static void main(String[] args) {
        Editor editor = new Editor();
        CommandManager manager = new CommandManager();
        Command insertCommand = new InsertCommand(editor);
        Command deleteCommand = new DeleteCommand(editor);

        Button insertButton = new Button("Insert", manager, insertCommand);
        Button deleteButton = new Button("Delete", manager, deleteCommand);
        MenuItem insertMenuItem = new MenuItem("Insert", manager, insertCommand);
        MenuItem deleteMenuItem = new MenuItem("Delete", manager, deleteCommand);

        editor.setCursorPosition(0);
        editor.setInsertionText("Hello,");
        insertButton.onClick();
        editor.setCursorPosition(editor.getText().length());
        System.out.println("Inserted: Hello,");

        editor.setSelection(0, editor.getText().length());
        deleteButton.onClick();
        System.out.println("Deleted: Hello,");

        editor.setInsertionText("Salam");
        insertMenuItem.onSelect();
        editor.setCursorPosition(editor.getText().length());
        System.out.println("Inserted: Salam");

        editor.setInsertionText(" This");
        insertButton.onClick();
        editor.setCursorPosition(editor.getText().length());
        System.out.println("Inserted: This");

        editor.setInsertionText(" is");
        insertMenuItem.onSelect();
        editor.setCursorPosition(editor.getText().length());
        System.out.println("Inserted: is");

        editor.setInsertionText(" is");
        insertButton.onClick();
        editor.setCursorPosition(editor.getText().length());
        System.out.println("Inserted: is");

        editor.setInsertionText(" SWE422");
        insertMenuItem.onSelect();
        editor.setCursorPosition(editor.getText().length());
        System.out.println("Inserted: SWE422");

        int textLength = editor.getText().length();
        editor.setSelection(textLength - "SWE422".length(), textLength);
        deleteMenuItem.onSelect();
        System.out.println("Deleted: SWE422");

        editor.setInsertionText("SWE316");
        insertButton.onClick();
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
