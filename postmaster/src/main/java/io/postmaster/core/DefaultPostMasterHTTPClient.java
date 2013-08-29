package io.postmaster.core;

import io.postmaster.errors.HTTPError;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;

@SuppressWarnings("deprecation")
public class DefaultPostMasterHTTPClient {

	private static final int CONNECTION_TIMEOUT = 10000;
	private static final int SOCKET_TIMEOUT = 60000;
	private static final String CONTENT_TYPE_ACCEPT = "application/json";
	private static final String CONTENT_TYPE_SEND = "application/json";

	private String userAgent;
	protected int connectionTimeout;
	protected int socketTimeout;
	protected String key;
	private DefaultHttpClient httpClient;

	public void setConnectionTimeout(int connectionTimeout) {
		this.connectionTimeout = connectionTimeout;
	}

	public void setSocketTimeout(int socketTimeout) {
		this.socketTimeout = socketTimeout;
	}

	protected DefaultPostMasterHTTPClient(String key) {

		if (key == null) {
			throw new RuntimeException("API key must be provided");
		}

		this.userAgent = String.format("Postmaster/%d (Java)",
				Settings.LIB_VERSION);
		this.key = key;
		this.connectionTimeout = CONNECTION_TIMEOUT;
		this.socketTimeout = SOCKET_TIMEOUT;

		this.httpClient = getNewHttpClient();

		this.httpClient.getParams().setParameter("http.protocol.version",
				HttpVersion.HTTP_1_1);
		this.httpClient.getParams().setParameter(
				"http.protocol.content-charset", "UTF-8");

	}

	public JSONObject get(String path, Map<String, String> params)
			throws HTTPError {
		URI uri = buildUri(path, params);
		HttpGet request = new HttpGet(uri);
		addHeaders(request);
		return prepareRequestAndExtractResponse(request);
	}

	public JSONObject get(String path) throws HTTPError {
		return get(path, new HashMap<String, String>());
	}

	public JSONObject delete(String path, Map<String, String> params)
			throws HTTPError {
		URI uri = buildUri(path, params);
		HttpDelete request = new HttpDelete(uri);
		addHeaders(request);
		return prepareRequestAndExtractResponse(request);
	}

	public JSONObject delete(String path) throws HTTPError {
		return delete(path, new HashMap<String, String>());
	}

