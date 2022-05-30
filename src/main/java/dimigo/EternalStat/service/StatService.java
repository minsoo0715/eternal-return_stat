package dimigo.EternalStat.service;

import com.google.gson.GsonBuilder;
import dimigo.EternalStat.domain.User;
import dimigo.EternalStat.dto.UserJson;
import dimigo.EternalStat.repository.StatRepository;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

import static org.springframework.http.HttpHeaders.USER_AGENT;

public class StatService {
    private StatRepository statRepository;

    public StatService(StatRepository statRepository) {
        this.statRepository = statRepository;
    }

    public User loadById(String id) { //유저의 데이터를 외부 api로부터 갱신함
        try {
            System.out.println(String.format("http://localhost:4000/?name=%s&mode=Solo", id));
            User user = sendGet(String.format("http://localhost:4000/?name=%s&mode=Solo", URLEncoder.encode(id, StandardCharsets.UTF_8)));
            if(user == null) return null;
            System.out.println(user.getId());
            statRepository.save(user);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public User Search(String id) { //유저를 검색하고 없으면 유저의 데이터를 로드함.
        Optional<User> user = statRepository.findById(id);
        if(user.isPresent()) {
            return user.get();
        }else {
            return loadById(id);
        }
    }




    // HTTP GET request
    private User sendGet(String targetUrl) throws Exception {
        URL url = new URL(targetUrl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET"); // optional default is GET
        con.setRequestProperty("User-Agent", USER_AGENT); // add request header
        con.setRequestProperty("charset", "utf-8");
        int responseCode = con.getResponseCode();
        StringBuffer response = new StringBuffer();
        if(responseCode == 200) {
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            // print result
            System.out.print(response.toString());
            UserJson temp = new GsonBuilder().create().fromJson(response.toString(), (Type) UserJson.class);
            return temp.ConvertToUser();
        }else {
            return null;
        }


    }
}




