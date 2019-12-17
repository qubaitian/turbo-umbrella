package com.qbt.demo.util;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class AppleTest {
    private String local = "http://localhost:8080";

    private RestTemplate restTemplate = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();

    {
        headers.set("Content-Type", "application/x-www-form-urlencoded");
        headers.set("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJmaGtqIiwic2NvcGUiOlsidGVzdCJdLCJleHAiOjE1NzYwODYzOTMsInVzZXJJZCI6NjAsImp0aSI6ImVmNTY1YjY3LTRlZmMtNDcxNS1iZTI2LTkxYjdmMDFlYjk4MiIsIm9hdXRoU3RhdHVzIjoyLCJjbGllbnRfaWQiOiJhcHBfMSJ9.lfRh0HUC6_CQQKu8Iv5x_rV3wLE4XaRovpbfYd62KsYmMDVp4_aSNhj1UeQifD-L_AFhd9KGm1qa6t8f8dYRsqQqdS5X_Efbk5W9E24rx0DhxlvkPujXQvDETBcdeD2TXhOc71q8zw-gM3cxV8if7_OsFxYGm-FC-5U7ncHe8vydRVyz1C2UtxZUglnc4Xidc5bsbvWs30mHIMh5sgpQr01U_6e04lauVg2BIf8U5tKc6HXceBHxCBS9jb-_q3apZHMbP9iQk4FWduo8YirCLhGXCE45IMaXJwt4biDP7ifE2bhaplmHl3rUNeoR1nVbtKW6VjJuT43B4N96T4tf_w");
    }

    @Test
    public void a1757() {
        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(local + "/contract", HttpMethod.GET, httpEntity, String.class);
        System.out.println(responseEntity.getStatusCode());
        System.out.println(responseEntity.getBody());
    }

    @Test
    public void generatorTest() {
        //add123
        postApples();
        getApples();
        getApplesById();
        //update12
        postApplesById();
        getApples();
        getApplesById();
        //deleteApplesById1
        deleteApplesById();
        getApples();
        getApplesById();
        List<String> list = Arrays.asList("1", "2", "3");

    }

    private void deleteApplesById() {
        String id = "" + 1;
        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(local + "/apples/" + id + "/delete", HttpMethod.POST, httpEntity, String.class);
        System.out.println(responseEntity.getStatusCode());
        System.out.println(responseEntity.getBody());
    }


    private void getApples() {
        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<Map> responseEntity = restTemplate.exchange(local + "/apples", HttpMethod.GET, httpEntity, Map.class);
        System.out.println(responseEntity.getStatusCode());
        System.out.println(responseEntity.getBody());
    }


    private void getApplesById() {
        for (int i = 1; i <= 3; i++) {
            String id = "" + i;
            HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(headers);
            ResponseEntity<Map> responseEntity = restTemplate.exchange(local + "/apples/" + id, HttpMethod.GET, httpEntity, Map.class);
            System.out.println(responseEntity.getStatusCode());
            System.out.println(responseEntity.getBody());
        }
    }


    private void postApples() {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("name", "qubaitian");
        for (int i = 1; i <= 3; i++) {
            HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(map, headers);
            ResponseEntity<String> responseEntity = restTemplate.exchange(local + "/apples", HttpMethod.POST, httpEntity, String.class);
            System.out.println(responseEntity.getStatusCode());
            System.out.println(responseEntity.getBody());
        }
    }

    private void postApplesById() {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("name", "qbt");
        for (int i = 1; i <= 2; i++) {
            String id = "" + i;
            HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(map, headers);
            ResponseEntity<String> responseEntity = restTemplate.exchange(local + "/apples/" + id, HttpMethod.POST, httpEntity, String.class);
            System.out.println(responseEntity.getStatusCode());
            System.out.println(responseEntity.getBody());
        }
    }
}