	public JSONObject put(String path, Object entity, String serializedJson)
			throws HTTPError {
		URI uri = buildUri(path);
		HttpPut request = new HttpPut(uri);
		addHeaders(request);

		if (serializedJson == null) {
			serializedJson = serialize(entity);
		}

		try {
			request.setEntity(new StringEntity(serializedJson));
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
		return prepareRequestAndExtractResponse(request);
	}

	public JSONObject post(String path, Object entity, String serializedJson)
			throws HTTPError {
		URI uri = buildUri(path);
		HttpPost request = new HttpPost(uri);
		addHeaders(request);
		if (serializedJson == null) {
			serializedJson = serialize(entity);
		}
		try {
			request.setEntity(new StringEntity(serializedJson));
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
		return prepareRequestAndExtractResponse(request);
	}

	private String buildQueryString(Map<String, String> params) {
		ArrayList<NameValuePair> nvs = new ArrayList<NameValuePair>(
				params.size());
		for (Map.Entry<String, String> entry : params.entrySet()) {
			NameValuePair nv = new BasicNameValuePair(entry.getKey(),
					entry.getValue());
			nvs.add(nv);
		}
		String queryString = URLEncodedUtils.format(nvs, "UTF-8");
		return queryString;
	}

	private URI buildUri(String path, Map<String, String> params) {
		StringBuilder sb = new StringBuilder();
		sb.append(Settings.API_DOMAIN);
		sb.append(path);
		if (params != null && params.size() > 0) {
			sb.append("?");
			sb.append(buildQueryString(params));
		}
		try {
			return new URI(sb.toString());
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}
	}

	private URI buildUri(String path) {
		return buildUri(path, null);
	}

	private void addHeaders(HttpUriRequest request) {
		request.addHeader(new BasicHeader("User-Agent", userAgent));
		request.addHeader(new BasicHeader("Accept", CONTENT_TYPE_ACCEPT));
		request.addHeader(new BasicHeader("Content-Type", CONTENT_TYPE_SEND));
	}

	private JSONObject prepareRequestAndExtractResponse(HttpUriRequest request)
			throws HTTPError {
		if (key != null) {
			String encoding = "";
			try {
				encoding = Base64.encodeBase64String((key + ":")
						.getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				throw new RuntimeException(e);
			}
			request.setHeader("Authorization", "Basic " + encoding + "=");
		}

		HttpResponse response;
		try {
			response = httpClient.execute(request);
		} catch (ClientProtocolException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		String body = null;
		HttpEntity entity = response.getEntity();
		if (entity != null) {
			try {
				body = EntityUtils.toString(entity);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		StatusLine status = response.getStatusLine();
		if (status.getStatusCode() >= 299
				&& !ContentType.APPLICATION_JSON.getMimeType().equals(
						(entity.getContentType() != null ? entity
								.getContentType().getValue() : null))) {
			throw new HTTPError(response, body);
		}

		JSONObject result;
		try {
			result = new JSONObject(body);
		} catch (JSONException e) {
			throw new RuntimeException(e);
		}

		return result;
	}

	private String serialize(Object entity) {
		Gson gson = new Gson();
		return gson.toJson(entity);
	}

	private DefaultHttpClient applyTimeout(DefaultHttpClient httpClient) {
		HttpParams httpParameters = httpClient.getParams();
		if (httpParameters == null) {
			httpParameters = new BasicHttpParams();
		}
		// Set the timeout in milliseconds until a connection is established.
		// The default value is zero, that means the timeout is not used.
		int timeoutConnection = this.connectionTimeout;
		HttpConnectionParams.setConnectionTimeout(httpParameters,
				timeoutConnection);
		// Set the default socket timeout (SO_TIMEOUT)
		// in milliseconds which is the timeout for waiting for data.
		int timeoutSocket = this.socketTimeout;
		HttpConnectionParams.setSoTimeout(httpParameters, timeoutSocket);

		httpClient.setParams(httpParameters);

		return httpClient;
	}

	private DefaultHttpClient getNewHttpClient() {

		DefaultHttpClient client = null;

		try {
			KeyStore trustStore = KeyStore.getInstance(KeyStore
					.getDefaultType());
			trustStore.load(null, null);

			SSLSocketFactory sf = new TrustedSSLSocketFactory(trustStore);
			sf.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);

			HttpParams params = new BasicHttpParams();

			ConnManagerParams.setMaxTotalConnections(params, 100);

			HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
			HttpProtocolParams.setContentCharset(params, HTTP.UTF_8);

			SchemeRegistry registry = new SchemeRegistry();
			registry.register(new Scheme("http", PlainSocketFactory
					.getSocketFactory(), 80));
			registry.register(new Scheme("https", sf, 443));

			ClientConnectionManager ccm = new ThreadSafeClientConnManager(
					params, registry);

			client = new DefaultHttpClient(ccm, params);
		} catch (Exception e) {
			client = new DefaultHttpClient();
		}

		client = applyTimeout(client);
		return client;
	}

	private class TrustedSSLSocketFactory extends SSLSocketFactory {
		SSLContext sslContext = SSLContext.getInstance("TLS");

		public TrustedSSLSocketFactory(KeyStore truststore)
				throws NoSuchAlgorithmException, KeyManagementException,
				KeyStoreException, UnrecoverableKeyException {
			super(truststore);

			TrustManager tm = new X509TrustManager() {
				public void checkClientTrusted(X509Certificate[] chain,
						String authType) throws CertificateException {
				}

				public void checkServerTrusted(X509Certificate[] chain,
						String authType) throws CertificateException {
				}

				public X509Certificate[] getAcceptedIssuers() {
					return null;
				}
			};

			sslContext.init(null, new TrustManager[] { tm }, null);
		}

		@Override
		public Socket createSocket(Socket socket, String host, int port,
				boolean autoClose) throws IOException, UnknownHostException {
			return sslContext.getSocketFactory().createSocket(socket, host,
					port, autoClose);
		}

		@Override
		public Socket createSocket() throws IOException {
			return sslContext.getSocketFactory().createSocket();
		}
	}

}
