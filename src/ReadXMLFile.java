import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReadXMLFile {
    public static void printNodes(NodeList nodeList) {
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (Node.ELEMENT_NODE == node.getNodeType()) {
                System.out.println("Node name: " + node.getNodeName());

                if (node.hasAttributes()) {
                    NamedNodeMap attributes = node.getAttributes();
                    for (int j = 0; j < attributes.getLength(); j++) {
                        Node attribute = attributes.item(j);
                        System.out.println("Attribute name: " + attribute.getNodeName());
                        System.out.println("Attribute value: " + attribute.getNodeValue());
                        System.out.println("Nodes values: " + node.getTextContent());
                    }
                }
                if (node.hasChildNodes()) {
                    printNodes(node.getChildNodes());
                }
            }
        }
    }
}
