class Editor {
    private final StringBuilder text = new StringBuilder();
    private int cursorPosition;
    private int selectionStart;
    private int selectionEnd;
    private String insertionText = "";

    public void insert(int position, String value) {
        text.insert(position, value);
    }

    public void delete(int position, int length) {
        text.delete(position, position + length);
        setCursorPosition(position);
    }

    public void insertAtCursor(String value) {
        insert(cursorPosition, value);
        setCursorPosition(cursorPosition + value.length());
    }

    public void deleteSelection() {
        int length = selectionEnd - selectionStart;
        if (length == 0) {
            return;
        }

        delete(selectionStart, length);
    }

    public String getText() {
        return text.toString();
    }

    public int getCursorPosition() {
        return cursorPosition;
    }

    public void setCursorPosition(int position) {
        if (position < 0 || position > text.length()) {
            throw new IndexOutOfBoundsException("Cursor position is outside the text.");
        }

        cursorPosition = position;
        selectionStart = position;
        selectionEnd = position;
    }

    public void setSelection(int start, int end) {
        if (start < 0 || end < start || end > text.length()) {
            throw new IndexOutOfBoundsException("Selection is outside the text.");
        }

        selectionStart = start;
        selectionEnd = end;
        cursorPosition = end;
    }

    public String getSelectedText() {
        return text.substring(selectionStart, selectionEnd);
    }

    public String getInsertionText() {
        return insertionText;
    }

    public void setInsertionText(String insertionText) {
        this.insertionText = insertionText;
    }
}
