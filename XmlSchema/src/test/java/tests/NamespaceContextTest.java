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

package tests;
import org.apache.ws.commons.schema.XmlSchema;
import org.apache.ws.commons.schema.XmlSchemaCollection;
import org.apache.ws.commons.schema.utils.NamespaceMap;
import org.custommonkey.xmlunit.XMLTestCase;
import org.custommonkey.xmlunit.XMLUnit;
import org.xml.sax.InputSource;

import java.io.StringReader;
import java.io.StringWriter;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
public class NamespaceContextTest extends XMLTestCase {
    protected boolean whitespace = true;
    protected void setUp() throws Exception {
        whitespace = XMLUnit.getIgnoreWhitespace();
        XMLUnit.setIgnoreWhitespace(true);
    }
    protected void tearDown() throws java.lang.Exception {
        XMLUnit.setIgnoreWhitespace(whitespace);
    }
    public void testNamespaceContext() throws Exception {
        Map namespaceMapFromWSDL = new HashMap();
        namespaceMapFromWSDL.put("tns", new URI("http://example.org/getBalance/"));
        namespaceMapFromWSDL.put("xsd", new URI("http://www.w3.org/2001/XMLSchema"));
        String schema = "\t\t<xsd:schema targetNamespace=\"http://example.org/getBalance/\"\n" +
                "attributeFormDefault=\"unqualified\" elementFormDefault=\"unqualified\"" +
                " xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">" +
                "\t\t\t<xsd:include schemaLocation=\"getBalance.xsd\" />\n" +
                "\n" +
                "\t\t\t<xsd:element name=\"newCustomer\">\n" +
                "\t\t\t\t<xsd:complexType>\n" +
                "\t\t\t\t\t<xsd:sequence>\n" +
                "\t\t\t\t\t\t<xsd:element name=\"details\" type=\"tns:cinfoct\" />\n" +
                "\t\t\t\t\t\t<xsd:element name=\"id\" type=\"xsd:string\" />\n" +
                "\t\t\t\t\t</xsd:sequence>\n" +
                "\t\t\t\t</xsd:complexType>\n" +
                "\t\t\t</xsd:element>\n" +
                "\n" +
                "\t\t\t<xsd:element name=\"customerId\">\n" +
                "\t\t\t\t<xsd:complexType>\n" +
                "\t\t\t\t\t<xsd:sequence>\n" +
                "\t\t\t\t\t\t<xsd:element name=\"id\" type=\"xsd:string\" />\n" +
                "\t\t\t\t\t</xsd:sequence>\n" +
                "\t\t\t\t</xsd:complexType>\n" +
                "\t\t\t</xsd:element>\n" +
                "\n" +
                "\t\t</xsd:schema>";
        org.xml.sax.InputSource schemaInputSource = new InputSource(new StringReader(schema));
        XmlSchemaCollection xsc = new XmlSchemaCollection();
        xsc.setBaseUri(Resources.TEST_RESOURCES);

        //Set the namespaces explicitly
        NamespaceMap prefixmap = new NamespaceMap(namespaceMapFromWSDL);
        xsc.setNamespaceContext(prefixmap);
        XmlSchema schemaDef = xsc.read(schemaInputSource, null);
        StringWriter sw = new StringWriter();
        schemaDef.write(sw);

        assertXMLEqual(sw.toString(), schema);
    }
}
