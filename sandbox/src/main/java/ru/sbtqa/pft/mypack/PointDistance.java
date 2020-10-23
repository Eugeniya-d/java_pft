package ru.sbtqa.pft.mypack;

public class PointDistance {
    public static void main(String[] args) {
        Point p1 = new Point(7, 12);
        p1.x = 7;
        p1.y = 12;
        Point p2 = new Point(8, 20);
        p2.x = 8;
        p2.y = 20;
        System.out.println("Расстояние между двумя точками " + "p1" + "(" + p1.x + "," + p1.y + ")" + " и p2" + "(" + p2.x + "," + p2.y + ") " + "равно " + pointDistance(p1, p2));

    }

    public static double pointDistance(Point p1,Point  p2) {
        return Math.sqrt((p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.x));
    }
}
