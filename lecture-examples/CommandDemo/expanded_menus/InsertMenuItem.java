class InsertMenuItem extends MenuItem {
    private final Editor editor;

    public InsertMenuItem(Editor editor) {
        this.editor = editor;
    }

    @Override
    public void onSelect() {
        String text = editor.getInsertionText();
        if (text.isEmpty()) {
            return;
        }

        editor.insertAtCursor(text);

        System.out.println("Text inserted.");
    }
}
