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

import javax.xml.namespace.QName;


/**
 * Class for the union of simpleType elements. Defines a simpleType element
 * as a list of values of a specified data type. Represents the World
 * Wide Web Consortium (W3C) union element.
 */

public class XmlSchemaSimpleTypeUnion extends XmlSchemaSimpleTypeContent {

    XmlSchemaObjectCollection baseTypes;
    String memberTypesSource;
    QName[] memberTypesQNames;

    public XmlSchemaSimpleTypeUnion() {
        baseTypes = new XmlSchemaObjectCollection();
    }

    public XmlSchemaObjectCollection getBaseTypes() {
        return this.baseTypes;
    }

    public void setMemberTypesSource(String memberTypesSources) {
        this.memberTypesSource = memberTypesSources;
    }

    public String getMemberTypesSource() {
        return this.memberTypesSource;
    }

    public QName[] getMemberTypesQNames() {
        return this.memberTypesQNames;
    }

}
