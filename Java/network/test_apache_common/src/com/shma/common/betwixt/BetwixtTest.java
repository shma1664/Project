package com.shma.common.betwixt;

import java.beans.IntrospectionException;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import org.apache.commons.betwixt.io.BeanReader;
import org.apache.commons.betwixt.io.BeanWriter;
import org.junit.Test;
import org.xml.sax.SAXException;

public class BetwixtTest {

	@Test
	public void bean2Xml() throws IOException, SAXException, IntrospectionException {

		StringWriter sWriter = new StringWriter();
		sWriter.write("<?xml version='1.0' encoding='UTF-8' ?>\n");

		BeanWriter beanWriter = new BeanWriter(sWriter);

		beanWriter.getXMLIntrospector().getConfiguration()
				.setAttributesForPrimitives(false);
		beanWriter.getBindingConfiguration().setMapIDs(false);
		
		beanWriter.write("person", new Person("马韶华", 26));
		
		System.out.println(sWriter.toString());
		
		/**
		 * <?xml version='1.0' encoding='UTF-8' ?>
			<person>
				<age>26</age>
				<name>马韶华</name>
			</person>
		 * 
		 */
		
		sWriter.flush();
		sWriter.close();
		
	}
	
	@Test
	public void xml2Bean() {
		String xml = "<?xml version='1.0' encoding='UTF-8' ?><person><age>26</age><name>马韶华</name></person>";
		StringReader sReader = new StringReader(xml);
		
		BeanReader beanReader = new BeanReader();
		beanReader.getXMLIntrospector().getConfiguration().setAttributesForPrimitives(false);
		beanReader.getBindingConfiguration().setMapIDs(false);
		
	}
}
