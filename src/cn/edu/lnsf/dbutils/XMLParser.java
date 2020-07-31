package cn.edu.lnsf.dbutils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class XMLParser {

	public static HashMap<String , String> parser(String xmlPath){
		HashMap<String , String> hm = new HashMap<String , String>();
		
		String base = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		xmlPath = base + xmlPath;
		try {
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser sp = spf.newSAXParser();
			File f = new File(xmlPath);
			XMLHandler xh = new XMLHandler();
			sp.parse(f, xh);
			hm = xh.getHashMap();

		} catch (ParserConfigurationException | SAXException e) {
			
			e.printStackTrace();
		}catch (IOException e) {
			
			e.printStackTrace();
		}
		return hm;
	}
}
