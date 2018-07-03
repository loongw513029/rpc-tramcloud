package com.sztvis.dubbo.prodiver;

import com.alibaba.dubbo.config.annotation.Service;
import com.sztvis.domain.DataAlarmConfigViewModel;
import com.sztvis.dubbo.IConfigService;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileInputStream;

@Service(version = "1.0.0")
public class ConfigService implements IConfigService {

    @Override
    public DataAlarmConfigViewModel GetAllConfigs() throws Exception {
        String rootPath = getClass().getResource("/").getPath().toString()+"com/sztvis/buscloud/config/DataAlarmConfig.xml";
        File config = new File(rootPath);
        FileInputStream is = new FileInputStream(config);
        DocumentBuilderFactory dbf = null;
        dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = null;
        db = dbf.newDocumentBuilder();
        Boolean b =config.exists();
        Document docu = db.parse(is);
        NodeList Date = docu.getElementsByTagName("Item");
        Element Xml_item = (Element) Date.item(0);
        DataAlarmConfigViewModel model = new DataAlarmConfigViewModel();
        model.setId(Integer.valueOf(Xml_item.getAttributes().item(0).getNodeValue()));
        model.setDataName(Xml_item.getElementsByTagName("DataName").item(0).getFirstChild().getNodeValue());
        model.setTurn(Boolean.valueOf(Xml_item.getElementsByTagName("Turn").item(0).getFirstChild().getNodeValue()));
        model.setFirstFiter(Xml_item.getElementsByTagName("FirstFiter").item(0).getFirstChild().getNodeValue());
        model.setValue(Xml_item.getElementsByTagName("Value").item(0).getFirstChild().getNodeValue());
        return model;
    }
}
