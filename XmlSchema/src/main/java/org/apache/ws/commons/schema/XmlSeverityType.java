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
import org.apache.ws.commons.schema.constants.Enum;

/**
 * Represents the severity of the validation event.
 */

public class XmlSeverityType extends Enum {

    static String[] members = new String[]{
            Constants.BlockConstants.ERROR,
            Constants.BlockConstants.WARNING
    };

    /**
     * Creates new XmlSeverityType
     */
    public XmlSeverityType() {
        super();
    }

    public XmlSeverityType(String value) {
        super(value);
    }

    public String[] getValues() {
        return members;
    }
}
