package dimigo.EternalStat;

public class Match { //매치 기록 데이터를 받기 위한 클래스
    int level;
    int kill;
    int anikill;
    String ch;
    int rank;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getKill() {
        return kill;
    }

    public void setKill(int kill) {
        this.kill = kill;
    }

    public int getAnikill() {
        return anikill;
    }

    public void setAnikill(int anikill) {
        this.anikill = anikill;
    }

    public String getCh() {
        return ch;
    }

    public void setCh(String ch) {
        this.ch = ch;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
