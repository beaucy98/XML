package Paquete;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class LeerXml {
	public static void main(String[] args) {
		DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
		DocumentBuilder analizador;
		Document doc;
		Node raiz;

		try {
			analizador = fabrica.newDocumentBuilder();
			doc = analizador.parse("Concierto.xml");
			raiz = doc.getDocumentElement();
			recorrerNodos(raiz);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void recorrerNodos(Node raiz) {

		NodeList nodos = raiz.getChildNodes();

		for (int i = 0; i < nodos.getLength(); i++) {

			Node nodoHijo = nodos.item(i);

		}
	}
}
