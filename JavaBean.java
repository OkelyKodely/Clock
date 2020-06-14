public class JavaBean {

    private int hours;
    private int minutes;
    private int secs;
    private boolean isAM;

    public JavaBean (int h, int m, int s) {
        this.hours = h;
        this.minutes = m;
        this.secs = s;
    }

    /**
     * @return the hours
     */
    public int getHours() {
        return hours;
    }

    /**
     * @param hours the hours to set
     */
    public void setHours(int hours) {
        this.hours = hours;
    }

    /**
     * @return the minutes
     */
    public int getMinutes() {
        return minutes;
    }

    /**
     * @param minutes the minutes to set
     */
    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    /**
     * @return the secs
     */
    public int getSecs() {
        return secs;
    }

    /**
     * @param secs the secs to set
     */
    public void setSecs(int secs) {
        this.secs = secs;
    }
    
    public boolean getIsAMPM() {
        return this.isAM;
    }
    
    public void updateAMPM() {
        if(this.hours > 11) {
            isAM = false;
        } else
            isAM = true;
    }
}