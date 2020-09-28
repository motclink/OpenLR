package openlr.proto.encoder;

import openlr.LocationType;

public class LocationTypeEncoderRegistry {
    private final LineEncoder lineEncoder;
    private final GeoCoordinatesEncoder geoCoordinatesEncoder;
    private final PointAlongLineEncoder pointAlongLineEncoder;
    private final PolygonEncoder polygonEncoder;

    public static LocationTypeEncoderRegistry create() {
        LocationReferencePointEncoder locationReferencePointEncoder = new LocationReferencePointEncoder();
        LineEncoder lineEncoder = new LineEncoder(locationReferencePointEncoder);
        GeoCoordinatesEncoder geoCoordinatesEncoder = new GeoCoordinatesEncoder();
        PointAlongLineEncoder pointAlongLineEncoder = new PointAlongLineEncoder(locationReferencePointEncoder);
        PolygonEncoder polygonEncoder = new PolygonEncoder();

        return new LocationTypeEncoderRegistry(lineEncoder, geoCoordinatesEncoder, pointAlongLineEncoder, polygonEncoder);
    }

    LocationTypeEncoderRegistry(LineEncoder lineEncoder, GeoCoordinatesEncoder geoCoordinatesEncoder, PointAlongLineEncoder pointAlongLineEncoder, PolygonEncoder polygonEncoder) {
        this.lineEncoder = lineEncoder;
        this.geoCoordinatesEncoder = geoCoordinatesEncoder;
        this.pointAlongLineEncoder = pointAlongLineEncoder;
        this.polygonEncoder = polygonEncoder;
    }

    public LocationReferenceEncoder getEncoder(LocationType locationType) {
        switch (locationType) {
            case LINE_LOCATION:
                return lineEncoder;
            case GEO_COORDINATES:
                return geoCoordinatesEncoder;
            case POINT_ALONG_LINE:
                return pointAlongLineEncoder;
            case POLYGON:
                return polygonEncoder;
            case POI_WITH_ACCESS_POINT:
            case CIRCLE:
            case CLOSED_LINE:
            case RECTANGLE:
            case GRID:
            case UNKNOWN:
                return null;
            default:
                throw new IllegalStateException();
        }
    }
}
