import java.util.ArrayList;

public class InRangeEntries {


    //iterates over all DataEntries and returns an arraylist containing thoose which are in range to the origin Point
    public static ArrayList<DataEntry> addInRangeEntrys(ArrayList<DataEntry> entries, double originX, double originY, double radius){
        ArrayList<DataEntry> inRangeEntries = new ArrayList<DataEntry>();
        for(int i = 0; i < entries.size(); i++){
            if(inRadiusRange(originX,originY,entries.get(i).getX(),entries.get(i).getY(),radius)){
                inRangeEntries.add(entries.get(i));
            }
        }
        return inRangeEntries;
    }

    public static boolean inRadiusRange (double x1, double y1, double x2, double y2, double radius) {

        //calculates distance between two points using pythagoras
        double d = Math.pow((x2-x1),2) + Math.pow((y2 - y1),2) ;

        //squaring is used, because taking a square root is much more inneficient, than just square 'radius'
        return d <= Math.pow(radius,2) ? true : false;
    }

    /*
    Berechnet die Anzahl aller Flughäfe, in deren r -Längeneinheiten- Umkreis sich mindestens n Bahnhöfe befinden
     */
    public static int AirportsInTrainstationRange(ArrayList<DataEntry> entries, double r, int n){
        int numTrainstationsInRange = 0;
        int numAirports = 0;

        for(int i = 0; i< entries.size();i++){  //iterates over all airports
            if (entries.get(i).getType() != Enumerations.LocationType.AIRPORT) continue;
            for (int j = 0; j < entries.size(); j++) {  // iterates over all trainstations
                if(entries.get(j).getType() == Enumerations.LocationType.TRAINSTATION){
                    //check if current airport is in range of current trainstation
                    if(inRadiusRange(entries.get(j).getX(), entries.get(j).getY(), entries.get(i).getX(), entries.get(i).getY(), r)) {
                        numTrainstationsInRange++;  //if in range, then increment trainstation counter var
                    }
                }
            }
            //check if counter variable 'numTr...' is bigger then lower limit 'n' and increment airport counter var
            if(numTrainstationsInRange >= n) numAirports++;
            numTrainstationsInRange = 0;    //reset trainstation counter variable
        }
        return numAirports;
    }


}
