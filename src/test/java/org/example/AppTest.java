package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.*;
import org.apache.http.Header;
import org.apache.http.StatusLine;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void testGetSdAcademy() throws IOException {
        try (CloseableHttpClient httpClient = HttpClientBuilder
                .create()
                .build()) {

            HttpGet httpGet = new HttpGet("http://sdacademy.pl");
            CloseableHttpResponse response = httpClient.execute(httpGet);
            int statusCode = response.getStatusLine().getStatusCode();

            String reasonPhrase = response.getStatusLine().getReasonPhrase();
            System.out.println("status: " + statusCode + " " + reasonPhrase);

            Header[] allHeaders = response.getAllHeaders();
            for (Header h : allHeaders) {
                System.out.println("Header name: " + h.getName() + " value " + h.getValue());
            }
            BasicResponseHandler basicResponseHandler = new BasicResponseHandler();
            String responseAsString = basicResponseHandler.handleResponse(response);
            System.out.println(responseAsString);
        }
    }

    @Test
    public void testGetSdAcademyByIp() throws IOException {
        //http://104.24.123.121
        try (CloseableHttpClient httpClient = HttpClientBuilder
                .create()
                .build()) {

            HttpGet httpGet = new HttpGet("http://104.24.123.121");
            httpGet.addHeader("Host", "sdacademy.pl");
            CloseableHttpResponse response = httpClient.execute(httpGet);
            int statusCode = response.getStatusLine().getStatusCode();

            String reasonPhrase = response.getStatusLine().getReasonPhrase();
            System.out.println("status: " + statusCode + " " + reasonPhrase);

            Header[] allHeaders = response.getAllHeaders();
            for (Header h : allHeaders) {
                System.out.println("Header name: " + h.getName() + " value " + h.getValue());
            }
            BasicResponseHandler basicResponseHandler = new BasicResponseHandler();
            String responseAsString = basicResponseHandler.handleResponse(response);
            System.out.println(responseAsString);
        }
    }

    @Test
    public void testDeleteSdAcademy() throws IOException {
        try (CloseableHttpClient httpClient = HttpClientBuilder
                .create()
                .build()) {

            HttpDelete httpDelete = new HttpDelete("https://sdacademy.pl");
            CloseableHttpResponse response = httpClient.execute(httpDelete);
            int statusCode = response.getStatusLine().getStatusCode();

            String reasonPhrase = response.getStatusLine().getReasonPhrase();
            System.out.println("status: " + statusCode + " " + reasonPhrase);

            Header[] allHeaders = response.getAllHeaders();
            for (Header h : allHeaders) {
                System.out.println("Header name: " + h.getName() + " value " + h.getValue());
            }
            BasicResponseHandler basicResponseHandler = new BasicResponseHandler();
            String responseAsString = basicResponseHandler.handleResponse(response);
            System.out.println(responseAsString);
        }
    }

    @Test
    public void testSendDataToSdAcademy() throws IOException {

        try (CloseableHttpClient httpClient = HttpClientBuilder
                .create()
                .build()) {

            HttpPost httpPost = new HttpPost("https://sdacademy.pl");

            httpPost.setEntity(EntityBuilder.create().setText("hulalula")
                    .build());

            CloseableHttpResponse response = httpClient.execute(httpPost);
            int statusCode = response.getStatusLine().getStatusCode();

            String reasonPhrase = response.getStatusLine().getReasonPhrase();
            System.out.println("status: " + statusCode + " " + reasonPhrase);

            Header[] allHeaders = response.getAllHeaders();
            for (Header h : allHeaders) {
                System.out.println("Header name: " + h.getName() + " value " + h.getValue());
            }
            BasicResponseHandler basicResponseHandler = new BasicResponseHandler();
            String responseAsString = basicResponseHandler.handleResponse(response);
            System.out.println(responseAsString);
        }
    }

    @Test
    public void googleSearch() throws IOException {
        //    HttpGet httpGet = new HttpGet("https://www.google.pl/search?safe=off&source=hp&ei=rRbpXIbKLtLIrgSmkK7wDg&q=pogoda+gdansk");


    }

    @Test
    public void testGetPolandInfo() throws IOException {
        String address = "https://restcountries.eu/rest/v2/name/poland";
        try (CloseableHttpClient httpClient = HttpClientBuilder
                .create()
                .build()) {

            HttpGet httpGet = new HttpGet("https://restcountries.eu/rest/v2/name/poland");
            CloseableHttpResponse response = httpClient.execute(httpGet);
            int statusCode = response.getStatusLine().getStatusCode();

            String reasonPhrase = response.getStatusLine().getReasonPhrase();
            System.out.println("status: " + statusCode + " " + reasonPhrase);

            Header[] allHeaders = response.getAllHeaders();
            for (Header h : allHeaders) {
                System.out.println("Header name: " + h.getName() + " value " + h.getValue());
            }
            BasicResponseHandler basicResponseHandler = new BasicResponseHandler();
            String responseAsString = basicResponseHandler.handleResponse(response);
            System.out.println(responseAsString);
        }
    }


    @Test
    public void testGsonParse() {
        String json = "{\"firstName\": \"Krzysztof\", \"lastName\":\"Ambroziak\"}";
        //System.out.println(lastName);


        JsonParser jsonParser = new JsonParser();
        JsonElement mainElement = jsonParser.parse(json);
        JsonObject jsonObject = mainElement.getAsJsonObject();
        System.out.println(jsonObject.getAsJsonPrimitive("lastName"));
    }

    @Test
    public void testBuildSentence() throws IOException {
        //Polska ma ludności: x, graniczy z:... a po włosku to:...

        String address = "https://restcountries.eu/rest/v2/name/poland";
        try (CloseableHttpClient httpClient = HttpClientBuilder
                .create()
                .build()) {

            HttpGet httpGet = new HttpGet("https://restcountries.eu/rest/v2/name/poland");
            CloseableHttpResponse response = httpClient.execute(httpGet);
            int statusCode = response.getStatusLine().getStatusCode();

            String reasonPhrase = response.getStatusLine().getReasonPhrase();
            System.out.println("status: " + statusCode + " " + reasonPhrase);

            Header[] allHeaders = response.getAllHeaders();
            for (Header h : allHeaders) {
//                System.out.println("Header name: " + h.getName() + " value " + h.getValue());
            }
            BasicResponseHandler basicResponseHandler = new BasicResponseHandler();

            String responseAsString = basicResponseHandler.handleResponse(response);

            JsonParser jsonParser = new JsonParser();
            JsonElement mainElement = jsonParser.parse(responseAsString);

            JsonArray mainArray = mainElement.getAsJsonArray();
            JsonElement firstElement = mainArray.get(0);

            JsonObject mainObject = firstElement.getAsJsonObject();
            int population = mainObject.getAsJsonPrimitive("population")
                    .getAsInt();

            JsonArray borderArray = mainObject.getAsJsonArray("borders");
            StringBuilder borders = new StringBuilder("Graniczy z: ");
            for (JsonElement e : borderArray) {
                borders.append(e.getAsString() + " ");

            }
            JsonObject translation = mainObject.getAsJsonObject("translations");
            String it = translation.getAsJsonPrimitive("it").getAsString();
            System.out.println("population: " + population + " " + borders + " " + "po wlosku " + it);
        }
    }


    @Test
    public void buildJsonFromObject() {

        Student student = new Student();
        student.setLastName("Kkowalski");
        student.setFirstName("Jan");
        student.setAge(18);
        String json = new Gson().toJson(student);

        System.out.println(json);

        Student newStudent = new Gson().fromJson(json, Student.class);

        System.out.println(newStudent);


    }

    @Test
    public void buildObjectFromJson() {

    }

    @Test
    public void testJackson() throws JsonProcessingException {
        Student student = new Student();
        ObjectMapper objectMapper = new ObjectMapper();
    }

    @Test
    public void sendStudentData() throws IOException {
        Student student = new Student();
        student.setAge(18);
        student.setFirstName("AA");
        student.setLastName("bb");

        String json = new Gson().toJson(student);
        try (CloseableHttpClient httpClient = HttpClientBuilder
                .create()
                .build()) {

            HttpPost httpPost = new HttpPost("https://protected-cove-60658.herokuapp.com/students");

            httpPost.setEntity(EntityBuilder.create()
                    .setText(json)
                    .setContentType(ContentType.APPLICATION_JSON)
                    .build());

            for (Header h : httpPost.getAllHeaders()) {
                 System.out.println("Header name: " + h.getName() + " value " + h.getValue());
            }

            CloseableHttpResponse response = httpClient.execute(httpPost);
            int statusCode = response.getStatusLine().getStatusCode();

            String reasonPhrase = response.getStatusLine().getReasonPhrase();
            System.out.println("status: " + statusCode + " " + reasonPhrase);

            Header[] allHeaders = response.getAllHeaders();
            for (Header h : allHeaders) {
               System.out.println("Header name: " + h.getName() + " value " + h.getValue());
            }
            BasicResponseHandler basicResponseHandler = new BasicResponseHandler();
            String responseAsString = basicResponseHandler.handleResponse(response);
            System.out.println(responseAsString);
        }
    }


    @Test
    public void getStudentData() throws IOException {
        //    String address = "https://protected-cove-60658.herokuapp.com/students";

        try (CloseableHttpClient httpClient = HttpClientBuilder
                .create()
                .build()) {

            HttpGet httpGet = new HttpGet("https://protected-cove-60658.herokuapp.com/students");
            CloseableHttpResponse response = httpClient.execute(httpGet);
            int statusCode = response.getStatusLine().getStatusCode();

            String reasonPhrase = response.getStatusLine().getReasonPhrase();
            System.out.println("status: " + statusCode + " " + reasonPhrase);

            Header[] allHeaders = response.getAllHeaders();
            for (Header h : allHeaders) {
              //  System.out.println("Header name: " + h.getName() + " value " + h.getValue());
            }
            BasicResponseHandler basicResponseHandler = new BasicResponseHandler();
            String responseAsString = basicResponseHandler.handleResponse(response);
            System.out.println(responseAsString);
        }
    }
    }


