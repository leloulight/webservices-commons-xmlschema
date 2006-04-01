package tests;

import junit.framework.TestCase;
import org.apache.ws.commons.schema.XmlSchemaCollection;
import org.apache.ws.commons.schema.XmlSchema;
import org.apache.ws.commons.schema.XmlSchemaElement;
import org.apache.ws.commons.schema.XmlSchemaLengthFacet;
import org.apache.ws.commons.schema.XmlSchemaComplexType;
import org.apache.ws.commons.schema.XmlSchemaSequence;
import org.apache.ws.commons.schema.XmlSchemaObjectCollection;
import org.apache.ws.commons.schema.XmlSchemaType;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.namespace.QName;
import java.util.Iterator;
/*
 * Copyright 2004,2005 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

public class TestUnqualifiedSchema extends TestCase {


    public void testUnqualifiedSchemas() throws Exception {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        documentBuilderFactory.setNamespaceAware(true);
        Document doc = documentBuilderFactory.newDocumentBuilder().
                parse("test-resources/unqualifiedTypes.xsd");
        XmlSchemaCollection schemaCol = new XmlSchemaCollection();
        XmlSchema s = schemaCol.read(doc.getDocumentElement());

        assertNotNull(s);

        XmlSchemaElement e=s.getElementByName(new QName("http://soapinterop.org/xsd","complexElt") );
        XmlSchemaComplexType t  =(XmlSchemaComplexType)e.getSchemaType();
        assertNotNull(t);

        XmlSchemaSequence seq = (XmlSchemaSequence)t.getParticle();
        XmlSchemaObjectCollection items = seq.getItems();
        Iterator iterator = items.getIterator();
        while (iterator.hasNext()) {
            XmlSchemaElement elt2 = (XmlSchemaElement) iterator.next();
            System.out.println(elt2.getQName());
            XmlSchemaType schemaType2 = elt2.getSchemaType();

            assertNotNull(schemaType2);
        }



    }


}
