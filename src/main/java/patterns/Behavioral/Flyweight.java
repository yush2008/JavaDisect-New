package patterns.Behavioral;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: pratyush
 * Date: 9/12/13
 * Time: 4:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class Flyweight {

    public static void main(String[] args) {

        Rectangle rect = null;
        for(int i=0; i< 10000; i++){
           rect = RectangleFactory.getFlyWeightRectangle(getRandomColor());

        }
    }

    private static String getRandomColor() {
        return "Random Color";
    }
}


class RectangleFactory {

    static Map<String, Rectangle> cache = new HashMap<>();

    public static Rectangle getFlyWeightRectangle(String color) {

        Rectangle rect = cache.get(color);
        if (rect != null)
            return rect;
        return new Rectangle();
    }
}

class Rectangle {

    //Intrinsic
    String color;

    //Extrinsic
    String size;
}