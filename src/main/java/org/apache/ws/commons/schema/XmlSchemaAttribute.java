/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.ws.commons.schema;

import javax.xml.namespace.QName;

/**
 * Class for attribute types. Represents the World Wide Web Consortium (W3C) attribute element.
 */

// October 15th - momo - initial implementation
public class XmlSchemaAttribute extends XmlSchemaNamed {

    Object attributeType;
    String defaultValue;
    String fixedValue;
    XmlSchemaForm form;
    XmlSchemaSimpleType schemaType;
    QName schemaTypeName;
    QName refName;
    XmlSchemaUse use;

    /**
     * Create a new attribute.
     * @param schema containing scheme.
     * @param topLevel true if a global attribute.
     */
    public XmlSchemaAttribute(XmlSchema schema, boolean topLevel) {
        super(schema, topLevel);
        form = XmlSchemaForm.NONE;
        use = XmlSchemaUse.NONE;
    }

    public Object getAttributeType() {
        return attributeType;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getFixedValue() {
        return fixedValue;
    }

    public void setFixedValue(String fixedValue) {
        this.fixedValue = fixedValue;
    }

    public XmlSchemaForm getForm() {
        return form;
    }

    public void setSchemaForm(XmlSchemaForm formValue) {
        this.form = formValue;
    }

    public QName getRefName() {
        return refName;
    }

    public void setRefName(QName refName) {
        this.refName = refName;
    }

    public XmlSchemaSimpleType getSchemaType() {
        return schemaType;
    }

    public void setSchemaType(XmlSchemaSimpleType schemaType) {
        this.schemaType = schemaType;
    }

    public QName getSchemaTypeName() {
        return schemaTypeName;
    }

    public void setSchemaTypeName(QName schemaTypeName) {
        this.schemaTypeName = schemaTypeName;
    }

    public XmlSchemaUse getUse() {
        return use;
    }

    public void setUse(XmlSchemaUse use) {
        this.use = use;
    }

    public String toString(String aprefix, int tab) {
        String prefix = aprefix;
        String xml = new String();

        if (!"".equals(prefix) && prefix.indexOf(":") == -1) {
            prefix += ":";
        }

        for (int i = 0; i < tab; i++) {
            xml += "\t";
        }

        xml += "<" + prefix + "attribute name=\"" 
            + getName() + "\" type=\"" + schemaTypeName + "\"/>\n";

        return xml;
    }
}
