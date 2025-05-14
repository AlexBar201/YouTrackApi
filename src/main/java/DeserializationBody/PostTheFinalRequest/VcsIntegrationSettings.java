package DeserializationBody.PostTheFinalRequest;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class VcsIntegrationSettings {
    private boolean hasVcsIntegrations;
    private String $type;
}
