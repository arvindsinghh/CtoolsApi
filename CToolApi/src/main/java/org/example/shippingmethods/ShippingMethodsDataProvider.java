package org.example.shippingmethods;

import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.shipping_method.ShippingMethod;
import com.commercetools.api.models.shipping_method.ShippingMethodDraft;
import com.commercetools.api.models.shipping_method.ShippingRateDraft;
import com.commercetools.api.models.shipping_method.ZoneRateDraft;
import com.commercetools.api.models.zone.ZoneResourceIdentifier;
import com.commercetools.api.models.zone.ZoneResourceIdentifierBuilder;

public class ShippingMethodsDataProvider {
   void createShippingRates(){
       ShippingRateDraft.builder().build();
    }
    ZoneResourceIdentifier createZoneResourceIdentifierBuilder(){
      return ZoneResourceIdentifierBuilder.of().id("hgh").key("bcg").build();
    }
   void createZoneRateDraft(){
       ZoneRateDraft.builder().zone(createZoneResourceIdentifierBuilder()).build();
    }
    ShippingMethodDraft  createShippingMethedDraft(){
        ShippingMethodDraft shippingMethodDraft= ShippingMethodDraft.builder().zoneRates().key("SmKey").name("SmName").build();
    return shippingMethodDraft;
     }
    public ShippingMethod createShippingMethod(ProjectApiRoot apiRoot) {
        ShippingMethod shippingMethod=apiRoot.shippingMethods().create(createShippingMethedDraft()).executeBlocking().getBody();

   return shippingMethod;
    }

    public void deleteShippingMethodbykey(String key, ProjectApiRoot apiRoot) {
        apiRoot.shippingMethods().withKey(key).delete().executeBlocking();
    }

    public void deleteShippingMethodbyId(String id, ProjectApiRoot apiRoot) {
        apiRoot.shippingMethods().withId(id).delete().executeBlocking();
    }

    public ShippingMethod getShippingMethodbyId(String id, ProjectApiRoot apiRoot) {
        ShippingMethod shippingMethod=apiRoot.shippingMethods().withId(id).get().executeBlocking().getBody();
return shippingMethod;
    }

    public ShippingMethod getShippingMethodbyKey(String key, ProjectApiRoot apiRoot) {
        ShippingMethod shippingMethod=apiRoot.shippingMethods().withKey(key).get().executeBlocking().getBody();
        return shippingMethod;
    }
}
