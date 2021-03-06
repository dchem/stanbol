/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.stanbol.ontologymanager.ontonet.api.ontology;

import java.util.Set;

import org.apache.stanbol.ontologymanager.servicesapi.collector.OntologyCollector;
import org.semanticweb.owlapi.model.OWLOntologyID;

@Deprecated
public class OntologyHandleException extends
        org.apache.stanbol.ontologymanager.servicesapi.ontology.OntologyHandleException {

    /**
     * 
     */
    private static final long serialVersionUID = 296650804776257376L;

    public OntologyHandleException(Set<OntologyCollector> collectorHandles, Set<OWLOntologyID> dependents) {
        super(collectorHandles, dependents);
    }

    public OntologyHandleException(String message) {
        super(message);
    }

    public OntologyHandleException(String message,
                                   Set<OntologyCollector> collectorHandles,
                                   Set<OWLOntologyID> dependents) {

        super(message, collectorHandles, dependents);
    }

}
