package com.playground.graph;


import java.util.Arrays;


public class DijkstraAlgorithm {

    public static void main(String[] args) {
        char[] vertex = {'S', 'A', 'B', 'C', 'D', 'E'};
        //邻接矩阵
        int[][] matrix = new int[vertex.length][vertex.length];
        // 表示不可以连接
        final int N = 65535;
        final char A = 'A';
        final char B = 'B';
        final char C = 'C';
        final char D = 'D';
        final char E = 'E';
        matrix[0] = new int[]{N, 3, N, N, N, 10};
        matrix[1] = new int[]{N, N, 1, 6, N, 2};
        matrix[2] = new int[]{N, N, N, N, N, N};
        matrix[3] = new int[]{3, N, 7, N, 4, N};
        matrix[4] = new int[]{N, N, N, N, N, N};
        matrix[5] = new int[]{N, N, N, 5, 7, N};

        //创建 Graph对象
        DGraph graph = new DGraph(vertex, matrix);
        //测试, 看看图的邻接矩阵是否ok
        graph.showGraph();
        //测试迪杰斯特拉算法
        graph.dijkstra(0);
        graph.showDijkstra(D);
    }
}

//已访问顶点集合
class VisitedVertex {
    //记录各个顶点是否访问，1表示访问过，0表示未访问过
    public int[] alreadyVertex;
    //表示从源点到顶点i之间的最短路径的前驱结点
    public int[] path;
    //记录从源点到其他各个顶点当前的最短路径长度
    public int[] dist;

    /**
     * 构造器
     *
     * @param vertexNum   顶点数目
     * @param vertexIndex 顶点索引（顶点数组对应的下标）
     */
    public VisitedVertex(int vertexNum, int vertexIndex) {
        this.alreadyVertex = new int[vertexNum];
        this.path = new int[vertexNum];
        this.dist = new int[vertexNum];

        // 初始化dist数组，顶点i到其他顶点的距离初始为65536，到自己的距离初始为0。
        Arrays.fill(dist, 65535);
        dist[vertexIndex] = 0;
        //初始顶点已访问
        this.alreadyVertex[vertexIndex] = 1;
    }

    /**
     * 判断该顶点是否已经访问过
     *
     * @param vertexIndex 顶点索引
     * @return
     */
    public boolean isVisited(int vertexIndex) {
        return alreadyVertex[vertexIndex] == 1;
    }

    /**
     * 更新源点到目标顶点的最短路径长度
     *
     * @param objectiveVertexIndex  目标顶点索引
     * @param objectiveVertexLength 目标顶点长度
     */
    public void updateDist(int objectiveVertexIndex, int objectiveVertexLength) {
        dist[objectiveVertexIndex] = objectiveVertexLength;
    }

    /**
     * 更新源点到该顶点最短路径下，该顶点的前驱顶点
     *
     * @param preVertexIndex 前驱顶点
     * @param VertexIndex    该顶点
     */
    public void updatePath(int VertexIndex, int preVertexIndex) {
        path[VertexIndex] = preVertexIndex;
    }

    /**
     * 返回源点到该顶点的上一次更新的最短路径
     * 用于判断此次是否更新最短路径长度
     *
     * @param vertexIndex
     * @return
     */
    public int getDist(int vertexIndex) {
        return dist[vertexIndex];
    }

    /**
     * 寻找与源点之间最短距离且未访问顶点的索引
     *
     * @return
     */
    public int updateArr() {
        int min = 65536, index = 0;
        for (int i = 0; i < alreadyVertex.length; i++) {
            if (alreadyVertex[i] == 0 && dist[i] < min) {
                min = dist[i];
                index = i;
            }
        }
        alreadyVertex[index] = 1;
        return index;
    }

    public void show(char [] vertexes, char end) {
        System.out.println("===================");
        char begin = vertexes[0];
        int beginIndex = 0;
        int endIndex = 0;
        for (int i = 0; i < vertexes.length; i++) {
            if (vertexes[i] == begin) {
                beginIndex = i;
            }
            if (vertexes[i] == end) {
                endIndex = i;
            }
        }

        System.out.println(begin + " -> " + end + "的最短距离为：" + dist[endIndex]);
        System.out.print(begin + " -> " + end + "的最短路径为：");
        showPath(vertexes, beginIndex, endIndex);
        System.out.println(vertexes[endIndex]);


    }

    /**
     * 通过递归遍历先驱数组path返回最短路径
     *
     * @param beginIndex
     * @param endIndex
     */
    private void showPath(char [] vertexes, int beginIndex, int endIndex) {
        if (path[endIndex] == beginIndex) {
            System.out.print(vertexes[beginIndex] + " -> ");
            return;
        } else {
            showPath(vertexes, beginIndex, path[endIndex]);
        }
        System.out.print(vertexes[path[endIndex]] + " -> ");
    }

}

class DGraph {
    //顶点数组
    private char[] vertex;
    //邻接矩阵
    private int[][] arcs;
    private VisitedVertex visitedVertex;

    public DGraph(char[] vertex, int[][] arcs) {
        this.vertex = vertex;
        this.arcs = arcs;
    }

    public void showGraph() {
        for (int[] link : arcs) {
            System.out.println(Arrays.toString(link));
        }
    }

    /**
     * dijkstra算法
     *
     * @param index 出发顶点的下标
     */
    public void dijkstra(int index) {
        visitedVertex = new VisitedVertex(vertex.length, index);
        update(index);
        for (int i = 1; i < vertex.length; i++) {
            index = visitedVertex.updateArr();
            update(index);
        }
    }

    // 更新index下标顶点到周围顶点的距离和周围顶点的前驱顶点
    public void update(int index) {
        int len = 0;
        //根据邻接矩阵找到邻接顶点
        for (int i = 0; i < arcs[index].length; i++) {
            //从出发顶点到index顶点的距离+ 从index顶点到i顶点的距离的和
            int currentDist = visitedVertex.getDist(index);
            int currentArc = arcs[index][i];
            len = currentDist + currentArc;
            if (!visitedVertex.isVisited(i) && len < visitedVertex.getDist(i)) {
                visitedVertex.updatePath(i, index);// 更新前驱顶点
                visitedVertex.updateDist(i, len); // 更新最短距离
            }
        }
    }

    public void showDijkstra(char end) {
        visitedVertex.show(this.vertex, end);
    }
}
