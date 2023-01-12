package Controller;

import Model.CoursModel;
import Service.CoursService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@RestController
public class APIController {

    @Autowired
    private CoursService coursService;

    @GetMapping("/date")
    public Iterable<CoursModel> getCoursDate(String date) throws JSONException, IOException {
        return coursService.getCoursDate(date);
    }

    @GetMapping("/date")
    public List<HashMap<Float, List>> getCoursBeginEnd(String dateBegin, String dateEnd) throws JSONException, IOException{
        return coursService.getCoursBeginEndDate(dateBegin, dateEnd);
    }

    @GetMapping("/")
    public void reccordClick(){
        coursService.reccordClick();
    }
}
