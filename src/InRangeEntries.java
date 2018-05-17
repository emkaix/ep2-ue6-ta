import java.util.ArrayList;

public class InRangeEntries {

    public static ArrayList<DataEntry> addDataEntryIfInRange(ArrayList<DataEntry> entries, double originX, double originY, double radius){
        ArrayList<DataEntry> inRangeEntries = new ArrayList<DataEntry>();
        for(int i = 0; i < entries.size(); i++){
            if(inRadiusRange(originX,originY,entries.get(i).getX(),entries.get(i).getY(),radius)){
                inRangeEntries.add(entries.get(i));
            }
        }
        return inRangeEntries;

    }

    public static boolean inRadiusRange (double x1, double y1, double x2, double y2, double radius) {

        double d = Math.pow((x2-x1),2) + Math.pow((y2 - y1),2) ;
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
                    if(inRadiusRange(entries.get(j).getX(), entries.get(j).getY(), entries.get(i).getX(), entries.get(i).getY(), r)) {
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
