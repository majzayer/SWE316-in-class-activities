class DeleteButton extends Button {
    private final Editor editor;

    public DeleteButton(Editor editor) {
        super("Delete");
        this.editor = editor;
    }

    @Override
    public void onClick() {
        if (editor.getSelectedText().isEmpty()) {
            return;
        }

        editor.deleteSelection();

        System.out.println("Text deleted.");
    }
}
