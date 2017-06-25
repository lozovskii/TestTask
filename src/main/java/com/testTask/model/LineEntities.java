package com.testTask.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "lines")
public class LineEntities {

    private List<LineEntity> lineEntities;

    public List<LineEntity> getLineEntities() {
        return lineEntities;
    }

    @XmlElement(name = "line")
    public void setLineEntities(List<LineEntity> lineEntities) {
        this.lineEntities = lineEntities;
    }
}
