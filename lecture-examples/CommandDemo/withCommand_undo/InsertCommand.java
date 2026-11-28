public class InsertCommand implements Command {
    private final Editor editor;

    private int position;
    private String insertedText;

    public InsertCommand(Editor editor) {
        this.editor = editor;
    }

    @Override
    public boolean execute() {
        position = editor.getCursorPosition();
        insertedText = editor.getInsertionText();

        if (insertedText.isEmpty()) {
            return false;
        }

        editor.insert(position, insertedText);
        return true;
    }

    @Override
    public void undo() {
        editor.delete(position, insertedText.length());
    }
}
