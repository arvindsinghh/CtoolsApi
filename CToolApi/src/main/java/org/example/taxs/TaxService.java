package org.example.taxs;

import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.tax_category.*;

public class TaxService {
    TaxDataProvider taxDataProvider=new TaxDataProvider();
    public TaxCategory addTaxCatagary(ProjectApiRoot apiRoot) {
        return taxDataProvider.addTaxCatagary(apiRoot);
    }

    public void deleteTaxCategaryById(String taxCategryId,ProjectApiRoot apiRoot) {
        taxDataProvider.deleteTaxCategaryById(taxCategryId,apiRoot);
    }

    public void deleteTaxCategaryByKey(String key, ProjectApiRoot apiRoot) {
        taxDataProvider.deleteTaxCategaryByKey(key,apiRoot);
    }

    public TaxCategory getTaxCategaryById(String id, ProjectApiRoot apiRoot) {
       return taxDataProvider.getTaxCategaryById(id,apiRoot);

    }

    public TaxCategory getTaxCategaryByKey(String key, ProjectApiRoot apiRoot) {
        return taxDataProvider.getTaxCategaryByKey(key,apiRoot);
    }

    public void updateTaxCategaeyById(String id, ProjectApiRoot apiRoot) {
        taxDataProvider.updateTaxCategaeyById(id, apiRoot);
    }

    public TaxCategory updateTaxCategaey(TaxCategory taxCategoryToUpdate, ProjectApiRoot apiRoot) {
        TaxCategoryUpdate taxCategoryUpdate= TaxCategoryUpdate.builder().version(taxCategoryToUpdate.getVersion()).plusActions(as->as.setDescriptionBuilder().description("fnsdhfsjdfh")).build();
        TaxCategory taxCategory=taxDataProvider.updateTaxCategory(taxCategoryUpdate,taxCategoryToUpdate,apiRoot);
    return taxCategory;
    }
}
