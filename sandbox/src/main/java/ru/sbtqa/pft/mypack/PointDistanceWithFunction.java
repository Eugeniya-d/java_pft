package ru.sbtqa.pft.mypack;

public class PointDistanceWithFunction {
    public static void main(String[] args) {
        PointWithFunction p1 = new PointWithFunction(7, 12);
        p1.x = 7;
        p1.y = 12;
        PointWithFunction p2 = new PointWithFunction(8, 20);
        p2.x = 8;
        p2.y = 20;
        System.out.println("Расстояние между двумя точками " + "p1" + "(" + p1.x + "," + p1.y + ")" + " и p2" + "(" + p2.x + "," + p2.y + ") " + "равно " + pointDistance(p1, p2));

    }

    public static double pointDistance(PointWithFunction p1, PointWithFunction p2) {
        return Math.sqrt((p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.x));
    }
}
