package org.example.taxs;

import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.Versioned;
import com.commercetools.api.models.tax_category.*;
import org.example.clients.Client;

public class TaxDataProvider {
    ProjectApiRoot apiRoot = Client.createApiClient();
    SubRate createSubRateTax(){
       return SubRateBuilder.of().name("dfjshd").amount(0.5).build();
    }
    TaxRateDraft createRateforTax(){
       return TaxRateDraft.builder().name("RajasthanTax").country("IN").amount(0.1).includedInPrice(false).state("Rajasthan").build();
    }
    TaxCategoryDraft createtaxCategaryDraft(){
          return TaxCategoryDraft.builder().name("arvinddeledtexcatagry").description("disdc").key("codederKey").rates(createRateforTax()).build();
    }
    public TaxCategory addTaxCatagary(ProjectApiRoot apiRoot) {
        return this.apiRoot.taxCategories().post(createtaxCategaryDraft()).executeBlocking().getBody();
    }

    public void deleteTaxCategaryById(String taxCategryId,ProjectApiRoot apiRoot) {
        apiRoot.taxCategories().withId(taxCategryId).delete().addVersion(1).executeBlocking();
    }

    public void deleteTaxCategaryByKey(String key, ProjectApiRoot apiRoot) {
        apiRoot.taxCategories().withKey(key).delete().addVersion(1).executeBlocking();
    }

    public TaxCategory getTaxCategaryById(String id, ProjectApiRoot apiRoot) {
        TaxCategory taxCategory=apiRoot.taxCategories().withId(id).get().executeBlocking().getBody();
        System.out.println(taxCategory.getName()+" "+taxCategory.getName()+" "+taxCategory.getDescription());

   return taxCategory; }

    public TaxCategory getTaxCategaryByKey(String key, ProjectApiRoot apiRoot) {

        TaxCategory taxCategory=apiRoot.taxCategories().withKey(key).get().executeBlocking().getBody();
        System.out.println(taxCategory.getName()+" "+taxCategory.getName()+" "+taxCategory.getDescription());

        return taxCategory;
    }

    public void updateTaxCategaeyById(String id, ProjectApiRoot apiRoot) {
        apiRoot.taxCategories().update(updateTaxCategaeybyId(id,apiRoot));
    }

    private Versioned<TaxCategory> updateTaxCategaeybyId(String id, ProjectApiRoot apiRoot) {
         TaxRateDraft.builder().name("yy").country("IN").amount(0.1).includedInPrice(false).state("Rajasthan").build();

        TaxCategoryDraft.builder().name("yy").description("yy").key("yy").rates(createRateforTax()).build();
        TaxCategoryPagedQueryResponse taxCategoryPagedQueryResponse=apiRoot.taxCategories().get().withWhere("id=:id","id",id).executeBlocking().getBody();

        return this.apiRoot.taxCategories().post(createtaxCategaryDraft()).executeBlocking().getBody();
    }

    public TaxCategory updateTaxCategory(TaxCategoryUpdate taxCategoryUpdate, TaxCategory taxCategoryToUpdate,ProjectApiRoot apiRoot) {
        TaxCategory taxCategory= apiRoot.taxCategories().withId(taxCategoryToUpdate.getId()).post(taxCategoryUpdate).executeBlocking().getBody();
    return taxCategory;
    }
}
