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

import org.apache.ws.commons.schema.constants.Constants;

/**
 * Enables any attribute from the specified namespace or namespaces
 * to appear in the containing complexType element. Represents the
 * World Wide Web Consortium (W3C) anyAttribute element.
 */
public class XmlSchemaAnyAttribute extends XmlSchemaAnnotated {

    /**
     * Creates new XmlSchemaAnyAttribute
     */
    public XmlSchemaAnyAttribute() {
        processContent = new XmlSchemaContentProcessing(
                Constants.BlockConstants.NONE);
    }

    String namespace;

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    XmlSchemaContentProcessing processContent;

    public XmlSchemaContentProcessing getProcessContent() {
        return processContent;
    }

    public void setProcessContent(XmlSchemaContentProcessing processContent) {
        this.processContent = processContent;
    }
}
