public class Application {
    public static void main(String[] args) {
        Editor editor = new Editor();

        Command insert = new InsertCommand(editor);
        Command delete = new DeleteCommand(editor);

        Button insertButton = new Button("Insert", insert);
        Button deleteButton = new Button("Delete", delete);
        MenuItem insertMenuItem = new MenuItem("Insert", insert);
        MenuItem deleteMenuItem = new MenuItem("Delete", delete);

        editor.setInsertionText("Hello,");
        insertButton.onClick();

        editor.setSelection(0, editor.getText().length());
        deleteButton.onClick();

        editor.setInsertionText("Salam");
        insertMenuItem.onSelect();

        editor.setInsertionText(" This");
        insertButton.onClick();

        editor.setInsertionText(" is");
        insertMenuItem.onSelect();

        editor.setInsertionText(" is");
        insertButton.onClick();

        editor.setInsertionText(" SWE422");
        insertMenuItem.onSelect();

        int textLength = editor.getText().length();
        editor.setSelection(textLength - "SWE422".length(), textLength);
        deleteMenuItem.onSelect();

        editor.setInsertionText("SWE316");
        insertButton.onClick();

        System.out.println("Final text: " + editor.getText());  
    }
}
