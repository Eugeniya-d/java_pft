package ru.sbtqa.pft.mypack;

public class PointDistanceWithMethod {
    public static void main(String[] args) {
        PointWithMethod p = new PointWithMethod(1, 3, 2, 6);
        System.out.println("Расстояние между двумя точками " + "p1" + "(" + p.x1 + "," + p.y1 + ")" + " и p2" + "(" + p.x2 + "," + p.y2 + ") " + "равно " + p.pointDistance());

    }
}



