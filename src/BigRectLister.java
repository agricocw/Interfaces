import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class BigRectLister {
    public static void main(String[] args) {
        List<Rectangle> rectangles = createRectangles();
        List<Rectangle> bigRectangles = collectAll(rectangles, new BigRectangleFilter());
        System.out.println("Big rectangles:");
        for (Rectangle rectangle : bigRectangles) {
            System.out.println(rectangleToString(rectangle));
        }
    }

    public static List<Rectangle> createRectangles() {
        List<Rectangle> rectangles = new ArrayList<>();
        rectangles.add(new Rectangle(3, 4)); // perimeter = 14
        rectangles.add(new Rectangle(5, 3)); // perimeter = 16
        rectangles.add(new Rectangle(2, 5)); // perimeter = 14
        rectangles.add(new Rectangle(6, 2)); // perimeter = 16
        rectangles.add(new Rectangle(1, 10)); // perimeter = 22
        rectangles.add(new Rectangle(4, 7)); // perimeter = 22
        rectangles.add(new Rectangle(8, 1)); // perimeter = 18
        rectangles.add(new Rectangle(9, 1)); // perimeter = 20
        rectangles.add(new Rectangle(2, 8)); // perimeter = 20
        rectangles.add(new Rectangle(3, 6)); // perimeter = 18
        return rectangles;
    }

    public static List<Rectangle> collectAll(List<Rectangle> rectangles, Filter filter) {
        List<Rectangle> result = new ArrayList<>();
        for (Rectangle rectangle : rectangles) {
            if (filter.accept(rectangle)) {
                result.add(rectangle);
            }
        }
        return result;
    }

    public static String rectangleToString(Rectangle rectangle) {
        return "Rectangle[width=" + rectangle.getWidth() + ", height=" + rectangle.getHeight() + "]";
    }
}
