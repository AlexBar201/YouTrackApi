package DeserializationBody.PostTheFinalRequest;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Plugins {
    private String $type;
    private VcsIntegrationSettings vcsIntegrationSettings;
    private TimeTrackingSettings timeTrackingSettings;
    private Grazie grazie;
    private HelpDeskSettings helpDeskSettings;
}
