package GuiComponents;
import javax.swing.text.*;

class JTextFieldLimit extends PlainDocument {
    private int limit;

    JTextFieldLimit(int limit) {
        super();
        this.limit = limit;
    }

    @Override
    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
        if (str == null || str.isEmpty()) {
            return;
        }

        StringBuilder sb = new StringBuilder(getText(0, getLength()));
        sb.insert(offset, str);
        String newText = sb.toString();

        // Validate the input text
        if (isValidInput(newText) && newText.length() <= limit) {
            super.insertString(offset, str, attr);
        }
    }

    // Method to validate the input format "dd/mm/yyyy"
    private boolean isValidInput(String text) {
        // Check if the length is within the limit
        if (text.length() > limit) {
            return false;
        }

        // Ensure only digits and slashes are allowed
        for (char c : text.toCharArray()) {
            if (!Character.isDigit(c) && c != '/') {
                return false;
            }
        }

        // Check the positions of slashes
        if ((text.length() == 3 || text.length() == 6) && text.charAt(text.length() - 1) != '/') {
            return false;
        }

        // Check the position of digits to ensure "dd" and "mm" are within bounds
        if (text.length() >= 1 && text.length() <= 2) {
            String dayPart = text.substring(0, Math.min(text.length(), 2));
            return isValidDay(dayPart);
        } else if (text.length() >= 4 && text.length() <= 5) {
            String monthPart = text.substring(3, Math.min(text.length(), 5));
            return isValidMonth(monthPart);
        }

        return true;
    }

    // Method to validate the day part of the date
    private boolean isValidDay(String dayPart) {
        try {
            int day = Integer.parseInt(dayPart);
            return day >= 1 && day <= 31;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Method to validate the month part of the date
    private boolean isValidMonth(String monthPart) {
        try {
            int month = Integer.parseInt(monthPart);
            return month >= 1 && month <= 12;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
