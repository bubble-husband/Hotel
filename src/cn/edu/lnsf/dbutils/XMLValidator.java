package cn.edu.lnsf.dbutils;

import java.io.File;
import java.io.IOException;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class XMLValidator {

	public static boolean validate(String xmlPath,String xsdPath) {
		boolean flag = false;
		String base = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		xmlPath = base + xmlPath;
		xsdPath = base + xsdPath;
		
		try {
			//����ģʽ����SchemaFactory
			SchemaFactory sf = SchemaFactory.newInstance
					("http://www.w3.org/2001/XMLSchema");
			//ͨ��XSD�ļ�����ģʽSchema
			File f = new File(xsdPath);
			Schema s = sf.newSchema(f);
			//��ģʽ������֤��Validator
			Validator v = s.newValidator();
			//ʹ����֤����֤XML�ļ�
			Source so = new StreamSource(xmlPath);
			v.validate(so);
			flag = true;
		} catch (SAXException e) {
			
			e.printStackTrace();
		}catch (IOException e) {
			System.out.println("XML�ļ���֤ʧ��....");
			e.printStackTrace();
		}
		
		return flag;
	}
	
	
	
	
}