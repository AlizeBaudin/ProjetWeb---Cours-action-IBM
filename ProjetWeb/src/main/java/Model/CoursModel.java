package Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Time data", schema = "public")
public  class CoursModel  {
    @JsonProperty("open")
    private float open;
    @JsonProperty("higth")
    private float hight;
    @JsonProperty("low")
    private float low;
//    @JsonProperty("volume")
//    private int volume;

    @Id
    @JsonProperty("date")
    private String date;

}
