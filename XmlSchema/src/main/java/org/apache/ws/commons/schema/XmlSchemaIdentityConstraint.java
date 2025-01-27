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
 * Class for the identity constraints: key, keyref, and unique elements.
 */

public class XmlSchemaIdentityConstraint extends XmlSchemaAnnotated {

    /**
     * Creates new XmlSchemaIdentityConstraint
     */
    public XmlSchemaIdentityConstraint() {
        fields = new XmlSchemaObjectCollection();
    }

    XmlSchemaObjectCollection fields;

    public XmlSchemaObjectCollection getFields() {
        return fields;
    }

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    XmlSchemaXPath selector;

    public XmlSchemaXPath getSelector() {
        return selector;
    }

    public void setSelector(XmlSchemaXPath selector) {
        this.selector = selector;
    }


}
