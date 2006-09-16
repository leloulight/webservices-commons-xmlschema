/*
 * Copyright 2004,2005 The Apache Software Foundation.
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

import org.apache.ws.commons.schema.constants.Enum;

/**
 * Indicates if attributes or elements need to be qualified or left unqualified.
 */

public class XmlSchemaForm extends Enum {

    public static final String QUALIFIED = "qualified";
    public static final String UNQUALIFIED = "unqualified";
    public static final String NONE = "none";
    
    static String[] members = new String[]{NONE, QUALIFIED, UNQUALIFIED};

    /**
     * Creates new XmlSchemaForm
     */
    public XmlSchemaForm() {
        super();
    }

    public XmlSchemaForm(String value) {
        super(value);
    }

    public String[] getValues() {
        return members;
    }

}