class InsertCommand implements Command {
    private final Editor editor;

    public InsertCommand(Editor editor) {
        this.editor = editor;
    }

    @Override
    public void execute() {
        String text = editor.getInsertionText();
        if (text.isEmpty()) {
            return;
        }

        editor.insertAtCursor(text);

        System.out.println("Inserted: " + text.trim());
    }
}
