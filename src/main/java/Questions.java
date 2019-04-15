import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;

@Data
@AllArgsConstructor
public class Questions {

    private String question;
    private List<String> answer;


}
