package Paquete;

import java.io.File;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.TransformerFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.dom.DOMSource;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

//Aqui hacemos el proceso inverso, a partir de informacion, crear el xml
public class CrearConciertoXml {
	public static void main(String[] args) {
		DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
		DocumentBuilder analizador;
		Document doc;

		try {
			analizador = fabrica.newDocumentBuilder();
			// Creamos un documento
			doc = analizador.newDocument();
			// Añadimos el elemento raíz
			Element concierto = doc.createElement("concierto");
			doc.appendChild(concierto);
			// Añadimos al elemento raiz concierto
			aFecha(concierto, doc);
			aHora(concierto, doc);
			aParticipantes(concierto, doc);
			// Guardamos en disco el nuevo documento XML.
			guardar(doc);

			System.out.println("El archivo se ha creado con éxito");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void guardar(Document doc) throws TransformerException {

		// Fabrica de Transformes
		TransformerFactory fabricaConversor = TransformerFactory.newInstance();
		// Creamos el objeto Transfomer, que nos permitira serializar el arbol
		// dom a un fichero
		Transformer conversor = fabricaConversor.newTransformer();
		// Creamos la fuente de la cual sacaremos el arbol dom
		DOMSource fuente = new DOMSource(doc);
		// Creamos el flujo de salida, al fichero que queremos (tubito)
		StreamResult resultado = new StreamResult(new File("Concierto.xml"));
		// Por ultimo, serializamos los datos
		conversor.transform(fuente, resultado);

	}

	private static void aParticipantes(Element concierto, Document doc) {

		Element participantes = doc.createElement("participantes");
		concierto.appendChild(participantes);

		// Agregamos el primer participante
		Element participante = doc.createElement("participante");
		Element entrada = doc.createElement("entrada");
		Element grupo = doc.createElement("grupo");
		Text texto_entrada = doc.createTextNode("21:30");
		Text texto_grupo = doc.createTextNode("Las Ardillas de Dakota");
		entrada.appendChild(texto_entrada);
		grupo.appendChild(texto_grupo);
		participante.appendChild(entrada);
		participante.appendChild(grupo);
		participantes.appendChild(participante);
		// Agregamos el segundo participante
		participante = doc.createElement("participante");
		entrada = doc.createElement("entrada");
		grupo = doc.createElement("grupo");
		texto_entrada = doc.createTextNode("22:15");
		texto_grupo = doc.createTextNode("Fito y Fitipaldis");
		entrada.appendChild(texto_entrada);
		grupo.appendChild(texto_grupo);
		participante.appendChild(entrada);
		participante.appendChild(grupo);
		participantes.appendChild(participante);
		// Agregamos el tercer participante
		participante = doc.createElement("participante");
		entrada = doc.createElement("entrada");
		grupo = doc.createElement("grupo");
		texto_entrada = doc.createTextNode("23:00");
		texto_grupo = doc.createTextNode("Coldplay");
		entrada.appendChild(texto_entrada);
		grupo.appendChild(texto_grupo);
		participante.appendChild(entrada);
		participante.appendChild(grupo);
		participantes.appendChild(participante);

	}

	private static void aHora(Element concierto, Document doc) {
		// Para crear la hora de dicho concierto
		Element hora = doc.createElement("hora");
		concierto.appendChild(hora);
		Text hora_texto = doc.createTextNode("21:30");
		hora.appendChild(hora_texto);

	}

	private static void aFecha(Element concierto, Document doc) {
		//Para crear la fecha de dicho concierto
		Element fecha = doc.createElement("fecha");
		concierto.appendChild(fecha);
		Text fecha_texto = doc.createTextNode("20-oct-2018");
		fecha.appendChild(fecha_texto);

	}

}
