class UndergroundSystem {

    class Checkin {
        String station;
        int time;

        public Checkin(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }

    class Journey {
        int totalTime;
        int tripCount;

        Journey(int totalTime, int tripCount) {
            this.totalTime = totalTime;
            this.tripCount = tripCount;
        }
    }

    HashMap<Integer, Checkin> map = new HashMap<>();
    HashMap<String, Journey> journeys = new HashMap<>();

    public UndergroundSystem() {

    }

    public void checkIn(int id, String stationName, int t) {
        Checkin ch = new Checkin(stationName, t);
        map.put(id, ch);
    }

    public void checkOut(int id, String stationName, int t) {

        Checkin ch = map.get(id);

        int time = ch.time;
        String station = ch.station;

        String route = station + "->" + stationName;

        int journeytime = t - time;
        int round = 1;

        if (journeys.containsKey(route)) {

            Journey j = journeys.get(route);

            round = j.tripCount;
            round++;

            int roundtime = j.totalTime;
            journeytime += roundtime;
        }

        Journey j2 = new Journey(journeytime, round);

        journeys.put(route, j2);
    }

    public double getAverageTime(String startStation, String endStation) {

        String route = startStation + "->" + endStation;

        Journey j = journeys.get(route);

        return (double) j.totalTime / j.tripCount;
    }
}
/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */