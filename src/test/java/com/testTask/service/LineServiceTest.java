package com.testTask.service;

import com.testTask.config.ConfigClass;
import com.testTask.model.LineEntities;
import com.testTask.model.LineEntity;
import com.testTask.model.MatchingParam;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ConfigClass.class)
@WebAppConfiguration
public class LineServiceTest {

    @Autowired
    private LineService lineService;

    private String path;
    private LineEntities lineEntities;
    private String serverStorage;

    @Before
    public void setUp() {
        path = "C:\\Users\\lozov\\Desktop\\log.txt";
        serverStorage = "E:\\Downloads\\TestTask\\saved.xml";
    }

    @Test
    public void shouldAddToStoppingList() {
        List<LineEntity> list = lineService.getListLogs(path, MatchingParam.STOPPING_LOG);
        int checkSizeList = 769;
        assertThat(list.size(), is(equalTo(checkSizeList)));
    }

    @Test
    public void shouldAddToSdlSigList(){
        List<LineEntity> list = lineService.getListLogs(path, MatchingParam.SDLSIG_LOG);
        int checkSizeList = 16907;
        assertThat(list.size(),is(equalTo(checkSizeList)));
    }

    @Test
    public void shouldWriteToXML(){
        List<LineEntity> listStoppingLogs = lineService.getListLogs(path, MatchingParam.STOPPING_LOG);
        List<LineEntity> listSdlSigLogs = lineService.getListLogs(path, MatchingParam.SDLSIG_LOG);

        lineEntities = new LineEntities();
        lineEntities.setLineEntities(listSdlSigLogs);
        lineEntities.getLineEntities().addAll(listStoppingLogs);

        lineService.writeXML(lineEntities);

        File file = new File(serverStorage);
        Node node = null;
        try {
            Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
            node = document.getDocumentElement();

        } catch (SAXException | IOException | ParserConfigurationException e) {
            e.printStackTrace();
        }

        assertThat(node, is(notNullValue()));
    }
}
