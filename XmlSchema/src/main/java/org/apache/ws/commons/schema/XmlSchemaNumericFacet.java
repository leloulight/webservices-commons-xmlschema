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
 * Abstract class for defining numeric facets.
 */

public abstract class XmlSchemaNumericFacet extends XmlSchemaFacet {

    /**
     * Creates new XmlSchemaNumericFacet
     */
    protected XmlSchemaNumericFacet() {
    }

    protected XmlSchemaNumericFacet(Object value, boolean fixed) {
        super(value, fixed);
    }


}
