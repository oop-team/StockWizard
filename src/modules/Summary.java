/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modules;

import data.Data;
import data.Session;

import java.util.Date;

import java.util.Random;

/**
 *Tóm tắt tình hình của CTCP Sơn Địa Ốc (AAV)
 * @author Hieu
 */
public class Summary extends SentenceGenerator {
    @Override
    public String example() {
        return "So với ngày hôm qua, giá cổ phiếu  tăng: 15%, tổng số tiền giao dịch: 150.000 VNĐ, tổng khối lượng giao dịch: 200 cổ phiếu";
    }

    @Override
    public String generate() {
        float []resultHNX= count(data[0]);
        float []resultHSX= count(data[1]);
        float []resultUPCOM= count(data[2]);
        String result=null;
        result=String.format("Hôm nay tại sàn %s giá cổ phiếu tăng: %.2f%, tổng khối lượng giao dịch: %.0f, tổng số tiền giao dịch: %f ",data[0].getStockExchange(),resultHNX[0],resultHNX[1],resultHNX[2]);
        result+=String.format("\tHôm nay tại sàn %s giá cổ phiếu tăng: %.2f%, tổng khối lượng giao dịch: %.0f, tổng số tiền giao dịch: %f ",data[1].getStockExchange(),resultHSX[0],resultHSX[1],resultHSX[2]);
        result+=String.format("\tHôm nay tại sàn %s giá cổ phiếu tăng: %.2f%, tổng khối lượng giao dịch: %.0f, tổng số tiền giao dịch: %f ",data[2].getStockExchange(),resultUPCOM[0],resultUPCOM[1],resultUPCOM[2]);
        return result;
    }
    private float[] count(Data data){
        float []result= new float[3];
        Session[] sessions= data.getSessions();
        Date Today= sessions[0].getDate();
        Date Tomorrow = null;

        // Tìm ngày hôm qua
        for(Session s: sessions){
            if(!Today.equals(s.getDate())) {
                Tomorrow= s.getDate();
                break;
            }
        }
        /* Tính toán: result[0]: % tăng giảm
                      result[1]: khối lượng giao dịch
                      result[2]: tổng tiền
         */
        for(Session s: sessions){
             if(s.getTicker().equals("AAV")){
                 if(s.getDate().equals(Today)){
                     if(s.getClose()==0)break; // nếu ngày hôm qua ko giao dịch thì break
                     result[0]=s.getClose();
                     result[1]=s.getVolume();
                     result[2]=result[0]*result[1];
                 }else if(s.getDate().equals(Tomorrow)){
                     result[0]=(result[0]-s.getClose())/result[0]*100;
                     break;
                 }

             }
        }
        return result;



    }
}
