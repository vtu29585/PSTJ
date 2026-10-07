import java.util.*;

class UndergroundSystem {

    // Stores customer check-in information
    Map<Integer, String> stationMap;
    Map<Integer, Integer> timeMap;

    // Stores total travel time and number of trips
    Map<String, Double> totalTime;
    Map<String, Integer> tripCount;

    public UndergroundSystem() {
        stationMap = new HashMap<>();
        timeMap = new HashMap<>();

        totalTime = new HashMap<>();
        tripCount = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        stationMap.put(id, stationName);
        timeMap.put(id, t);
    }

    public void checkOut(int id, String stationName, int t) {

        String startStation = stationMap.get(id);
        int startTime = timeMap.get(id);

        int travelTime = t - startTime;

        String route = startStation + "#" + stationName;

        totalTime.put(route,
                totalTime.getOrDefault(route, 0.0) + travelTime);

        tripCount.put(route,
                tripCount.getOrDefault(route, 0) + 1);

        // Customer has completed the journey
        stationMap.remove(id);
        timeMap.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {

        String route = startStation + "#" + endStation;

        double total = totalTime.get(route);
        int count = tripCount.get(route);

        return total / count;
    }
}