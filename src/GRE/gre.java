package GRE;

import GUI.gui;
import ReadFile.*;
import City.*;
import java.util.ArrayList;
import java.util.Iterator;

public class gre {
    private double price=0;
    ReadFile rf = new ReadFile();
    ArrayList<City> cityList = new ArrayList<City>();
    City[] city = new City[144];

    int mark;



    public ArrayList<City> Gre(int n){
        for(int i =0;i<144;i++)
            city[i] = new City();
        city = rf.readText("TSP.TXT");
        city[n].setV(false);
        double[][] distance= rf.Distance();
        cityList.add(city[n]);

        for(int i=0;i<143;i++){
            double Best = 10000000.0;
            for(int j=1;j<144;j++){
                //System.out.println((i+1) + "  " + (j+1) + "   " + distance[i][j]);
                if(city[j].V()){
                    if(i!=j)
                        if(distance[i][j] < Best){
                            Best = distance[i][j];
                            mark = j;
                            //System.out.println("test : "+i + "   :" +j);
                        }
                }
                else
                    continue;
            }
            cityList.add(city[mark]);
            city[mark].setV(false);
            price += Best;
        }
        return cityList;
    }
   public static void main(String[] args){
        gre ge = new gre();
        gui gu = new gui();
        City value = null;
        Iterator iter = ge.Gre(0).iterator();
        while (iter.hasNext()) {
            value = (City) iter.next();
            gu.showP(value.I());
            //System.out.println(value.I() + "--->" + "  ");
        }
    }
}