package utilities;

public class Time {
    private int minuet;
    private int hour;

    public int getMinuet() {
        return minuet;
    }

    public void setMinuet(int minuet) {
        this.minuet = minuet;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public Time add(final Time extraTime){
        int minute = this.getMinuet() + extraTime.getMinuet();

        int carryOver = 0;
        if(minute > 59){
            carryOver = 1;
            minute %= 60;
        }

        int hour = this.getHour() + extraTime.getHour() + carryOver;

        Time result = new Time();
        result.setMinuet(minuet);
        result.setHour(hour);

        return result;
    }
}
