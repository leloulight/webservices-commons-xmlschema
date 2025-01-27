package tests;

import junit.framework.TestCase;
import org.apache.ws.commons.schema.XmlSchema;
import org.apache.ws.commons.schema.XmlSchemaCollection;
import org.apache.ws.commons.schema.XmlSchemaElement;

import javax.xml.namespace.QName;
import javax.xml.transform.stream.StreamSource;
import java.io.FileInputStream;
import java.io.InputStream;
/*
 * Copyright 2004,2007 The Apache Software Foundation.
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

public class BlockTest extends TestCase {
    public void testMixedContent() throws Exception {
        QName ELEMENT_QNAME = new QName("http://soapinterop.org/xsd",
                                        "complexElt");


        InputStream is = new FileInputStream(Resources.asURI("block.xsd"));
        XmlSchemaCollection schema = new XmlSchemaCollection();
        XmlSchema s = schema.read(new StreamSource(is), null);

        XmlSchemaElement elementByName = s.getElementByName(ELEMENT_QNAME);
        assertNotNull(elementByName);

        String value = elementByName.getBlock().getValue();
        assertEquals("restriction",value);

    }
}
