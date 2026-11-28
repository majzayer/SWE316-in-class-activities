class DeleteCommand implements Command {
    private final Editor editor;

    public DeleteCommand(Editor editor) {
        this.editor = editor;
    }

    @Override
    public void execute() {
        String deletedText = editor.getSelectedText();
        if (deletedText.isEmpty()) {
            return;
        }

        editor.deleteSelection();

        System.out.println("Deleted: " + deletedText);
    }
}
