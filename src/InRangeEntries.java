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

        double d = Math.pow((lat2-lat1),2) + Math.pow((lon2 - lon1),2) ;
        return d <= Math.pow(radius,2) ? true : false;
    }


    /*
    Anzahl aller Flughäfen berechnet, in deren r -Längeneinheiten- Umkreis sich mindestens n Bahnhöfe befinden
     */
    public static int numAirportsInRangeOfTrainstations(ArrayList<DataEntry> entries, double r, int n){
        int numberTrainstationsInRange = 0;
        int numAirports = 0;

        for(int i = 0; i< entries.size();i++){
            if (entries.get(i).getType() != Enumerations.LocationType.AIRPORT) continue;
            for (int j = 0; j < entries.size(); j++) {
                if(entries.get(j).getType() == Enumerations.LocationType.TRAINSTATION){
                    if(inRadiusRange(entries.get(j).getLat(), entries.get(j).getLon(), entries.get(i).getLat(), entries.get(i).getLon(), r)) {
                        numberTrainstationsInRange++;
                    }
                }
            }
            if(numberTrainstationsInRange >= n) numAirports++;
            numberTrainstationsInRange = 0;
        }
        return numAirports;
    }


}
