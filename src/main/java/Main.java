import model.Circle;
import service.CircleService;

import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        List<Circle> circles = new ArrayList<>();
        CircleService circleService = new CircleService();
        for (int i = 0; i < 50; i++){
            Circle circle = new Circle();
            circle.setR((int) (Math.random()*50));
            circle.setX((int) (Math.random()*50));
            circle.setY((int) (Math.random()*50));
            circles.add(circle);
            System.out.println(circle);
        }
        var lines = circleService.getAllOnLine(circles);
        System.out.println(lines);
    }

}
