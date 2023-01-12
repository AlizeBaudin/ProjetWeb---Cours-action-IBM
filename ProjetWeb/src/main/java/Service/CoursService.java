package Service;

import Model.CoursModel;
import Repository.CompteurDeClic;
import Repository.CoursRepository;
import lombok.Data;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@Data
@Service
public class CoursService {

    @Autowired
    private CoursRepository coursRepository;

    public Iterable<CoursModel> getCoursDate(String date) throws JSONException, IOException {
        return coursRepository.findById(date);
    }
    
    public List<HashMap<Float, List>> getCoursBeginEndDate(String dateBegin, String dateEnd) throws JSONException, IOException{
        return coursRepository.findByBeginEndDate(dateBegin, dateEnd);
    }

    public CompteurDeClic reccordClick(){
        return coursRepository.reccordClick();
    }
}
