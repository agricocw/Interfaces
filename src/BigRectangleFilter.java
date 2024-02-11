import java.awt.Rectangle;

public class BigRectangleFilter implements Filter {
    @Override
    public boolean accept(Object x) {
        if (!(x instanceof Rectangle)) {
            return false;
        }
        Rectangle rectangle = (Rectangle) x;
        return (2 * (rectangle.getWidth() + rectangle.getHeight())) > 10;
    }
}