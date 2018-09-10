public class MovieMain implements Comparable<MovieMain> {
    private String name;
    private int duration;
    private int numOfResponse;

    public MovieMain(String name, int duration, int numOfResponse){
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

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public int getNumOfResponse() {
        return numOfResponse;
    }


    @Override
    public int compareTo(MovieMain z)
    {
        int res=0;
        if (duration < z.duration) {res=-1;  }
        if (duration > z.duration){res=1;}
        return res;
    }



    @Override
    public String toString() {
        return "Name of movie: "+ name + " , duration is: "+ duration + ", number of response: "+ numOfResponse;
    }
}
