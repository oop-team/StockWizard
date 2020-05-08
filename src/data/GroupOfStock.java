package data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

/*
Nhiệm vụ: đưa ra thông tin các cổ phiếu trong 5 nhóm được lưu tại rổ cổ phiếu.txt.txt
nameOfStock lưu tên nhóm cổ phiếu muốn tìm
 */

public class GroupOfStock {
       private ArrayList<Session> groupOfStock(Data data,String nameOfStock){
           ArrayList<Session>List=new ArrayList<>();// lưu các dữ liệu của mã cổ phiếu cần tìm
          Session []sessions=data.getSessions();// Lưu giữ liệu các phiên giao dịch vào session
           String[] Stocks= new String[500];

           try {
               BufferedReader ReadFile= null;
               FileReader fr=null;
               fr= new FileReader("res/general_information/rổ cổ phiếu.txt.txt");
               ReadFile= new BufferedReader(fr);
               String line= ReadFile.readLine();// lưu từng dòng của file nhóm cổ phiếu txt

                    while (line!=null) {
                        Stocks = line.split("/");
                        if (nameOfStock == Stocks[0]) break;// Stock[0] là tên của nhóm cổ phiếu, các phần tử còn lại trong mảng Stock là các cổ phiếu thuộc nhóm Stock[0]
                        line = ReadFile.readLine();

                    }

           }catch(IOException e){
                   e.printStackTrace();
               }
           for(Session s: sessions){
               int index=1;
               while(Stocks[index]!=null){
                   if(s.getTicker()==Stocks[index])List.add(s);
                   index++;
               }
           }
           return List;

       }
}
