package ReadFile;

import java.io.*;
import java.util.NoSuchElementException;
import City.City;

public class ReadFile {
    String data;
    City[] city;
    double[][] distance;

    public ReadFile(){
        readText("TSP.txt");
    }

    public City[] readText(String fileName){

        city = new City[144];

        for(int i=0;i<144;i++){
            city[i] = new City();
        }
        int cnt = 0;

        StringBuilder sb = new StringBuilder();
        try {
            File file = new File("C://Users//Aaron//Desktop//Algorithm//data", fileName);
            Reader reader = new FileReader(file);
            BufferedReader BR = new BufferedReader(reader);

            String str;
            boolean flag1 = false;

            while ((str = BR.readLine()) != null) {
                if(str.equals("NODE_COORD_SECTION ")){
                    flag1 = true;
                    continue;
                }

                if(flag1 && str.length() >4) {
                    String[] a = str.split(" ");
                    city[cnt].seti(Integer.parseInt(String.valueOf(a[0])));
                    city[cnt].setX(Integer.parseInt(String.valueOf(a[1])));
                    city[cnt++].setY(Integer.parseInt(String.valueOf(a[2])));
                }
            }
        }catch(NoSuchElementException ex){
            ex.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return city;
    }

    public double[][] Distance(){
        ReadFile rf = new ReadFile();
        city = new City[144];
        distance = new double[144][144];

        city = rf.readText("TSP.txt");

        for(int i=0;i<144;i++){
            for(int j=0;j<144;j++){
                if(i==j)
                    continue;
                double x = ((city[i].X() -city[j].X())*(city[i].X() -city[j].X()));
                double y = ((city[i].Y() -city[j].Y())*(city[i].Y() -city[j].Y()));
                distance[i][j] = Math.sqrt(x+y);
                //System.out.println((i+1) + "  " + (j+1) + "   " + distance[i][j]);
            }
        }
        return distance;
    }

    /*public static void main(String[] args){
        ReadFile rf = new ReadFile();
        rf.Distance();
    }*/
}
