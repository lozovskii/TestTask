package com.testTask.controller;

import com.testTask.model.LineEntities;
import com.testTask.model.LineEntity;
import com.testTask.model.MatchingParam;
import com.testTask.service.LineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class LineEntityController {
    private final LineService lineService;
    private String userPath;
    private LineEntities lineEntities;

    @Autowired
    public LineEntityController(LineService lineService) {
        this.lineService = lineService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView StartView() {
        return new ModelAndView("index");
    }

    @RequestMapping(value = "/getPath", method = RequestMethod.POST)
    public @ResponseBody
    LineEntities showMessage(@RequestParam String userPath) {
        this.userPath = userPath;
        if (lineEntities == null) {
            writeScheduled();
        }
        return lineEntities;
    }

    @Scheduled(fixedDelay = 5*60*1000)
    private void writeScheduled() {
        if (userPath == null) {
            return;
        }
        System.out.println("Working...");
        List<LineEntity> listStoppingLogs = lineService.getListLogs(userPath, MatchingParam.STOPPING_LOG);
        List<LineEntity> listSdlSigLogs = lineService.getListLogs(userPath, MatchingParam.SDLSIG_LOG);

        lineEntities = new LineEntities();
        lineEntities.setLineEntities(listSdlSigLogs);
        lineEntities.getLineEntities().addAll(listStoppingLogs);
        lineService.writeXML(lineEntities);
    }
}