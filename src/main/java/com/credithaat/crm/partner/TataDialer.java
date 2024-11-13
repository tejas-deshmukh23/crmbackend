package com.credithaat.crm.partner;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class TataDialer {

	public static JSONObject clickToCall(String agent_number, String destination_number, String caller_id) {
		
		try {
			HttpClient http = HttpClients.custom().build();
			HttpPost post = new HttpPost("https://api-smartflo.tatateleservices.com/v1/click_to_call");
			post.addHeader("Content-Type", "application/json");
			post.addHeader("Authorization","eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1MDg0NzMiLCJpc3MiOiJodHRwczovL2Nsb3VkcGhvbmUudGF0YXRlbGVzZXJ2aWNlcy5jb20vdG9rZW4vZ2VuZXJhdGUiLCJpYXQiOjE3MjM4ODAxMjAsImV4cCI6MjAyMzg4MDEyMCwibmJmIjoxNzIzODgwMTIwLCJqdGkiOiJFS01YMVhPdEZXV0pHaVRNIn0.qvVMw77J9wUdPGTupsX_u4viBKNvNRAD-a99Ak1h_Lo");
			 
			Map<String, Object> data = new HashMap<>();
			data.put("async", 1);
			data.put("agent_number", agent_number);
			data.put("destination_number", destination_number);
			data.put("caller_id", caller_id);

			String payload = new JSONObject(data).toString();
			StringEntity entity = new StringEntity(payload);
			post.setEntity(entity);
			HttpResponse response = http.execute(post);
			String jsonStr = EntityUtils.toString(response.getEntity());
			JSONObject json = new JSONObject(jsonStr);
			return json;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
