package ru.sbtqa.pft.mypack.PointDistanceWithMethod;

import org.testng.Assert;
import org.testng.annotations.Test;


public class PointTest {
    @Test
    public void pointDistanceTest1() {
        Point p1 = new Point(2, 3);
        Point p2 = new Point(2, 4);
        Assert.assertEquals(p1.pointDistance(p2), 1.0);
    }

    @Test
    public void pointDistanceTest2() {
        Point p1 = new Point(-12, -3);
        Point p2 = new Point(2, -4);
        Assert.assertEquals(p1.pointDistance(p2), 14.035668847618199);
    }

    @Test
    public void pointDistanceTest3() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 0);
        Assert.assertEquals(p1.pointDistance(p2), 0);
    }
}