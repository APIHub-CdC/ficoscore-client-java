package io.ficoscore.client.api;

import io.ficoscore.client.ApiClient;
import io.ficoscore.client.ApiException;
import io.ficoscore.client.ApiResponse;
import io.ficoscore.client.Configuration;
import io.ficoscore.client.Pair;
import io.ficoscore.client.ProgressRequestBody;
import io.ficoscore.client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;
import io.ficoscore.client.model.Peticion;
import io.ficoscore.client.model.Respuesta;

import java.io.IOException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FicoscoreApi {
    private ApiClient apiClient;
    public FicoscoreApi() {
        this(Configuration.getDefaultApiClient());
    }
    public FicoscoreApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }
    public ApiClient getApiClient() {
        return apiClient;
    }
    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }
    
    public okhttp3.Call ficoscoreCall(String xApiKey, String username, String password, Peticion request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request;
        String localVarPath = "";
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
            "application/json"
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

    private okhttp3.Call ficoscoreValidateBeforeCall(String xApiKey, String username, String password, Peticion request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        if (xApiKey == null) {
            throw new ApiException("Missing the required parameter 'xApiKey' when calling pld(Async)");
        }
        if (username == null) {
            throw new ApiException("Missing the required parameter 'username' when calling pld(Async)");
        }
        if (password == null) {
            throw new ApiException("Missing the required parameter 'password' when calling pld(Async)");
        }
        if (request == null) {
            throw new ApiException("Missing the required parameter 'request' when calling pld(Async)");
        }
        
        okhttp3.Call call = ficoscoreCall(xApiKey, username, password, request, progressListener, progressRequestListener);
        return call;
    }
    
    public Respuesta ficoscore(String xApiKey, String username, String password, Peticion request) throws ApiException {
        ApiResponse<Respuesta> resp = ficoscoreWithHttpInfo(xApiKey, username, password, request);
        return resp.getData();
    }
    
    public ApiResponse<Respuesta> ficoscoreWithHttpInfo(String xApiKey, String username, String password, Peticion request) throws ApiException {
        okhttp3.Call call = ficoscoreValidateBeforeCall(xApiKey, username, password, request, null, null);
        Type localVarReturnType = new TypeToken<Respuesta>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

}
