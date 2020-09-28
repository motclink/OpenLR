/**
 * Licensed to the TomTom International B.V. under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  TomTom International B.V.
 * licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.  You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 * <p>
 * Copyright (C) 2009-2019 TomTom International B.V.
 * <p>
 * TomTom (Legal Department)
 * Email: legal@tomtom.com
 * <p>
 * TomTom (Technical contact)
 * Email: openlr@tomtom.com
 * <p>
 * Address: TomTom International B.V., Oosterdoksstraat 114, 1011DK Amsterdam,
 * the Netherlands
 * <p>
 * Copyright (C) 2009-2019 TomTom International B.V.
 * <p>
 * TomTom (Legal Department)
 * Email: legal@tomtom.com
 * <p>
 * TomTom (Technical contact)
 * Email: openlr@tomtom.com
 * <p>
 * Address: TomTom International B.V., Oosterdoksstraat 114, 1011DK Amsterdam,
 * the Netherlands
 */
/**
 *  Copyright (C) 2009-2019 TomTom International B.V.
 *
 *   TomTom (Legal Department)
 *   Email: legal@tomtom.com
 *
 *   TomTom (Technical contact)
 *   Email: openlr@tomtom.com
 *
 *   Address: TomTom International B.V., Oosterdoksstraat 114, 1011DK Amsterdam,
 *   the Netherlands
 */
package openlr.map.loader;

import java.io.Serializable;

/**
 * The interface MapLoadParameter defines methods for the identification and the
 * type of a parameter. Parameters are used by the map loader to e.g. detect the 
 * location of the map data and/or to identify a region to be loaded. They may
 * be required or optional and each parameter has a type. The type is used to present
 * a file load dialog, a directory load dialog or a single text field.
 *
 * <p>
 * OpenLR is a trade mark of TomTom International B.V.
 * <p>
 * email: software@openlr.org
 *
 * @author TomTom International B.V.
 */
public interface MapLoadParameter extends Serializable {

    /**
     * Gets the type of the parameter. This type decides whether a file/directory
     * load dialog or a single text field will be used in the map load parameter
     * dialog.
     *
     * @return the parameter type
     */
    ParameterType getType();

    /**
     * Gets the name of the parameter. This name will be used as a label in the
     * map load parameter dialog and should be unique.
     *
     * @return the name
     */
    String getName();

    /**
     * Checks if this parameter is required.
     *
     * @return true, if the parameter is required
     */
    boolean isRequired();

    /**
     * Return the description of the parameter. This description will be used as
     * a tooltip in the map load parameter dialog.
     *
     * @return the description
     */
    String getDescription();

    /**
     * Gets the identifier which uniquely identifies this parameter for a specific map loader.
     *
     * @return the identifier
     */
    int getIdentifier();

    /**
     * Gets the value of the parameter. If the value is not set the method shall return null.
     *
     * @return the value
     */
    String getValue();

    /**
     * Sets the value of the parameter.
     *
     * @param val the new value
     */
    void setValue(String val);

    /**
     * The enum ParameterType defines the type of a parameter. The type is used to
     * show a file or directory dialog or a single textfield in the map load parameter
     * dialog.
     */
    public enum ParameterType {

        /** The FILE. */
        FILE,

        /** The DIRECTORY. */
        DIRECTORY,

        /** The STRING. */
        STRING;
    }

}
