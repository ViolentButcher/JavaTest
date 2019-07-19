import java.util.List;

public class galoisLatticeTable implements galoisLattice {
    class Node {
        Concept concept;
        List<Node> parentList;
        List<Node> childrenList;
    }

    List<Node> nodeList;
}
