package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Data {
    private Session[] sessions;

    public Session[] getSessions(){
        return null;
    }

    public void getDataFromWeb(){

    }

    public void getDataFromLocal(){

    }

    public Session[] getExampleSessions() throws FileNotFoundException {
        List<Session> sessions = new ArrayList<>();

        Scanner sc = new Scanner(new File("res/Example_Data.csv"));
        sc.useDelimiter(",|\n");
        while (sc.hasNext())  //returns a boolean value
        {
            Session session = new Session();
            session.setTicker(sc.next());

            // e.g: "20201015" -> "2020-10-15"
            char[] rawDate = sc.next().toCharArray();
            char[] date = new char[10];
            date[0] = rawDate[0];
            date[1] = rawDate[1];
            date[2] = rawDate[2];
            date[3] = rawDate[3];
            date[4] = '-';
            date[5] = rawDate[4];
            date[6] = rawDate[5];
            date[7] = '-';
            date[8] = rawDate[6];
            date[9] = rawDate[7];
            session.setDate(Date.valueOf(String.valueOf(date)));

            session.setOpen(Float.parseFloat(sc.next()));
            session.setHigh(Float.parseFloat(sc.next()));
            session.setLow(Float.parseFloat(sc.next()));
            session.setClose(Float.parseFloat(sc.next()));
            session.setVolume(Integer.parseInt(sc.next().trim()));

            sessions.add(session);
        }
        sc.close();

        Session[] ret = new Session[sessions.size()];
        for(int i = 0; i < sessions.size(); i++){
            ret[i] = sessions.get(i);
        }

        return ret;
        //return (Session[]) sessions.toArray();
    }
}