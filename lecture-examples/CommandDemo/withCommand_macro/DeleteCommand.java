public class DeleteCommand implements Command {
    private final Editor editor;

    private int position;
    private String deletedText;

    public DeleteCommand(Editor editor) {
        this.editor = editor;
    }

    @Override
    public boolean execute() {
        String selectedText = editor.getSelectedText();
        int length = selectedText.length();

        if (length <= 0) {
            return false;
        }

        position = editor.getCursorPosition() - length;
        deletedText = selectedText;
        editor.delete(position, length);
        return true;
    }

    @Override
    public void undo() {
        editor.insert(position, deletedText);
    }
}
