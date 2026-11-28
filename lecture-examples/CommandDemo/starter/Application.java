public class Application {
    public static void main(String[] args) {
        Editor editor = new Editor();
        
        Button insertButton = new InsertButton(editor);
        Button deleteButton = new DeleteButton(editor);

        editor.setInsertionText("Hello");

        insertButton.onClick();  // Editor contains "Hello"
        editor.setSelection(0, 5);
        deleteButton.onClick();  // Editor is empty
    }
}
