import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Godin {
    public List<String> objectName = new ArrayList<String>();
    public List<String> attributeName = new ArrayList<String>();
    public List<List<Boolean>> relationship = new ArrayList<List<Boolean>>();

    public Godin(String dataSource) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(new File(dataSource))));
            String[] objectNameArray = br.readLine().split(",");
            Collections.addAll(objectName, objectNameArray);
            String[] attributeNameArray = br.readLine().split(",");
            Collections.addAll(attributeName, attributeNameArray);
            while (true) {
                String line = br.readLine();
                if (line == null) break;
                List<Boolean> relationshipOfOneObject = new ArrayList<Boolean>();
                String[] relationshipOfOneObjectArray = line.split(",");
                for (int i = 0; i < relationshipOfOneObjectArray.length; i++) {
                    relationshipOfOneObject.add(relationshipOfOneObjectArray[i].equals("1"));
                }
                relationship.add(relationshipOfOneObject);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void displayRelationship() {
        for (String element: objectName) {
            System.out.print(element + " ");
        }
        System.out.println();
        for (String element: attributeName) {
            System.out.print(element + " ");
        }
        System.out.println();
        for (List<Boolean> line: relationship) {
            for (Boolean element: line) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
