package ru.stqa.pft.sandbox;

public class Point {
  public double x;
  public double y;

  public Point(double x, double y){
    this.x = x;
    this.y = y;

  }

  public double distance(Point p){
    double l = (p.x - x);
    double m = (p.y - y);
    double res = Math.sqrt((l*l) + (m*m));
    return res;
  }
}
