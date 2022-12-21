package org.example.product;

import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.product_type.ProductType;
import com.commercetools.api.models.product_type.ProductTypeDraft;
import org.example.clients.Client;
import org.example.customer.CustomerDataProvider;

public class ProductDataProvider {
    CustomerDataProvider customerDataProvider;
    ProductDataProvider productDataProvider;
    ProjectApiRoot apiRoot = Client.createApiClient();
//    public Product createProduct(ProductDraft productDraft) {
//        ByProjectKeyProductsRequestBuilder byProjectKeyProductsRequestBuilder =apiRoot.products();
//        ByProjectKeyProductsPost byProjectKeyProductsPost=byProjectKeyProductsRequestBuilder.post(productDraft);
//        ApiHttpResponse<Product>  ApiHttpResponse=byProjectKeyProductsPost.executeBlocking();
//        Product Product=ApiHttpResponse.getBody();
//        ProductTypeReference ProductTypeReference=Product.getProductType();
//        return apiRoot.products().post(productDraft).executeBlocking().getBody();
//    }

   public ProductType createProduct(ProductTypeDraft productTypeDraft) {
    return apiRoot.productTypes().post(productTypeDraft).executeBlocking().getBody();
}
}
