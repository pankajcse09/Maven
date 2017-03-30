package com.pankaj.coder.utility;

import java.io.InputStream;
import java.io.InputStream;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XmlReaderUtils {

	public static final Logger logger = LoggerFactory.getLogger(XmlReaderUtils.class);

	public static void main(String[] args) {
		System.out.println(getQuery("queryTwo"));
	}
	public static String getQuery(String id) {
		String queryFileName = "sqlQuery.xml";
		return getElement(id, getStreamReader(queryFileName));
	}

	public static String getQuery(String id, String queryFileName) throws Exception {

		if (id == null || "".equals(id) || queryFileName == null || "".equals(queryFileName))
			throw new Exception("Any of parameter passed in getQuery method is either null or empty string");

		String query = getElement(id, getStreamReader(queryFileName));

		return query.trim();
	}

	private static XMLStreamReader getStreamReader(String fileName) {
		XMLInputFactory xmlif = null;
		XMLStreamReader xmlr = null;

		try {

			xmlif = XMLInputFactory.newInstance();
			xmlif.setProperty(XMLInputFactory.IS_REPLACING_ENTITY_REFERENCES, Boolean.TRUE);
			xmlif.setProperty(XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES, Boolean.FALSE);
			xmlif.setProperty(XMLInputFactory.IS_COALESCING, Boolean.FALSE);
			InputStream fileInput = XmlReaderUtils.class.getClassLoader().getResourceAsStream(fileName);
			xmlr = xmlif.createXMLStreamReader(fileName, fileInput);

		} catch (Exception ex) {
			logger.error(" Exception Caught in XmlReader:getStreamReader() : " + ex);
		}
		return xmlr;
	}

	private static String getElement(String id, XMLStreamReader xmlr) {
		int eventType;
		StringBuilder msg = new StringBuilder("");

		try {
			while (xmlr.hasNext()) {
				eventType = xmlr.next();

				if ((eventType == XMLEvent.START_ELEMENT) && (xmlr.getName().toString().equals("message"))
						&& (id.equals(getAttributeValue(xmlr)))) {
					while (xmlr.next() == XMLEvent.CHARACTERS) {
						msg.append(xmlr.getText());
					}

				}
				xmlr.close();
			}
		} catch (XMLStreamException xse) {
			logger.error(" XMLStreamException Caught in XmlReader:getStreamReader() : " + xse);
		}

		return msg.toString();
	}

	private static String getAttributeValue(XMLStreamReader xmlr) {
		int count = xmlr.getAttributeCount();
		String value = null;
		if (count > 0) {
			for (int i = 0; i < count; i++) {
				value = xmlr.getAttributeValue(i);
			}
		}
		return value;
	}
}
