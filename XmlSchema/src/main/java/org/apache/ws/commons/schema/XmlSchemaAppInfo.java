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

import org.w3c.dom.NodeList;

/**
 * Defines application specific information within an annotation.
 * Represents the World Wide Web Consortium (W3C) appinfo element.
 */

// Jan 24 2002 - Joni - Change the Node into NodeList


public class XmlSchemaAppInfo extends XmlSchemaObject {

    /**
     * Provides the source of the application information.
     */
    String source;

    /**
     * Returns an array of XmlNode that represents the document text markup.
     */
    NodeList markup;

    /**
     * Creates new XmlSchemaAppInfo
     * The default constructor initializes all fields to their default values.
     */
    public XmlSchemaAppInfo() {
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public NodeList getMarkup() {
        return markup;
    }

    public void setMarkup(NodeList markup) {
        this.markup = markup;
    }
}
