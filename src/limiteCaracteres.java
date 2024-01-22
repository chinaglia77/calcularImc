import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class limiteCaracteres extends PlainDocument{
    private int maxLength;

    public limiteCaracteres(int maxLength) {
        super();
        this.maxLength = maxLength;
    }

    @Override
    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
        if (str == null) return;

        if ((getLength() + str.length()) <= maxLength) {
            super.insertString(offset, str, attr);
        }
    }
}
