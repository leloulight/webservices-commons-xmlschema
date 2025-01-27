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

package org.apache.ws.commons.schema;

/**
 * Class for defining pattern facets. Represents the World Wide
 * Web Consortium (W3C) pattern facet.
 */

public class XmlSchemaPatternFacet extends XmlSchemaFacet {

    /**
     * Creates new XmlSchemaPatternFacet
     */
    public XmlSchemaPatternFacet() {
    }

    public XmlSchemaPatternFacet(Object value, boolean fixed) {
        super(value, fixed);
    }

    public String toString(String prefix, int tab) {
        StringBuffer xml = new StringBuffer();
        for (int i = 0; i < tab; i++) {
            xml.append("\t");
        }
        xml.append("<pattern value=\"").append(super.getValue()).append("\" ");
        xml.append("fixed=\"").append(super.isFixed()).append("\"/>\n");
        return xml.toString();
    }

}
