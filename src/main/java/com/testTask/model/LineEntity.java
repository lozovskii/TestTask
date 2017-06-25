package com.testTask.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "line")
public class LineEntity {

    private String param1;
    private String paramDate;
    private String paramKeyNameLog;
    private String param4;
    private String param5;
    private String param6;
    private String param7;
    private String param8;
    private String param9;

    public LineEntity() {
    }

    public LineEntity(String param1, String paramDate, String paramKeyNameLog, String param4, String param5, String param6, String param7, String param8, String param9) {
        this.param1 = param1;
        this.paramDate = paramDate;
        this.paramKeyNameLog = paramKeyNameLog;
        this.param4 = param4;
        this.param5 = param5;
        this.param6 = param6;
        this.param7 = param7;
        this.param8 = param8;
        this.param9 = param9;
    }

    @XmlElement
    public String getParam1() {
        return param1;
    }

    public void setParam1(String param1) {
        this.param1 = param1;
    }

    @XmlElement
    public String getParamDate() {
        return paramDate;
    }

    public void setParamDate(String paramDate) {
        this.paramDate = paramDate;
    }

    @XmlElement
    public String getParamKeyNameLog() {
        return paramKeyNameLog;
    }

    public void setParamKeyNameLog(String paramKeyNameLog) {
        this.paramKeyNameLog = paramKeyNameLog;
    }

    @XmlElement
    public String getParam4() {
        return param4;
    }

    public void setParam4(String param4) {
        this.param4 = param4;
    }

    @XmlElement
    public String getParam5() {
        return param5;
    }

    public void setParam5(String param5) {
        this.param5 = param5;
    }

    @XmlElement
    public String getParam6() {
        return param6;
    }

    public void setParam6(String param6) {
        this.param6 = param6;
    }

    @XmlElement
    public String getParam7() {
        return param7;
    }

    public void setParam7(String param7) {
        this.param7 = param7;
    }

    @XmlElement
    public String getParam8() {
        return param8;
    }

    public void setParam8(String param8) {
        this.param8 = param8;
    }

    @XmlElement
    public String getParam9() {
        return param9;
    }

    public void setParam9(String param9) {
        this.param9 = param9;
    }

    @Override
    public String toString() {
        return "LineEntity{" +
                "param1='" + param1 + '\'' +
                ", paramDate='" + paramDate + '\'' +
                ", paramKeyNameLog='" + paramKeyNameLog + '\'' +
                ", param4='" + param4 + '\'' +
                ", param5='" + param5 + '\'' +
                ", param6='" + param6 + '\'' +
                ", param7='" + param7 + '\'' +
                ", param8='" + param8 + '\'' +
                ", param9='" + param9 + '\'' +
                '}';
    }
}