package com.testTask.model;

import java.util.regex.Pattern;

import static java.util.regex.Pattern.*;

public enum MatchingParam {

    STOPPING_LOG(compile("(\\d.+)\\|([\\d:. ]+)\\|(Stopping[ ]+)\\|([ ]+)\\|([ ]+)\\|([\\D\\d,()]+)\\|([\\D\\d,()]+)\\|([\\d,.^* ]+)\\|([\\D\\d.,_:|()\\[\\]^*=-]+)")),
    SDLSIG_LOG(compile("(\\d.+)\\|([\\d:. ]+)\\|(SdlSig[-I-O ]+)\\|([\\D\\d]+)\\|([\\D0]+)\\|([\\D\\d,()]+)\\|([\\D\\d,()]+)\\|([\\D\\d,.^* ]+)\\|([\\D\\d.,_:|()\\[\\]^*=-]+)"));

    private Pattern pattern;

    MatchingParam(Pattern pattern) {
        this.pattern = pattern;
    }

    public Pattern getPattern() {
        return pattern;
    }
}
