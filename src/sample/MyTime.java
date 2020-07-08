package sample;

public class MyTime {

    private static final int COUNT = 60;
    private int seconds = 0;

    public MyTime(){}

    public MyTime(int seconds) {
        this.seconds = seconds;
    }

    public MyTime(String line) {
        String word = "";
        String[] words = line.split(":");
        this.seconds = Integer.parseInt(words[0]) * COUNT * COUNT + Integer.parseInt(words[1]) * COUNT + Integer.parseInt(words[2]);
    }

    public MyTime(int hours, int minutes, int seconds) {
        this.seconds = hours * COUNT * COUNT + minutes * COUNT + seconds;
    }

    public int getHours() {
        return seconds / (COUNT * COUNT) ;
    }

    public int getMinutes() {
        return (seconds - getHours() * COUNT * COUNT) / COUNT;
    }

    public int getSeconds() {
        return seconds - getHours() * COUNT * COUNT - getMinutes() * COUNT;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    @Override
    public String toString() {
        return String.valueOf(getHours()) +
                ":" + String.valueOf(getMinutes()) +
                ":" + String.valueOf(getSeconds());
    }

    public MyTime plus(MyTime time){
        return new MyTime(this.seconds + time.seconds);
    }

    public MyTime sub(MyTime time){
        return new MyTime(this.seconds - time.seconds);
    }

    public int compare(MyTime time){
        if(this.seconds < time.seconds) return -1;
        else if(this.seconds > time.seconds) return 1;
        else return 0;
    }


}
