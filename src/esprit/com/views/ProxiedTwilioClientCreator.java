/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.views;

import com.twilio.http.HttpClient;
import com.twilio.http.NetworkHttpClient;
import com.twilio.http.TwilioRestClient;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.impl.client.DefaultRedirectStrategy;

/**
 *
 * @author Utilisateur
 */
class ProxiedTwilioClientCreator {
    private  String username;
    private  String password;
    private  String proxyHost;
    private  int proxyPort;
    private HttpClient httpClient ;

    /**
     * Constructor for ProxiedTwilioClientCreator
     * @param username
     * @param password
     * @param proxyHost
     * @param proxyPort
     */
    public ProxiedTwilioClientCreator(String username, String password, String proxyHost, int proxyPort) {
        this.username = username;
        this.password = password;
        this.proxyHost = proxyHost;
        this.proxyPort = proxyPort;
    }

    /**
     * Creates a custom HttpClient based on default config as seen on:
     * {@link com.twilio.http.NetworkHttpClient#NetworkHttpClient() constructor}
     */
    private void createHttpClient() {
        RequestConfig config = RequestConfig.custom()
                .setConnectTimeout(10000)
                .setSocketTimeout(30500)
                .build();

        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setDefaultMaxPerRoute(10);
        connectionManager.setMaxTotal(10*2);

        HttpHost proxy = new HttpHost(proxyHost, proxyPort);

        HttpClientBuilder clientBuilder = HttpClientBuilder.create();
        clientBuilder
                .setConnectionManager(connectionManager)
                .setProxy(proxy)
                .setDefaultRequestConfig(config);

        // Inclusion of Twilio headers and build() is executed under this constructor
        this.httpClient = new NetworkHttpClient(clientBuilder);
    }

    /**
     * Get the custom client or builds a new one
     * @return a TwilioRestClient object
     */
    public TwilioRestClient getClient() {
        if (this.httpClient == null) {
            this.createHttpClient();
        }

        TwilioRestClient.Builder builder = new TwilioRestClient.Builder(username, password);
        return builder.httpClient(this.httpClient).build();
    }
}
