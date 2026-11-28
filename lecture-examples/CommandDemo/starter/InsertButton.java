class InsertButton extends Button {
    private final Editor editor;

    public InsertButton(Editor editor) {
        super("Insert");
        this.editor = editor;
    }

    @Override
    public void onClick() {
        String text = editor.getInsertionText();
        if (text.isEmpty()) {
            return;
        }

        editor.insertAtCursor(text);

        System.out.println("Text inserted.");
    }
}
