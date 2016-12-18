package Task1;

/*
 * Дан массив точек. Каждая точка характеризуется координатами х, у
 *  и названием точки. Сортировать точки в массиве по возрастанию 
 *  удаления расстояния точки от начала координат и вывести их на экран

 */
public class Point {
	public static void main(String[] args) {
		final int quantity = 10;
		Point[] points = GeneratorPoint(quantity);
		double[] distance = pointDistance(points);
		sort(distance, points);
		print(points);
	}

	static int quantity;
	private String pointName;
	private int x;
	private int y;

	public Point(String pointName, int x, int y) {
		super();
		this.pointName = pointName;
		this.x = x;
		this.y = y;
	}

	public String getPointName() {
		return pointName;
	}

	public void setPointName(String pointName) {
		this.pointName = pointName;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	/*
	 * Метод GeneratorPoint создает массив точек, количеством quantity
	 */
	public static Point[] GeneratorPoint(int quantity) {
		Point[] arrPoints = new Point[quantity];
		for (int i = 0; i < arrPoints.length; i++) {
			arrPoints[i] = new Point("point" + (i + 1), 
			(int) (Math.random() * 40), (int) (Math.random() * 40));

		}
		return arrPoints;
	}
	/*
	 * Метод sort сортирует массив точек по увеличению расстояния между ними.
	 */

	public static void sort(double[] distance, Point[] Point) {
		for (int i = distance.length - 1; i > 0; --i) {
			for (int j = 0; j < i; ++j) {
				if (distance[j] > distance[j + 1]) {
					double temp = distance[j];
					distance[j] = distance[j + 1];
					distance[j + 1] = temp;

					Point temp1 = Point[j];
					Point[j] = Point[j + 1];
					Point[j + 1] = temp1;

				}
			}
		}

	}

	static double[] pointDistance(Point[] points) {
		double[] distance = new double[points.length];

		for (int i = 0; i < points.length; i++) {
			distance[i] = (int) Math.sqrt(points[i].getX() *
			points[i].getX() + points[i].getY() * points[i].getY());
		}
		return distance;
	}

	public static String toString(Point Point) {
		StringBuilder sb = new StringBuilder();
		sb.append(Point.getPointName()).append(" - ").append
		(Point.getX()).append(',').append(Point.getY());
		return sb.toString();
	}

	public static void print(Point[] Point) {
		for (int i = 0; i < Point.length; ++i) {
			Point pointResult = Point[i];
			String pointInString = toString(pointResult);
			System.out.printf("%d. %s%n", i + 1, pointInString);
		}

	}

}
