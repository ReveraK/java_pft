package ru.stqa.pft.sandbox;

public class MyFirstProgram {

    public static void main(String[] args) {
        //hello("world");
        //hello("kate");
        //Square s = new Square(5);
        //System.out.println("площадь квадрата со стороной " + s.l + " = " + s.area() );
        //Rectangle r = new Rectangle(4, 5);
        //System.out.println("площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.area());

        Point p1 = new Point(2, 5);
        Point p2 = new Point(4, 8);
        System.out.println(" расстояние между двумя точками " + distance(p1, p2) );
        System.out.println(" расстояние между двумя точками " + p1.distance(p2));
    }
    public static double distance(Point p1, Point p2) {
        double l = (p2.x - p1.x);
        double m = (p2.y - p1.y);
        double res = Math.sqrt((l*l) + (m*m));
        return res;
    }
    public static void hello(String somebody) {
        System.out.println("Hello, " + somebody + "!");
    }




}