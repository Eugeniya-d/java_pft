package ru.sbtqa.pft.mypack.PointDistanceWithMethod;

public class PointDistance {
    public static void main(String[] args) {
        Point p1 = new Point(2, 3);
        Point p2 = new Point(2, 4);
        System.out.println("Расстояние между двумя точками " + "p1" + "(" + p1.x + "," + p1.y + ")" + " и p2" + "(" + p2.x + "," + p2.y + ") " + "равно " + p1.pointDistance(p2));

    }
}



