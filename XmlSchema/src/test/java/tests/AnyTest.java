package tests;

import junit.framework.TestCase;
import org.apache.ws.commons.schema.*;

import javax.xml.namespace.QName;
import javax.xml.transform.stream.StreamSource;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

/*
 * Copyright 2004,2007 The Apache Software Foundation.
 * Copyright 2006 International Business Machines Corp.
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
 *
 */
public class AnyTest extends TestCase {

    /**
     * This method will test the any.
     *
     * @throws Exception Any exception encountered
     */
    public void testAny() throws Exception {

        /*
         <schema xmlns="http://www.w3.org/2001/XMLSchema"
                 xmlns:xsd="http://www.w3.org/2001/XMLSchema"
                 xmlns:tns="http://soapinterop.org/types"
                 targetNamespace="http://soapinterop.org/types"
                 elementFormDefault="qualified">

           <element name="department">
             <complexType>
               <sequence>
                 <element name="id" type="xsd:integer"/>
                 <element name="name" type="xsd:string"/>
                 <any minOccurs="5" maxOccurs="10"/>
               </sequence>
             </complexType>
           </element>

         </schema>
        */

        QName ELEMENT_QNAME = new QName("http://soapinterop.org/types",
                                        "department");
        InputStream is = new FileInputStream(Resources.asURI("any.xsd"));
        XmlSchemaCollection schemaCol = new XmlSchemaCollection();
        XmlSchema schema = schemaCol.read(new StreamSource(is), null);

        XmlSchemaElement elem = schemaCol.getElementByQName(ELEMENT_QNAME);
        assertNotNull(elem);
        assertEquals("department", elem.getName());
        assertEquals(new QName("http://soapinterop.org/types", "department"),
                     elem.getQName());

        XmlSchemaComplexType type =
            (XmlSchemaComplexType)elem.getSchemaType();
        assertNotNull(type);
        
        XmlSchemaSequence xss = (XmlSchemaSequence)type.getParticle();
        assertNotNull(xss);

        XmlSchemaObjectCollection c = xss.getItems();
        assertEquals(3, c.getCount());

        Set s = new HashSet();
        s.add("id");
        s.add("name");
        Object o = null;
        for (int i = 0; i < c.getCount(); i++) {
            o = c.getItem(i);
            if (o instanceof XmlSchemaElement) {
                String name = ((XmlSchemaElement)o).getName();
                if (name.equals("id")) {
                    assertEquals(new QName("http://www.w3.org/2001/XMLSchema",
                                           "integer"),
                                 ((XmlSchemaElement)o).getSchemaTypeName());
                } else if (name.equals("name")) {
                    assertEquals(new QName("http://www.w3.org/2001/XMLSchema",
                                           "string"),
                                 ((XmlSchemaElement)o).getSchemaTypeName());
                }
                s.remove(name);
            } else if (o instanceof XmlSchemaAny) {
                XmlSchemaContentProcessing xscp =
                    ((XmlSchemaAny)o).getProcessContent();
                assertEquals("none", xscp.toString());
                assertEquals(5L, ((XmlSchemaAny)o).getMinOccurs());
                assertEquals(10L, ((XmlSchemaAny)o).getMaxOccurs());
            }
        }
        
        assertTrue("The set should have been empty, but instead contained: "
                   + s + ".",
                   s.isEmpty());

    }

}