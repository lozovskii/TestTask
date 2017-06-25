package com.testTask.service;

import com.testTask.model.LineEntities;
import com.testTask.model.LineEntity;
import com.testTask.model.MatchingParam;

import java.util.List;

public interface LineService {

    List<LineEntity> getListLogs(String path, MatchingParam matchingParam);

    void writeXML(LineEntities lineEntities);

}
