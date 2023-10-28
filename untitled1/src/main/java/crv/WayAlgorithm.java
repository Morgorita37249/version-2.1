package crv;

import java.util.List;

public class WayAlgorithm extends Relations {
    public WayAlgorithm() {
        super();
    }


    public void findPath() {
        // Метод для нахождения пути между самой старшей и самой младшей вершиной
        List<Long> vertices = getVertices(); // Получаем вершины через метод
        Long youngestVertex = vertices.get(0);
        Long oldestVertex = vertices.get(vertices.size() - 1);

        int difference = calculateDifference(youngestVertex, oldestVertex);
        //System.out.println("Path between the youngest and oldest vertex: " + difference);
    }

    // Метод для вычисления разности между двумя вершинами
    public int calculateDifference(Long source, Long target) {

        return (int) (target - source);
    }

    /*public static void main(String[] args) {
        WayAlgorithm way = new WayAlgorithm();
        way.findPath();
    }*/
}