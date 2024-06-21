package yugo;

public class CharLatin {

    private char latin;
    private int count;

    public char getLatin() {
        return latin;
    }

    public void setLatin(char latin) {
        this.latin = latin;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "CharLatin{" +
                "latin=" + latin +
                ", count=" + count +
                '}';
    }
}