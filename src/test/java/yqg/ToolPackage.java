package yqg;

import okhttp3.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.UUID;

/**
 * Created by dengmingliang on 2020/1/7
 */
public class ToolPackage {
    @Test
    public void test(){
        System.out.println(UUID.randomUUID().toString().replace("-","").substring(0,30));
    }

    @Test
    public void decodeResponse() throws UnsupportedEncodingException {
//        String healthInfoResultJson = "%7B%22insuredList%22%3A%5B%7B%22age%22%3A%2239%22%2C%22birthDate%22%3A333907200000%2C%22certiNo%22%3A%22110101198008110079%22%2C%22certiType%22%3A%221%22%2C%22diseaseVerdictList%22%3A%5B%7B%22verdictDes%22%3A%22%B8%D0%D0%BB%C4%FA%CC%E1%B9%A9%B5%C4%BD%A1%BF%B5%D0%C5%CF%A2%A3%AC%B9%A7%CF%B2%C4%FA%BF%C9%D2%D4%D5%FD%B3%A3%CD%B6%B1%A3%B1%BE%B2%FA%C6%B7%22%7D%5D%2C%22gender%22%3A%221%22%2C%22healthInfo%22%3A%221%22%2C%22insuredName%22%3A%22den%22%2C%22underwriteNo%22%3A%22202001070H0219483%22%7D%5D%2C%22planCode%22%3A%22H02%22%2C%22policySuccess%22%3A%221%22%2C%22policyUnderwriteNo%22%3A%22202001071808019482%22%2C%22productCode%22%3A%22H02001%22%2C%22transRefId%22%3A%2273ceb9c309cb4ab7a4c6a5d0d71025%22%7D";
        String healthInfoResultJson = "%7B%22insuredList%22%3A%5B%7B%22age%22%3A%2238%22%2C%22birthDate%22%3A365443200000%2C%22certiNo%22%3A%22110101198108110079%22%2C%22certiType%22%3A%221%22%2C%22diseaseVerdictList%22%3A%5B%7B%22verdictDes%22%3A%22%B8%D0%D0%BB%C4%FA%CC%E1%B9%A9%B5%C4%BD%A1%BF%B5%D0%C5%CF%A2%A3%AC%B9%A7%CF%B2%C4%FA%BF%C9%D2%D4%D5%FD%B3%A3%CD%B6%B1%A3%B1%BE%B2%FA%C6%B7%22%7D%5D%2C%22gender%22%3A%221%22%2C%22healthInfo%22%3A%221%22%2C%22insuredName%22%3A%22den%22%2C%22underwriteNo%22%3A%22202001080H0219540%22%7D%2C%7B%22age%22%3A%2239%22%2C%22birthDate%22%3A333907200000%2C%22certiNo%22%3A%22110101198008110079%22%2C%22certiType%22%3A%221%22%2C%22diseaseVerdictList%22%3A%5B%7B%22verdictDes%22%3A%22%B7%C7%B3%A3%B1%A7%C7%B8%A3%AC%C4%FA%CE%B4%C4%DC%CD%A8%B9%FD%B1%BE%B4%CE%CD%B6%B1%A3%C9%F3%BA%CB%A3%AC%C7%EB%D1%A1%D4%F1%C6%E4%CB%FB%B1%A3%CF%D5%B2%FA%C6%B7%22%7D%5D%2C%22gender%22%3A%221%22%2C%22healthInfo%22%3A%220%22%2C%22insuredName%22%3A%22deng%22%2C%22underwriteNo%22%3A%22202001080H0219541%22%7D%5D%2C%22planCode%22%3A%22H02%22%2C%22policySuccess%22%3A%220%22%2C%22policyUnderwriteNo%22%3A%22202001081420019539%22%2C%22productCode%22%3A%22H02001%22%2C%22transRefId%22%3A%2273ceb9c309cb4ab7a4c6a5d0d71039%22%7D";
        System.out.println(URLDecoder.decode(healthInfoResultJson,"GBK"));

    }


    @Test
    public void requestAnsheng() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/xml");
        RequestBody body = RequestBody.create(mediaType, "<?xml version=\"1.0\" encoding=\"GBK\"?>\n" +
                "<TXTpaic>\n" +
                "    <TXTpaicRequest>\n" +
                "        <transType>001</transType>\n" +
                "        <planCode>H02</planCode>\n" +
                "        <productCode>H02001</productCode>\n" +
                "        <isSalesPage>1</isSalesPage>\n" +
                "        <transRefId>"+UUID.randomUUID().toString().replace("-","").substring(0,30)+"</transRefId>\n" +
                "        <thridBackUrl>https://www.heheda.com</thridBackUrl>\n" +
                "        <requestType>post</requestType>\n" +
                "        <InsuredList>\n" +
                "            <insured>\n" +
                "                <insuredName>den</insuredName>\n" +
                "                <birthDate>1980-08-01</birthDate>\n" +
                "                <age>27</age>\n" +
                "                <gender>1</gender>\n" +
                "                <certiType>01</certiType>\n" +
                "                <certiNo>110101198008110079</certiNo>\n" +
                "                <healthInfoFlag>0</healthInfoFlag>\n" +
                "            </insured>\n" +
                "        </InsuredList>\n" +
                "    </TXTpaicRequest>\n" +
                "</TXTpaic>");
        Request request = new Request.Builder()
                .url("https://uats.axatp.com/webservice/onlineAIUnderWriting.do")
                .method("POST", body)
                .addHeader("Content-Type", "application/xml")
                .addHeader("username", "avaiTest")
                .addHeader("password", "password")
                .addHeader("Authorization", "Basic YXZhaVRlc3Q6cGFzc3dvcmQ=")
                .build();
        Response response = client.newCall(request).execute();
        System.out.println(response.code());
        System.out.println(response.body().string());
    }
}
