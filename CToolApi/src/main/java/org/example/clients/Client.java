package org.example.clients;
import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.defaultconfig.ApiRootBuilder;
import com.commercetools.api.defaultconfig.ServiceRegion;
import io.vrap.rmf.base.client.oauth2.*;

public class Client {
    private static String clientID="ZTtX-heagCgJGmRvnLcLl35N";
    private static String clientSecret="0dbrZ7JU05ZpksswxpowlQkkAYqYxSyA";
    private  static String projectKey="arvindapi";
    public static ProjectApiRoot createApiClient() {
        final ProjectApiRoot apiRoot = ApiRootBuilder.of()
                .defaultClient(ClientCredentials.of()
                                .withClientId(clientID)
                                .withClientSecret(clientSecret)
                                .build(),
                        ServiceRegion.AWS_EU_CENTRAL_1)
                .build(projectKey);
        return apiRoot;
    }
}
