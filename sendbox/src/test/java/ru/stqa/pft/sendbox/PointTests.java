package ru.stqa.pft.sendbox;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.sandbox.Point;

public class PointTests {

  @Test
  public void test1Point() {
    Point a = new Point(2,7);
    Point b = new Point(6,3);
    double res = a.distance(b);
    Assert.assertNotEquals(res, 1);

  }

  @Test
  public void test2Point() {
    Point a = new Point(5,7);
    Point b = new Point(6,8);
    double res = a.distance(b);
    Assert.assertEquals(res, 1.4142135623730951 );
  }

  @Test
  public void test3Point() {
    Point a = new Point(5,5);
    Point b = new Point(5,6);
    double res = a.distance(b);
    Assert.assertEquals(res, 1.0 );
  }

}
