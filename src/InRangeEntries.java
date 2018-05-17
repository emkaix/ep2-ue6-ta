import java.util.ArrayList;

public class InRangeEntries {

    public static ArrayList<DataEntry> addDataEntryIfInRange(ArrayList<DataEntry> entries, double pointLat, double pointLon, double radius){
        ArrayList<DataEntry> inRangeEntries = new ArrayList<DataEntry>();
        for(int i = 0; i < entries.size(); i++){
            if(inRadiusRange(pointLat,pointLon,entries.get(i).getLat(),entries.get(i).getLon(),radius)){
                inRangeEntries.add(entries.get(i));
            }
        }
        return inRangeEntries;

    }

    public static boolean inRadiusRange (double lat1, double lon1, double lat2, double lon2, double radius) {
        int radiusEarth = 6371;
        double differenceLat = (degreeToRad(lat2)- degreeToRad(lat1));
        double differenceLon = (degreeToRad(lon2)- degreeToRad(lon1));

        /*
        This uses the ‘haversine’ formula to calculate the great-circle distance between two points
        a = sin²(Δφ/2) + cos φ1 ⋅ cos φ2 ⋅ sin²(Δλ/2)
        c = 2 ⋅ atan2( √a, √(1−a) )
        d = R ⋅ c

        φ is latitude, λ is longitude, R is earth’s radius (mean radius = 6,371km);
        note that angles need to be in radians to pass to trig functions!
         */

        double a = Math.pow(Math.sin(differenceLat/2),2) + Math.cos(degreeToRad(lat1)) * Math.cos(degreeToRad(lat2)) *
                Math.sin(differenceLon/2) * Math.sin(differenceLon/2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        double d = radiusEarth * c; //distance in km

        return d <= radius ? true : false;

    }

    private static double degreeToRad (double deg){
        return deg*Math.PI/180;
    }


    /*
    Anzahl aller Flughäfen berechnet, in deren r -Längeneinheiten- Umkreis sich mindestens n Bahnhöfe befinden
     */
    public static int numAirportsInRangeOfTrainstations(ArrayList<DataEntry> entries, double radius){
        int numberAirportsInRange = 0;

        for(int i = 0; i< entries.size();i++){
            if (entries.get(i).getType() != Enumerations.LocationType.AIRPORT) continue;
            for (int j = 0; j < entries.size(); j++) {
                if(entries.get(j).getType() == Enumerations.LocationType.TRAINSTATION){
                    if(inRadiusRange(entries.get(j).getLat(), entries.get(j).getLon(), entries.get(i).getLat(), entries.get(i).getLon(), radius)) {
                        numberAirportsInRange++;
                    }
                }
            }
        }
        return numberAirportsInRange;
    }


}
