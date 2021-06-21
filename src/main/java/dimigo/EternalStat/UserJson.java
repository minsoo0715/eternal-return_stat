package dimigo.EternalStat;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import dimigo.EternalStat.domain.User;

import java.util.ArrayList;


public class UserJson { //서버에서 받을 JSON을 가공할 클래스

    private String id;

    ArrayList<Most> most_played;
    int winnum;
    double avgrank;
    double avgkill;
    ArrayList<Avgchrank> avgchrank;
    ArrayList<Match> match;

    public User ConvertToUser() { //테이블에 저장할 USER 도메인으로 변환하는 함수

        User user = new User();
        user.setId(this.id);
        user.setAvgkill(this.getAvgkill());
        user.setAvgrank(this.getAvgrank());
        user.setWinCount(this.getWinnum());

        JsonObject temp;
        JsonArray temp2 = new JsonArray();
        JsonArray temp3 = new JsonArray();
        JsonArray temp4 = new JsonArray();


        for(int i = 0; i<this.most_played.size(); i++) {
            temp = new JsonObject();
            temp.addProperty("count", this.most_played.get(i).getCount());
            temp.addProperty("name", this.most_played.get(i).getName());
            temp.addProperty("top3", this.most_played.get(i).getTop3());
            temp2.add(temp);
        }

        for(int i = 0; i<this.match.size(); i++) {
            temp = new JsonObject();
            temp.addProperty("level", this.match.get(i).getLevel());
            temp.addProperty("kill", this.match.get(i).getKill());
            temp.addProperty("ch", this.match.get(i).getCh());
            temp.addProperty("rank", this.match.get(i).getRank());

            temp3.add(temp);
        }

        for(int i = 0; i<this.avgchrank.size(); i++) {
            temp = new JsonObject();
            temp.addProperty("chname", this.avgchrank.get(i).getChname());
            temp.addProperty("avgrank", this.avgchrank.get(i).getAvgrank());
            temp.addProperty("maxkill", this.avgchrank.get(i).maxkill);
            temp4.add(temp);
        }

        user.setMost(temp2.toString());
        user.setAvgchrank(temp4.toString());
        user.setMatch_data(temp3.toString());

        return user;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Most> getMost_played() {
        return most_played;
    }

    public void setMost_played(ArrayList<Most> most_played) {
        this.most_played = most_played;
    }

    public int getWinnum() {
        return winnum;
    }

    public void setWinnum(int winnum) {
        this.winnum = winnum;
    }

    public double getAvgrank() {
        return avgrank;
    }

    public void setAvgrank(double avgrank) {
        this.avgrank = avgrank;
    }

    public double getAvgkill() {
        return avgkill;
    }

    public void setAvgkill(double avgkill) {
        this.avgkill = avgkill;
    }

    public ArrayList<Avgchrank> getAvgchrank() {
        return avgchrank;
    }

    public void setAvgchrank(ArrayList<Avgchrank> avgchrank) {
        this.avgchrank = avgchrank;
    }

    public ArrayList<Match> getMatch() {
        return match;
    }

    public void setMatch(ArrayList<Match> match) {
        this.match = match;
    }
}
