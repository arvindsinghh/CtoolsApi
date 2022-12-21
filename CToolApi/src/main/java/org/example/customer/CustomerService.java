package org.example.customer;

import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.common.*;
import com.commercetools.api.models.customer.*;
import com.commercetools.api.models.customer.CustomerPagedQueryResponse;
import com.commercetools.api.models.customer_group.CustomerGroupDraft;
import com.commercetools.api.models.customer_group.CustomerGroupResourceIdentifier;
import org.jetbrains.annotations.Nullable;

import java.time.LocalDate;

public class CustomerService {
    private CustomerDataProvider customerDataProvider=new CustomerDataProvider();
    public  AddressDraft createAddress(@Nullable String city, String countrycode, String buildingName, String street){
        AddressDraft addressDraft=AddressDraft.builder().city(city).country(countrycode).building(buildingName).build();
        return addressDraft;
    }
   public CustomerGroupDraft createCustomerGroup(){
       CustomerGroupDraft customerGroupDraft=CustomerGroupDraft.builder().groupName("CommerceTool").key("CommerceToolKey").build();
       return customerGroupDraft;
   }
   public CustomerGroupResourceIdentifier customerGroupResourceIdentifierBuilder(){
       CustomerGroupResourceIdentifier customerGroupResourceIdentifier=CustomerGroupResourceIdentifier.builder().id("CommerceTool").build();
       return customerGroupResourceIdentifier;
   }
    public Customer createCustomer(String email,String pass){
        CustomerGroupDraft customerGroupDraft=createCustomerGroup();
        System.out.println(customerGroupDraft.getGroupName());
//        CustomerDraft customerDraft=CustomerDraft.builder()
//                .email("java-sdk@example.com")
//                .password("password")
//                .build();
        LocalDate birthDate = LocalDate.of(Integer.parseInt("2000"), Integer.parseInt("2"), Integer.parseInt("15"));
        CustomerDraft newCustomerDraft = CustomerDraft.builder()
                .email(email)
                .password(pass).firstName("ram").lastName("singh")
                .externalId("65723").companyName("HybrisWorld")
                .addresses(createAddress("jaipur","IN","buildingName","Street")).dateOfBirth(birthDate)
                .middleName("Rawat").customerNumber("123434").salutation("Mr.").title("Mr.").vatId("23")
                .build();
        CustomerDraft.builder(newCustomerDraft);

return customerDataProvider.createCustomer(newCustomerDraft);
    }

    public Customer getCustomerById(String id){
        return customerDataProvider.getCustomerById(id);
    }

    public CustomerPagedQueryResponse getCustomerByEmail(String email) {
        return customerDataProvider.getCustomerByEmail(email);
    }

    public CustomerPagedQueryResponse getCustomerByFirstName(String firstName, ProjectApiRoot apiRoot) {return customerDataProvider.getCustomerByFirstName(firstName,apiRoot);}

    public CustomerPagedQueryResponse getCustomerByLastName(String lastNAme, ProjectApiRoot apiRoot) {return customerDataProvider.getCustomerBylastName(lastNAme,apiRoot);
    }
    public Customer updateCustomerNames(Customer customerToUpdate){
        BaseAddress baseAddress= BaseAddressBuilder.of().city("delhi").apartment("bdsh").country("IN").build();
        CustomerChangeAddressAction customerChangeAddressAction=CustomerUpdateActionBuilder.of().changeAddressBuilder().addressId(customerToUpdate.getAddresses().get(0).getId()).address(baseAddress).build();
//        List<CustomerAddAddressActionBuilder> list=new ArrayList<CustomerAddAddressActionBuilder>();
//        CustomerAddAddressActionBuilder customerAddAddressActionBuilder=CustomerUpdateActionBuilder.of().addAddressBuilder().address(baseAddress).build();
//        list.add(customerAddAddressActionBuilder);
        Long version=customerToUpdate.getVersion();
        CustomerUpdateBuilder customerUpdateBuilder=CustomerUpdate.builder();
        CustomerUpdateBuilder customerUpdateBuilder1= customerUpdateBuilder.version(version);
//        CustomerUpdateBuilder  customerUpdateBuilder2=customerUpdateBuilder1.plusActions(actioBuilder ->actioBuilder.setFirstNameBuilder().firstName("Aayu"));
//        CustomerUpdateBuilder customerUpdateBuilder3=customerUpdateBuilder2.plusActions(actionBuilder -> actionBuilder.setLastNameBuilder().lastName("fhjs"));
        customerUpdateBuilder1.actions(customerChangeAddressAction);
        CustomerUpdate customerUpdate=customerUpdateBuilder1.build();
//        CustomerUpdate customerUpdate=CustomerUpdate.builder().version(customerToUpdate.getVersion()).plusActions(actionBuilder ->actionBuilder.setFirstNameBuilder().firstName("Aayu") )
//                .plusActions(actionBuilder -> actionBuilder.setLastNameBuilder().lastName("fhjs")).build();
        return customerDataProvider.updateCustomer(customerUpdate,customerToUpdate );
    }

    public void deleteCustomerbyEmail(String id) {
        customerDataProvider.deleteCustomerbyEmail(id);
    }
}
