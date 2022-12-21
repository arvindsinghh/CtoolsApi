package org.example.taxs;

import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.tax_category.TaxCategory;

public class TaxApi {
    TaxService taxService=new TaxService();
    public void useTaxApi(ProjectApiRoot apiRoot){
      TaxCategory taxCategory=addTaxCatagary(apiRoot);
// deleteTaxCategaryById(apiRoot,taxCategoryId);
//        deleteTaxCategaryByKey(apiRoot,taxCategory.getKey());
//        getTaxCategaryById(taxCategory.getId(),apiRoot);
//        getTaxCategaryByKey(taxCategory.getKey(),apiRoot);
//        updateTaxCategaey(taxCategory,apiRoot);
        System.out.println(updateTaxCategaey(taxCategory,apiRoot).getName());
    }

    private TaxCategory updateTaxCategaey(TaxCategory taxCategoryToUpdate, ProjectApiRoot apiRoot) {
   return    taxService.updateTaxCategaey(taxCategoryToUpdate,apiRoot);
    }

    private void updateTaxCategaeyById(String id, ProjectApiRoot apiRoot) {
         taxService.updateTaxCategaeyById(id,apiRoot);
    }


    private TaxCategory getTaxCategaryByKey(String key, ProjectApiRoot apiRoot) {
        return taxService.getTaxCategaryByKey(key,apiRoot);
    }

    private TaxCategory getTaxCategaryById(String id, ProjectApiRoot apiRoot) {
        return taxService.getTaxCategaryById(id,apiRoot);
    }

    private void deleteTaxCategaryByKey(ProjectApiRoot apiRoot, String key) {
        taxService.deleteTaxCategaryByKey(key,apiRoot);
    }

    private void deleteTaxCategaryById(ProjectApiRoot apiRoot,String taxCategoryId) {
        taxService.deleteTaxCategaryById( taxCategoryId,apiRoot);
    }

    TaxCategory addTaxCatagary(ProjectApiRoot apiRoot) {
        TaxCategory taxCategory=taxService.addTaxCatagary(apiRoot);
        return taxCategory;
    }
}
