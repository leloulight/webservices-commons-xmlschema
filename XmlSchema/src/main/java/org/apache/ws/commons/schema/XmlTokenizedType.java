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

public class XmlTokenizedType extends org.apache.ws.commons.schema.constants.Enum {

    static String[] members = new String[]{"CDATA", "IDREF", "IDREFS",
                                           "ENTITY", "ENTITIES", "NMTOKEN",
                                           "NMTOKENS", "NOTATION", "ENUMERATION",
                                           "QName", "NCName", "None"};

    /**
     * Creates new XmlSchemaForm
     */
    public XmlTokenizedType(String value) {
        super(value);
    }

    public String[] getValues() {
        return members;
    }

}
