import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Runner {
    private static String json = "{\"description\":" +
            "{ \"participantInn\": \"string\" }, \"doc_id\": \"string\", \"doc_status\": \"string\"," +
            "\"doc_type\": \"LP_INTRODUCE_GOODS\", \"importRequest\": true," +
            "\"owner_inn\": \"string\", \"participant_inn\": \"string\", \"producer_inn\":" +
            "\"string\", \"production_date\": \"2020-01-23\", \"production_type\": \"string\"," +
            "\"products\": [ { \"certificate_document\": \"string\"," +
            "\"certificate_document_date\": \"2020-01-23\"," +
            "\"certificate_document_number\": \"string\", \"owner_inn\": \"string\"," +
            "\"producer_inn\": \"string\", \"production_date\": \"2020-01-23\"," +
            "\"tnved_code\": \"string\", \"uit_code\": \"string\", \"uitu_code\": \"string\" } ]," +
            "\"reg_date\": \"2020-01-23\", \"reg_number\": \"string\"}";

    public static void main(String[] args) throws IOException, InterruptedException {
        CrptApi crptApi = new CrptApi(TimeUnit.MINUTES, 5);
        ObjectMapper objectMapper = new ObjectMapper();

        CrptApi.Document document = objectMapper.readValue(json, CrptApi.Document.class);
        int i = 0;
        while (true) {
            Scanner sc = new Scanner(System.in);
            sc.nextLine();
            crptApi.createDocument(document, "sign_string");
            System.out.println(i++);
        }
    }
}
