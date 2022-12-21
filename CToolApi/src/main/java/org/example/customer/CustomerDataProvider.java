package org.example.customer;

import com.commercetools.api.client.*;
import com.commercetools.api.models.customer.*;
import com.commercetools.api.models.customer.CustomerPagedQueryResponse;
import com.commercetools.api.models.product.ProductPagedQueryResponse;
import io.vrap.rmf.base.client.ApiHttpResponse;
import org.example.clients.Client;

public class CustomerDataProvider {
    ProjectApiRoot apiRoot = Client.createApiClient();

    public Customer createCustomer(CustomerDraft customerDraft) {
//        ByProjectKeyCustomersRequestBuilder byProjectKeyCustomersRequestBuilder=apiRoot.customers();
//        ByProjectKeyCustomersPost byProjectKeyCustomersPost=byProjectKeyCustomersRequestBuilder.post(customerDraft);
//        ApiHttpResponse<CustomerSignInResult> apiHttpResponse=byProjectKeyCustomersPost.executeBlocking();
//        CustomerSignInResult customerSignInResult=apiHttpResponse.getBody();
//        Customer customer=customerSignInResult.getCustomer();
//        return customer;
        return apiRoot.customers().post(customerDraft).executeBlocking().getBody().getCustomer();
    }

    public Customer getCustomerById(String id) {

        return apiRoot.customers().withId(id).get().executeBlocking().getBody();
    }

    public CustomerPagedQueryResponse getCustomerByEmail(String email) {
        return apiRoot.customers().get().withWhere("email = :gvvyfgy", "gvvyfgy", email).executeBlocking().getBody();
    }

    public CustomerPagedQueryResponse getCustomerByFirstName(String firstName,ProjectApiRoot projectApiRoot) {
        CustomerPagedQueryResponse customerToFind = projectApiRoot
                .customers()
                .get()
                .withWhere("firstName = :gvvyfgy", "gvvyfgy", firstName)
                .executeBlocking()
                .getBody();
return customerToFind;
//        List<String> a = new ArrayList<String>();
//        String.valueOf(a);
//
//// Output the Customer's details. As email addresses must be unique, the first value of the results (0) should be accurate
//        String customerID = customerToFind.getResults().get(0).getId();
//
//        System.out.println(customerID);
//        System.out.println(customerToFind.getResults().get(0).getAddresses());
//        //        return apiRoot.customers().withKey(email).get().executeBlocking().getBody();

    }

    public CustomerPagedQueryResponse getCustomerBylastName(String lastNAme, ProjectApiRoot apiRoot) {
        CustomerPagedQueryResponse customerToFind = apiRoot
                .customers()
                .get()
                .withWhere("lastName = :gvvyfgy", "gvvyfgy", lastNAme)
                .executeBlocking()
                .getBody();
        return customerToFind;
    }
    public Customer createProduct(CustomerDraft customerDraft) {
        ByProjectKeyCustomersRequestBuilder byProjectKeyCustomersRequestBuilder=apiRoot.customers();
        ByProjectKeyCustomersPost byProjectKeyCustomersPost=byProjectKeyCustomersRequestBuilder.post(customerDraft);
        ApiHttpResponse<CustomerSignInResult> apiHttpResponse=byProjectKeyCustomersPost.executeBlocking();
        CustomerSignInResult customerSignInResult=apiHttpResponse.getBody();
        Customer customer=customerSignInResult.getCustomer();
        return customer;
    }


    public ProductPagedQueryResponse getProductById(String productId) {
        return apiRoot.products().get().withWhere("id = :id", "gvvyfgy", "").executeBlocking().getBody();
    }

    public Customer updateCustomer(CustomerUpdate customerUpdate,Customer customerToUpdate){
       String customerId= customerToUpdate.getId();
        ByProjectKeyCustomersRequestBuilder byProjectKeyCustomersRequestBuilder=apiRoot.customers();
        ByProjectKeyCustomersByIDRequestBuilder byProjectKeyCustomersByIDRequestBuilder= byProjectKeyCustomersRequestBuilder.withId(customerId);
        ByProjectKeyCustomersByIDPost byProjectKeyCustomersByIDPost=byProjectKeyCustomersByIDRequestBuilder.post(customerUpdate);
        ApiHttpResponse<Customer> apiHttpResponse =byProjectKeyCustomersByIDPost.executeBlocking();
        Customer customer= apiHttpResponse.getBody();

        return customer;
    }

    public void deleteCustomerbyEmail(String id) {
apiRoot.customers().withId(id).delete().withQueryParam("id",id).executeBlocking().getBody();
//        apiRoot.customers().get().withWhere("email = :gvvyfgy", "gvvyfgy", email).executeBlocking().getBody().withCustomerPagedQueryResponse();
//        apiRoot.customers().withId(id)
    }


}
