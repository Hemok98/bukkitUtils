package hemok98.BukkitUtils.utils;

public class DateFormater {
    private DateFormater(){};

    public static String formatDHM(long milisec){
        //System.out.println(milisec + " formatter milisec");
        milisec/=(1000*60);
        long minutes = milisec % 60;
        milisec/=60;
        long hours = milisec % 24;
        milisec/=24;
        long day = milisec;
        return String.format("%dд %dч %dмин", day, hours, minutes);
    }

    public static String format(long milisec){
        //System.out.println(milisec + " formatter milisec");
        milisec/=1000;
        long sec = milisec % 60;
        milisec/=60;
        long minutes = milisec % 60;
        milisec/=60;
        long hours = milisec % 24;
        milisec/=24;
        long day = milisec;
        String time = "";
        if (day != 0) time+= day +"д ";
        if (hours != 0) time+= hours +"ч ";
        if (minutes != 0 ) time+= minutes + "мин ";
        time += sec + "сек";
        return String.format("%d%d:%d%d:%d%d", hours/10, hours%10, minutes/10, minutes%10, sec/10, sec%10);
        //return time;
    }
}
