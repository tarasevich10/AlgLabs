
public class Movie {
    private String name;
    private int duration;
    private int numOfResponse;

    public Movie(String name, int duration, int numOfResponse) {
        setName(name);
        setDuration(duration);
        setNumOfResponse(numOfResponse);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setNumOfResponse(int numOfResponse) {
        this.numOfResponse = numOfResponse;
    }


    public int compareToNumOfResponse(Movie other) {
        int res = 0;
        if (numOfResponse < other.numOfResponse) {

            res = -1;
        }
        if (numOfResponse > other.numOfResponse) {
            res = 1;
        }
        return res;
    }

    public int compareToNumOfDuration(Movie other) {
        int res = 0;
        if (duration < other.duration) {
            res = -1;
        }
        if (duration > other.duration) {
            res = 1;
        }
        return res;
    }


    @Override
    public String toString() {
        return "Name of movie: " + name + " , duration is: " + duration + ", number of response: " + numOfResponse;
    }
}