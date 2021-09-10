package com.laurentiuspilca.jwtresourceserver.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpEntity;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laurentiuspilca.jwtresourceserver.request.LoginRequest;

@RestController
public class LoginController {
	@Value("${client.id}")
	private String clientid;
	@Value("${client.secret}")
	private String clientsecret;
	@PostMapping("/login")
	public String login(@RequestBody LoginRequest re) {
		try {
			String url = "http://localhost:8081/oauth/token?grant_type=password&username=" + re.getUsername()
					+ "&password=" + re.getPassword();
			HttpPost request = new HttpPost(url);
			CredentialsProvider provider = new BasicCredentialsProvider();
			provider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(clientid, clientsecret));

			try (CloseableHttpClient httpClient = HttpClientBuilder.create().setDefaultCredentialsProvider(provider)
					.build(); CloseableHttpResponse response = httpClient.execute(request)) {

				HttpEntity entity = response.getEntity();
				if (entity != null) {
					String result = EntityUtils.toString(entity);
					System.out.println(result);
					return result;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}

}
