class DeleteMenuItem extends MenuItem {
    private final Editor editor;

    public DeleteMenuItem(Editor editor) {
        this.editor = editor;
    }

    @Override
    public void onSelect() {
        if (editor.getSelectedText().isEmpty()) {
            return;
        }

        editor.deleteSelection();

        System.out.println("Text deleted.");
    }
}
