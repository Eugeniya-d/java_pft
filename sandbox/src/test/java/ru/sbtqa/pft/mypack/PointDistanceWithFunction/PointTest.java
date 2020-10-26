package ru.sbtqa.pft.mypack.PointDistanceWithFunction;

import org.testng.Assert;
import org.testng.annotations.Test;

import static ru.sbtqa.pft.mypack.PointDistanceWithFunction.PointDistance.pointDistance;


public class PointTest{
    @Test
    public void pointDistanceTest() {
        Point p1 = new Point(7, 12);
        p1.x = 5;
        p1.y = 12;
        Point p2 = new Point(8, 20);
        p2.x = 9;
        p2.y = 20;
        Assert.assertEquals(pointDistance(p1, p2),11.661903789690601);
    }
}
