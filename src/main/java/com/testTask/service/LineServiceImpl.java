package com.testTask.service;

import com.testTask.model.LineEntities;
import com.testTask.model.LineEntity;
import com.testTask.model.MatchingParam;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

@Service
public class LineServiceImpl implements LineService {
    private static final String serverStorage = "E:\\Downloads\\TestTask\\saved.xml";

    public List<LineEntity> getListLogs(String path, MatchingParam matchingParam) {
        List<LineEntity> stoppingList = new ArrayList<>();
        String s;
        try (BufferedReader in = new BufferedReader(new FileReader(path))) {
            while ((s = in.readLine()) != null) {
                Matcher matcherLog = matchingParam.getPattern().matcher(s);
                if (matcherLog.matches()) {
                    LineEntity lineEntity =
                            new LineEntity(matcherLog.group(1), matcherLog.group(2), matcherLog.group(3),
                                    matcherLog.group(4), matcherLog.group(5), matcherLog.group(6),
                                    matcherLog.group(7), matcherLog.group(8), matcherLog.group(9));
                    stoppingList.add(lineEntity);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stoppingList;
    }

    public void writeXML(LineEntities lineEntities) {
        File xmlFile = new File(serverStorage);
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(LineEntities.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(lineEntities, xmlFile);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}