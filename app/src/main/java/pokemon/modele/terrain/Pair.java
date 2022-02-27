package pokemon.modele.terrain;

public class Pair {
    private int first, second;
    private int distance;

    public Pair(int first, int second, int distance) 
    {
        this.first = first;
        this.second = second;
        this.distance=distance;
    }   
    public int getFirst() {
        return first;
    }
    public int getSecond() {
        return second;
    }
    public int getDistance(){
        return distance;
    }
}
