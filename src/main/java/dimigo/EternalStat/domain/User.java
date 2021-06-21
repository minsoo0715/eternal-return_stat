package dimigo.EternalStat.domain;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import dimigo.EternalStat.Avgchrank;
import dimigo.EternalStat.Match;
import dimigo.EternalStat.Most;

import javax.persistence.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;


@Entity
@Table(name="User")
public class User {  //User 테이블과 연결될 도메인

    @Id
    private String id;  //PK값

    @Column(columnDefinition = "TEXT") //텍스트 타입으로 설정함
    String most;
    int winCount;
    double avgrank;
    double avgkill;
    @Column(columnDefinition = "TEXT")
    String avgchrank;
    @Column(columnDefinition = "TEXT")
    String match_data;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Map<String, String>> getMost() {
        Type listType = new TypeToken<ArrayList<Most>>(){}.getType();
        return new GsonBuilder().create().fromJson(this.most, listType);
    }

    public void setMost(String most) {
        this.most = most;
    }

    public int getWinCount() {
        return winCount;
    }

    public void setWinCount(int winCount) {
        this.winCount = winCount;
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

    public ArrayList<Map<String,String>> getAvgchrank() {

        Type listType = new TypeToken<ArrayList<Avgchrank>>(){}.getType();
        return new GsonBuilder().create().fromJson(this.avgchrank, listType);
    }

    public void setAvgchrank(String avgchrank) {
        this.avgchrank = avgchrank;
    }

    public ArrayList<Map<String, String>> getMatch_data() {
        Type listType = new TypeToken<ArrayList<Match>>(){}.getType();
        return new GsonBuilder().create().fromJson(this.match_data, listType);
    }

    public void setMatch_data(String match) {
        this.match_data = match;
    }
}
