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
package org.apache.stanbol.rules.adapters.swrl.atoms;

import org.apache.stanbol.rules.adapters.AbstractAdaptableAtom;
import org.apache.stanbol.rules.adapters.swrl.ArgumentSWRLAtom;
import org.apache.stanbol.rules.adapters.swrl.SWRLLiteralBuilder;
import org.apache.stanbol.rules.base.api.RuleAtom;
import org.apache.stanbol.rules.base.api.RuleAtomCallExeption;
import org.apache.stanbol.rules.base.api.Symbols;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.SWRLDArgument;

/**
 * It adapts any NumberAtom to a number literal in SWRL.
 * 
 * @author anuzzolese
 * 
 */
public class NumberAtom extends AbstractAdaptableAtom {

    @SuppressWarnings("unchecked")
    @Override
    public <T> T adapt(RuleAtom ruleAtom) throws RuleAtomCallExeption {
        org.apache.stanbol.rules.manager.atoms.NumberAtom tmp = (org.apache.stanbol.rules.manager.atoms.NumberAtom) ruleAtom;

        String number = tmp.getNumber();

        SWRLDArgument swrldArgument = null;

        OWLDataFactory factory = OWLManager.getOWLDataFactory();

        if (number.startsWith(Symbols.variablesPrefix)) {

            swrldArgument = factory.getSWRLVariable(IRI.create(number));

        } else {

            Number n = null;
            if (number.contains("\\.")) {
                int indexOfPoint = number.indexOf('.');

                if (indexOfPoint == number.length() - 2) {
                    n = Float.valueOf(number);
                } else {
                    n = Double.valueOf(number);
                }
            } else {
                n = Integer.valueOf(number);
            }

            swrldArgument = SWRLLiteralBuilder.getSWRLLiteral(n);
        }

        return (T) new ArgumentSWRLAtom(swrldArgument, number);

    }

}
