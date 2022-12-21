package org.example;

import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.customer.Customer;
import com.commercetools.api.models.customer.CustomerPagedQueryResponse;
import com.commercetools.api.models.product.Product;
import com.commercetools.api.models.product_type.ProductType;
import com.commercetools.api.models.product_type.ProductTypeDraft;
import com.commercetools.api.models.project.Project;
import org.example.clients.Client;
import org.example.customer.CustomerService;
import org.example.taxs.TaxApi;
import org.example.product.ProductService;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
   static CustomerService coustomerService=new CustomerService();
   static ProductService productService=new ProductService();
    static TaxApi taxApi=new TaxApi();
  static   ProjectApiRoot apiRoot = Client.createApiClient();
   static Project myProject = apiRoot.get()
            .executeBlocking()
            .getBody();

    public static void main( String[] args )
    {
//        System.out.println(myProject.getName());


//       taxApi.useTaxApi(apiRoot);

//  createCustomer();
//      String RandomCustomerId  ="aa01961a-2bee-478c-bd14-49a0667702ca";
//      String RandomCustomerEmail="johnfddoe@example.com";
////      getCustomerByid(RandomCustomerId);
//        getCustomerByEmail(RandomCustomerEmail);

//        CustomerPagedQueryResponse customerPagedQueryResponse=getCustomerByFirstName("Aayu",apiRoot);
//        System.out.println("CoutmerID"+" : "+customerPagedQueryResponse.getResults().get(0).getId());
//        System.out.println("CoutmerFirstName"+" : "+customerPagedQueryResponse.getResults().get(0).getFirstName());
//        System.out.println("CoutmerLastName"+" : "+customerPagedQueryResponse.getResults().get(0).getLastName());
//        System.out.println("CoutmerEmail"+" : "+customerPagedQueryResponse.getResults().get(0).getEmail());
//        System.out.println("CoutmerPassword"+" : "+customerPagedQueryResponse.getResults().get(0).getPassword());

//        CustomerPagedQueryResponse customerPagedQueryResponse1=getCustomerByLastName("kr",apiRoot);
//        System.out.println("CoutmerID"+" : "+customerPagedQueryResponse1.getResults().get(0).getId());
//        System.out.println("CoutmerFirstName"+" : "+customerPagedQueryResponse1.getResults().get(0).getFirstName());
//        System.out.println("CoutmerLastName"+" : "+customerPagedQueryResponse1.getResults().get(0).getLastName());
//        System.out.println("CoutmerEmail"+" : "+customerPagedQueryResponse1.getResults().get(0).getEmail());
//        System.out.println("CoutmerPassword"+" : "+customerPagedQueryResponse1.getResults().get(0).getPassword());

//        CustomerPagedQueryResponse customerPagedQueryResponse2=getCustomerByEmail("ayushman1621@gmail.com");
//        System.out.println("CoutmerID"+" : "+customerPagedQueryResponse2.getResults().get(0).getId());
//        System.out.println("CoutmerFirstName"+" : "+customerPagedQueryResponse2.getResults().get(0).getFirstName());
//        System.out.println("CoutmerLastName"+" : "+customerPagedQueryResponse2.getResults().get(0).getLastName());
//        System.out.println("CoutmerEmail"+" : "+customerPagedQueryResponse2.getResults().get(0).getEmail());
//        System.out.println("CoutmerPassword"+" : "+customerPagedQueryResponse2.getResults().get(0).getPassword());
//
        String customerId="b2cc798a-4b18-47e3-9744-f90cccb1c4f9";
//        updateCustomer(createCustomer());
        updateCustomerById(customerId);
//        singleCustomerbyId(apiRoot );
//        deleteCustomerbyEmail();

//        addBillingAddress("");
//        deleteCustomerbyId("c6fef5ed-4aad-4085-a0da-0e8b101dcc8f",apiRoot);
    }

    private static void updateCustomerById(String customerId) {
       Customer customer= getCustomerByid(customerId);
        Customer  updatedCustomer= coustomerService.updateCustomerNames(customer);

    }

    private static void addBillingAddress(Customer customer) {
//        getCustomerByid(s);

    }

    public  static void singleCustomerbyId(ProjectApiRoot apiRoot){
    Customer customerInfo = apiRoot
            .customers()
            .withId("")
            .get()
            .executeBlocking()
            .getBody();

}

    private static void deleteCustomerbyId(String customerId,ProjectApiRoot apiRoot) {

//        apiRoot.customers().withId(customerId).delete().executeBlocking();
        apiRoot.customers().withId(customerId).delete().addVersion(1).executeBlocking();

    }
    private static void deleteCustomerbyKey(String customerkey,ProjectApiRoot apiRoot) {

//        apiRoot.customers().withId(customerId).delete().executeBlocking();
        apiRoot.customers().withId(customerkey).delete().addVersion(1).executeBlocking();

    }




    public static Product createProduct(){
        ProductType productType =productService.createProductType();
        return productService.createproduct((ProductTypeDraft) productType);

    }
    public static ProductType createProductType(){
        ProductType productType =productService.createProductType();
        System.out.println(productType.getName());
        return productType;
    }

    public static Customer createCustomer(){

      Customer customer=  coustomerService.createCustomer("arvinddd@example.com","dasfhas");
        String customerid=customer.getId();

        String customerEmail=customer.getEmail();
        List customerAddress=customer.getAddresses();
        System.out.println(customerid);
        System.out.println(customerEmail);
        System.out.println(customerAddress.getClass());
        System.out.println(customer.getPassword());
        return customer;
    }
        public static Customer getCustomerByid(String id){
            Customer customer=coustomerService.getCustomerById(id);
            return customer;
        }
    public static CustomerPagedQueryResponse getCustomerByEmail(String email){
        CustomerPagedQueryResponse customerPagedQueryResponse=coustomerService.getCustomerByEmail(email);
        return customerPagedQueryResponse;
    }
    public static CustomerPagedQueryResponse getCustomerByFirstName(String firstName,ProjectApiRoot apiRoot){
          CustomerPagedQueryResponse customerPagedQueryResponse= coustomerService.getCustomerByFirstName(firstName,apiRoot);
        return customerPagedQueryResponse;
    }
    private static CustomerPagedQueryResponse getCustomerByLastName(String lastNAme, ProjectApiRoot apiRoot) {
        CustomerPagedQueryResponse customerPagedQueryResponse= coustomerService.getCustomerByLastName(lastNAme,apiRoot);
        return customerPagedQueryResponse;
    }

public static Customer updateCustomer(Customer customer){
    System.out.println(customer.getId());
    System.out.println("fi"+" "+customer.getFirstName());
    System.out.println("se"+" "+customer.getLastName());
    System.out.println(customer.getAddresses());
    System.out.println(customer.getEmail());


    Customer  updatedCustomer= coustomerService.updateCustomerNames(customer);
    System.out.println(updatedCustomer.getId());
    System.out.println("fi"+" "+updatedCustomer.getFirstName());
    System.out.println("se"+" "+updatedCustomer.getLastName());
    System.out.println(updatedCustomer.getEmail());
    return null;
}


    }


