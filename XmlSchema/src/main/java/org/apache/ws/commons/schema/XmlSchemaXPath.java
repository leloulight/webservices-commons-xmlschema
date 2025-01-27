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
 * Class for XML Path Language (XPath) expressions. Represents the
 * World Wide Web Consortium (W3C) selector element. The World Wide
 * Web Consortium (W3C) field element is a collection of
 * XmlSchemaXPath classes.
 */

public class XmlSchemaXPath extends XmlSchemaAnnotated {

    /**
     * Creates new XmlSchemaXPath
     */
    public XmlSchemaXPath() {
    }

    String xpath;

    public String getXPath() {
        return xpath;
    }

    public void setXPath(String xpath) {
        this.xpath = xpath;
    }
}
