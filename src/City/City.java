package City;

public class City{
    private int i;
    private int x;
    private int y;
    private boolean visited;

    public City(){
        i=0;
        x=0;
        y=0;
        visited = true;
    }

    public void seti(int c){
        i = c;
    }
    public void setX(int c){
        x = c;
    }
    public void setY(int c){
        y = c;
    }
    public void setV(boolean c){
        visited=c;
    }

    public int I(){
        return i;
    }
    public int X(){
        return x;
    }
    public int Y(){
        return y;
    }
    public boolean V(){
        return visited;
    }
}