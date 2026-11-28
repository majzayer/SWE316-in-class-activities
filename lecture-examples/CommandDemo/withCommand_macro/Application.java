public class Application {
    public static void main(String[] args) {
        Editor editor = new Editor();
        CommandManager manager = new CommandManager();

        Button replaceButton = new Button("Replace", manager);

        editor.insert(0, "Hello world");
        editor.setCursorPosition(editor.getText().length());
        System.out.println("Initial text: " + editor.getText());

        editor.setSelection(6, 11);
        editor.setInsertionText("students");
        System.out.println("Selected text: " + editor.getSelectedText());
        System.out.println("Replacement text: " + editor.getInsertionText());

        Command replace = new MacroCommand(
            new DeleteCommand(editor),
            new InsertCommand(editor)
        );

        System.out.println("Executing macro: delete the selection, then insert the replacement.");
        replaceButton.onClick(replace);
        System.out.println("Text after replace: " + editor.getText());

        System.out.println("Undoing the macro command.");
        manager.undo();
        System.out.println("Text after undo: " + editor.getText());
    }
}
