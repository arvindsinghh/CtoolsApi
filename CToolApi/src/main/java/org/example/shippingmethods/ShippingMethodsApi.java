package org.example.shippingmethods;

import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.shipping_method.ShippingMethod;

public class ShippingMethodsApi {
    static ShippingMethodsService shippingMethodsService=new ShippingMethodsService();
    public  static void useShippingMethedApi(ProjectApiRoot apiRoot){
        createShippingMethod(apiRoot);
        deleteShippingMethodbyId("",apiRoot);
        deleteShippingMethodbykey("",apiRoot);
        getShippingMethodById("",apiRoot);
        getShippingMethodByKey("",apiRoot);



    }

    private static void getShippingMethodByKey(String key, ProjectApiRoot apiRoot) {
        shippingMethodsService.getShippingMethodBykey(key,apiRoot);

    }

    private static void getShippingMethodById(String id, ProjectApiRoot apiRoot) {
        shippingMethodsService.getShippingMethodByid(id,apiRoot);

    }

    private static void deleteShippingMethodbykey(String key, ProjectApiRoot apiRoot) {
        shippingMethodsService.deleteShippingMethodbykey(key,apiRoot);
    }

    private static void deleteShippingMethodbyId(String id, ProjectApiRoot apiRoot) {
        shippingMethodsService.deleteShippingMethodbyId(id,apiRoot);
    }


    private static ShippingMethod createShippingMethod(ProjectApiRoot apiRoot) {
        ShippingMethod shippingMethod= shippingMethodsService.createShippingMethod(apiRoot);
       return shippingMethod;
    }
}
