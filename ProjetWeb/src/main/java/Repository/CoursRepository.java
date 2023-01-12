package Repository;


import Model.CoursModel;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Repository
public abstract class CoursRepository implements CrudRepository<CoursModel, Long> {

    private static String readAll(BufferedReader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }


    public static JSONObject readJsonFromUrl(String url) throws IOException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            String jsonText = readAll(rd);
            //json = jsonText
            return new JSONObject(jsonText);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        } finally {
            is.close();
        }
    }
    public Iterable<CoursModel> findById(String Date) throws JSONException, IOException {
        JSONObject json = readJsonFromUrl("https://www.alphavantage.co/query?function=TIME_SERIES_DAILY_ADJUSTED&symbol=IBM&apikey=1XDCVS7DM3C1XE20");
        Object date = json.get(Date);
        float open = (float) json.get("open");
        float low = (float) json.get("low");
        float hight = (float) json.get("hight");
        double volume = (double) json.get("volume");
        List<Float> values = new ArrayList<>();
        values.add(open);
        values.add(low);
        values.add(hight);
        values.add((float) volume);
        HashMap<Object, List> map = new HashMap<Object, List>();
        map.put(date, values);
        return (Iterable<CoursModel>) map;
    }

    public List<HashMap<Float, List>> findByBeginEndDate(String DateBegin, String DateEnd) throws JSONException, IOException {
        JSONObject json = readJsonFromUrl("https://www.alphavantage.co/query?function=TIME_SERIES_DAILY_ADJUSTED&symbol=IBM&apikey=1XDCVS7DM3C1XE20");
        Object dateBegin = json.get(DateBegin);
        Object dateEnd= json.get(DateEnd);
        float date = (float) dateBegin;
        float date_end = (float) dateEnd;
        // faire une liste avec les dates
        List<Float> allDate = new ArrayList<>();
        while(Integer.valueOf((int) date) < Integer.valueOf((int)date_end)){
            allDate.add((Float) json.get(String.valueOf(date)));
        }
        // Puis le Hash par date stocker dans une liste Map
        List<HashMap<Float,List>> Map = new ArrayList<>();
        for( int i=0 ; i < allDate.size(); i++) {
            HashMap<Float, List> map = new HashMap<Float, List>();
            float open = (float) json.get("open");
            float low = (float) json.get("low");
            float hight = (float) json.get("hight");
            double volume = (double) json.get("volume");
            List<Float> values = new ArrayList<>();
            values.add(open);
            values.add(low);
            values.add(hight);
            values.add((float) volume);
            map.put(allDate.get(i), values);
            Map.add(map);
        };
        return Map;
    }

    public CompteurDeClic reccordClick() {
        JFrame frame = new JFrame();
        frame.setTitle("Compteur De Clic");
        frame.setSize(new Dimension(250, 80));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Créez le panneau à afficher
        CompteurDeClic CompteurDeClic = new CompteurDeClic();
        JPanel CompteurDeClicPanel = CompteurDeClic.getPanel();

        // Ajoutez le panneau au centre de la fenêtre
        Container content = frame.getContentPane();
        content.add(CompteurDeClicPanel, BorderLayout.CENTER);

        // Afficher la fenêtre
        frame.setVisible(true);
        return CompteurDeClic;
    }
}
