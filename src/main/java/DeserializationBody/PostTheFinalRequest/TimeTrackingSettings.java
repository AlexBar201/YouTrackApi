package DeserializationBody.PostTheFinalRequest;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TimeTrackingSettings {
    private boolean enabled;
    private String id;
    private String $type;
}
