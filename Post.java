import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Post {

    String date;
    String text;
    private User name;

    public Post(String date, User name, String text)
    {
        this.date = date;
        this.text = text;
        this.name = name;

    }


    public static String Timestamp()
    {

        String date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
        return date;

   }


    @Override
    public String toString() {
        return getDate() + " ~ " + getUser() + " : " + getText();
    }

    public String getText() {
        return text;
    }

    public String getDate() {
        return date;
    }

    public User getUser() {
        return name;
    }



}