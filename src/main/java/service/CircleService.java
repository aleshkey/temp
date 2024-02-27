package service;

import model.Circle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CircleService {

    public double getCircleSquare(Circle circle){
        return Math.PI*circle.getR()*circle.getR();
    }

    public double getCirclePerimeter(Circle circle){
        return 2*Math.PI*circle.getR();
    }

    public List<List<Circle>> getAllOnLine(List<Circle> circles){
        List<List<Circle>> res = new ArrayList<>();

        for (int i=0; i < circles.size(); i++) {
            for (int j = i + 1; j < circles.size(); j++) {
                Map<String, Double> values = solve(circles.get(i), circles.get(j));
                List<Circle> line = getLine(circles, values.get("k"), values.get("b"));
                if(line.size() > 2) {
                    res.add(line);
                }
            }
        }
        return res;
    }

    private Map<String, Double> solve(Circle c1, Circle c2){
        Map<String, Double> res = new HashMap<>();
        res.put("k", (c2.getY()-(double)c1.getY())/(c2.getX()-c1.getX()));
        res.put("b", -c1.getX()*res.get("k")+c1.getY());
        return res;
    }

    private List<Circle> getLine(List<Circle> circles, double k, double b){
        List<Circle> res = new ArrayList<>();
        for (Circle circle : circles){
            if (circle.getX() * k + b == circle.getY()){
                res.add(circle);
            }
        }
        return res;
    }

}
