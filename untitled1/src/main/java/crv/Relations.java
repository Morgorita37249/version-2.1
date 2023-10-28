package crv;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Relations extends DataBase {
    protected List<Long> vertices;   // Список вершин графа

    public Relations() {
        createGraph();
    }

    // Создание графа
    private void createGraph() {
        vertices = new ArrayList<>(UsersData.keySet());
        Collections.sort(vertices);

        // Создание ребер между вершинами
        for (int i = 0; i < vertices.size() - 1; i++) {
            Long currentVertex = vertices.get(i);
            Long nextVertex = vertices.get(i + 1);
            connectVertices(currentVertex, nextVertex);
        }
    }

    private void connectVertices(Long source, Long target) {
        System.out.println("Edge: " + source + " -> " + target);
    }
    public List<Long> getVertices() {
        return vertices;
    }
}