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
package tests.customext.elt;

import junit.framework.TestCase;
import org.apache.ws.commons.schema.XmlSchema;
import org.apache.ws.commons.schema.XmlSchemaCollection;
import org.apache.ws.commons.schema.XmlSchemaElement;
import org.apache.ws.commons.schema.constants.Constants;
import org.w3c.dom.Document;
import tests.Resources;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import java.util.Map;

/**
 *  Test class to run through the full cycle of build-serialize-build-check
 */
public class CustomExtElementSerializerTest extends TestCase {


    public void testSerialization() throws Exception {
        //set the system property for the custom extension registry
        System.setProperty(Constants.SystemConstants.EXTENSION_REGISTRY_KEY,
                CustomExtensionRegistry.class.getName());

        //create a DOM document
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        documentBuilderFactory.setNamespaceAware(true);
        Document doc = documentBuilderFactory.newDocumentBuilder().
                parse(Resources.asURI("/external/externalElementAnnotations.xsd"));

        XmlSchemaCollection schemaCol = new XmlSchemaCollection();
        XmlSchema schema = schemaCol.read(doc,null);
        assertNotNull(schema);

        //now serialize it to a byte stream
        //and build a new document out of it
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        schema.write(baos);
        Document doc2 = documentBuilderFactory.newDocumentBuilder().
                parse(new ByteArrayInputStream(baos.toByteArray()));

        schema = schemaCol.read(doc2,null);
        assertNotNull(schema);

        // get the elements and check whether their annotations are properly
        // populated
        Iterator values = schema.getElements().getValues();
        while (values.hasNext()) {
            XmlSchemaElement elt =  (XmlSchemaElement) values.next();
            assertNotNull(elt);
            Map metaInfoMap = elt.getMetaInfoMap();
            assertNotNull(metaInfoMap);

            CustomElement customElt = (CustomElement)metaInfoMap.get(CustomElement.CUSTOM_ELT_QNAME);
            assertNotNull(customElt);

        }

        //remove our system property
        System.getProperties().remove(Constants.SystemConstants.EXTENSION_REGISTRY_KEY);

    }
}
