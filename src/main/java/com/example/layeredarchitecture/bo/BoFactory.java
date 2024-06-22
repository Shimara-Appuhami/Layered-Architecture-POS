package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.bo.custom.impl.CustomerBOImpl;
import com.example.layeredarchitecture.bo.custom.impl.ItemBOImpl;
import com.example.layeredarchitecture.bo.custom.impl.PurchaseOrderBOImpl;

public class BoFactory {
    public static BoFactory boFactory;
    private BoFactory(){
    }
    public static BoFactory getBoFactory(){
        return boFactory==null? new BoFactory():boFactory;
    }
    public enum BoTypes{
        CUSTOMER,ITEM,PURCHASE;
    }
    public SuperBo getBo(BoTypes boTypes){
        switch (boTypes){
            case CUSTOMER:
                return new CustomerBOImpl();
            case ITEM:
                return new ItemBOImpl();
            case PURCHASE:
                return new PurchaseOrderBOImpl();
            default:
                return null;
        }
    }
}
