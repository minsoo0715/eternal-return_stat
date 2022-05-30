package dimigo.EternalStat.dto;

public class Avgchrank { //캐릭터 평균 데이터들을 보관하기 위한 클랫
    String chname;
    double avgrank;
    int maxkill;

    public String getChname() {
        return chname;
    }

    public void setChname(String chname) {
        this.chname = chname;
    }

    public double getAvgrank() {
        return avgrank;
    }

    public void setAvgrank(double avgrank) {
        this.avgrank = avgrank;
    }

    public int getMaxkill() {
        return maxkill;
    }

    public void setMaxkill(int maxkill) {
        this.maxkill = maxkill;
    }
}
