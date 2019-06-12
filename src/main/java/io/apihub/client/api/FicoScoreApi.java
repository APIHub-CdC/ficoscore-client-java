package io.apihub.client.api;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;

import io.apihub.client.ApiClient;
import io.apihub.client.ApiException;
import io.apihub.client.ApiResponse;
import io.apihub.client.Configuration;
import io.apihub.client.Pair;
import io.apihub.client.ProgressRequestBody;
import io.apihub.client.ProgressResponseBody;
import io.apihub.client.model.Persona;
import io.apihub.client.model.Response;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FicoScoreApi {
    private ApiClient apiClient;

    public FicoScoreApi() {
        this(Configuration.getDefaultApiClient());
    }

    public FicoScoreApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public okhttp3.Call ficoscoreCall(String xApiKey, String username, String password, Persona body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;

        // create path and map variables
        String localVarPath = "/v1/ficoscore";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (xApiKey != null)
        localVarHeaderParams.put("x-api-key", apiClient.parameterToString(xApiKey));
        if (username != null)
        localVarHeaderParams.put("username", apiClient.parameterToString(username));
        if (password != null)
        localVarHeaderParams.put("password", apiClient.parameterToString(password));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "*/*"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new okhttp3.Interceptor() {
                @Override
                public okhttp3.Response intercept(okhttp3.Interceptor.Chain chain) throws IOException {
                    okhttp3.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    private okhttp3.Call ficoscoreValidateBeforeCall(String xApiKey, String username, String password, Persona body) throws ApiException {
        
        // verify the required parameter 'xApiKey' is set
        if (xApiKey == null) {
            throw new ApiException("Missing the required parameter 'xApiKey' when calling ficoscore(Async)");
        }
        
        // verify the required parameter 'username' is set
        if (username == null) {
            throw new ApiException("Missing the required parameter 'username' when calling ficoscore(Async)");
        }
        
        // verify the required parameter 'password' is set
        if (password == null) {
            throw new ApiException("Missing the required parameter 'password' when calling ficoscore(Async)");
        }
        
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new ApiException("Missing the required parameter 'body' when calling ficoscore(Async)");
        }
        

        okhttp3.Call call = ficoscoreCall(xApiKey, username, password, body, null, null);
        return call;

    }

    /**
     * 
     * 
     * @param xApiKey ConsumerKey obtenido desde el portal de desarrolladores (required)
     * @param username Usuario de Círculo de Crédito (required)
     * @param password Contraseña de Círculo de Crédito (required)
     * @param body  (required)
     * @return Response
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Response ficoscore(String xApiKey, String username, String password, Persona body) throws ApiException {
        ApiResponse<Response> resp = ficoscoreWithHttpInfo(xApiKey, username, password, body);
        return resp.getData();
    }

    /**
     * 
     * 
     * @param xApiKey ConsumerKey obtenido desde el portal de desarrolladores (required)
     * @param username Usuario de Círculo de Crédito (required)
     * @param password Contraseña de Círculo de Crédito (required)
     * @param body  (required)
     * @return ApiResponse&lt;Response&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Response> ficoscoreWithHttpInfo(String xApiKey, String username, String password, Persona body) throws ApiException {
        okhttp3.Call call = ficoscoreValidateBeforeCall(xApiKey, username, password, body);
        Type localVarReturnType = new TypeToken<Response>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }
}
