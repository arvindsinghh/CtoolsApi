package org.example.shippingmethods;

import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.shipping_method.ShippingMethod;

public class ShippingMethodsService {
    ShippingMethodsDataProvider shippingMethodsDataProvider=new ShippingMethodsDataProvider();
    public ShippingMethod createShippingMethod(ProjectApiRoot apiRoot) {
        ShippingMethod shippingMethod= shippingMethodsDataProvider.createShippingMethod(apiRoot);

   return shippingMethod; }

    public void deleteShippingMethodbykey(String key, ProjectApiRoot apiRoot) {
         shippingMethodsDataProvider.deleteShippingMethodbykey(key,apiRoot);
    }
    public void deleteShippingMethodbyId(String id, ProjectApiRoot apiRoot) {
        shippingMethodsDataProvider.deleteShippingMethodbyId(id,apiRoot);
    }


    public ShippingMethod getShippingMethodBykey(String key, ProjectApiRoot apiRoot) {
        return shippingMethodsDataProvider.getShippingMethodbyKey(key,apiRoot);

    }

    public ShippingMethod getShippingMethodByid(String id, ProjectApiRoot apiRoot) {
        return shippingMethodsDataProvider.getShippingMethodbyId(id,apiRoot);

    }
}
