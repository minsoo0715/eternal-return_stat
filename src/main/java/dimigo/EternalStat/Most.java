package dimigo.EternalStat;

public class Most { //많이 플레이한 캐릭터의 데이터를 위한 클래스
    String name;
    int count;
    int top3;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTop3() {
        return top3;
    }

    public void setTop3(int top3) {
        this.top3 = top3;
    }
}
