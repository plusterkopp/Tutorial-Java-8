package de.icubic.tutorial.java8.c6.Streams_9_NonInterfering;

import static java.lang.System.*;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Application {

	public static void main(String[] args) {
		{
			out.println("---------------------------------");
			List<Point> points = new ArrayList<>();
			points.add(new Point(1, 1));
			points.add(new Point(2, 2));
//			points.stream().forEach(point -> points.add(new Point(0, 0)));
			// ConcurrentModificationException
		}
		{
			out.println("---------------------------------");
			List<Point> points = new ArrayList<>();
			points.add(new Point(1, 1));
			points.add(new Point(2, 2));
			points.stream().forEach(point -> point.x += 1);
			points.stream().forEach(point -> out.println(point));
		}

	}
}
