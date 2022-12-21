package org.example.product;

import com.commercetools.api.models.common.LocalizedString;
import com.commercetools.api.models.product.Product;
import com.commercetools.api.models.product.ProductDraft;
import com.commercetools.api.models.product_type.ProductType;
import com.commercetools.api.models.product_type.ProductTypeDraft;

public class ProductService {
    ProductDataProvider productDataProvider=new ProductDataProvider();
    public ProductType createProductType(){
        ProductTypeDraft productTypeDraft=ProductTypeDraft.builder().name("lotas").key("jdshds")
                .description("djshghsag")
                .build();
        return productDataProvider.createProduct(productTypeDraft);
    }

    public Product createproduct(ProductTypeDraft productTypeDraft) {
        String productName="dnns";
        ProductDraft productDraft=ProductDraft.builder().name(LocalizedString.ofEnglish("jhdjf"))
                .build();
        return null;
    }
}

