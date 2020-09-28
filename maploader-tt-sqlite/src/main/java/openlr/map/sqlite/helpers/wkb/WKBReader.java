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
package openlr.map.sqlite.helpers.wkb;

import openlr.map.GeoCoordinates;
import openlr.map.GeoCoordinatesImpl;
import openlr.map.InvalidMapDataException;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

/**
 * The Class WKBReader.
 */
public final class WKBReader {

    /**
     * The Constant BITS_16.
     */
    private static final int BYTE_COUNT_16 = 16;

    /**
     * The Constant BITS_9.
     */
    private static final int BYTE_COUNT_9 = 9;

    /**
     * The Enum WKBByteOrder.
     */
    public enum WKBByteOrder {

        /**
         * The WK b_ bi g_ endian.
         */
        WKB_BIG_ENDIAN, // Big Endian

        /**
         * The WK b_ littl e_ endian.
         */
        WKB_LITTLE_ENDIAN; // Little Endian

    }

    /**
     * Utility class shall not be instantiated.
     */
    private WKBReader() {
        throw new UnsupportedOperationException();
    }

    /**
     * Read shape.
     *
     * @param bytes the bytes
     * @return the ordered shape coordinates
     * @throws WKBException the wKB exception
     */
    public static List<GeoCoordinates> readShape(final byte[] bytes)
            throws WKBException {

        ByteBuffer bb = ByteBuffer.wrap(bytes);
        byte byteOrder = bb.get();
        if (byteOrder == WKBByteOrder.WKB_LITTLE_ENDIAN.ordinal()) {
            bb = bb.order(ByteOrder.LITTLE_ENDIAN);
        } else if (byteOrder == WKBByteOrder.WKB_BIG_ENDIAN.ordinal()) {
            bb = bb.order(ByteOrder.BIG_ENDIAN);
        } else {
            throw new WKBException("invalid byte order");
        }
        int typeValue = bb.getInt();
        if (typeValue != WKBType.LINESTRING.getValue()) {
            throw new WKBException("unknown wkb type: " + typeValue);
        }
        int nrPoints = bb.getInt();

        List<GeoCoordinates> shape = new ArrayList<GeoCoordinates>();

        if (((bytes.length - BYTE_COUNT_9) % BYTE_COUNT_16) != 0) {
            throw new WKBException("invalid number of bytes: " + bytes.length);
        }
        int nrCoordinates = (bytes.length - BYTE_COUNT_9) / BYTE_COUNT_16;
        if (nrCoordinates != nrPoints) {
            throw new WKBException("not enough bytes");
        }

        try {
            for (int i = 0; i < nrCoordinates; i++) {
                shape.add(new GeoCoordinatesImpl(bb.getDouble(), bb.getDouble()));
            }
        } catch (InvalidMapDataException e) {
            throw new WKBException("invalid coordinate data in shape", e);
        }
        return shape;
    }

}
