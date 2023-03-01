package ru.stqa.pft.sendbox;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.sandbox.Point;

public class PointTests {

  double res;
  public PointTests() {

    Point a = new Point(5,7);
    Point b = new Point(6,8);
    res = a.distance(b);
    System.out.println(" расстояние между двумя точками " + res);
  }

  @Test
  public void test1Point() {

    Assert.assertEquals(res, 1);

  }

  @Test
  public void test2Point() {

    Assert.assertEquals(res, 1.4142135623730951 );
  }

  @Test
  public void test3Point() {

    assert res > 0;
  }
}
