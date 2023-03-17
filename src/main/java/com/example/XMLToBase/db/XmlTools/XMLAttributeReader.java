package com.example.XMLToBase.db.XmlTools;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.InputStream;
import java.util.*;

public class XMLAttributeReader {

    private Logger logger = LoggerFactory.getLogger(XMLAttributeReader.class);

    private InputStream inputStream;
    private String attr;
    private XMLEventReader eventReader;
    private ObjectMapper mapper;
    private final Integer RECORDS_COUNT;

    private void configure() {
        mapper = new ObjectMapper();
        mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            eventReader = factory.createXMLEventReader(inputStream);
        } catch (XMLStreamException e) {
            logger.error(e.getMessage());
        }
    }

    public void close(){
        try {
            eventReader.close();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }

    public XMLAttributeReader(InputStream inputStream, String attr, Integer RECORDS_COUNT) {
        this.inputStream = inputStream;
        this.attr = attr;
        this.RECORDS_COUNT = RECORDS_COUNT;
        configure();
    }

    public Boolean hasNext() {
        return eventReader != null ? eventReader.hasNext() : false;
    }

    public <T> List<T> getNextPart(Class<T> valueType) {
        List<T> valueList = new ArrayList<>();
        int count = 0;
        try {
            while (eventReader.hasNext() && count < RECORDS_COUNT) {
                XMLEvent event = eventReader.nextEvent();
                // тут switch а будущее. Можем обрабатывать и другие элементы xml
                switch (event.getEventType()) {
                    case XMLStreamConstants.START_ELEMENT:
                        StartElement startElement = event.asStartElement();
                        String qName = startElement.getName().getLocalPart();
                        if (qName.equalsIgnoreCase(attr)) {
                            Map map = attributesToMap(startElement.getAttributes());
                            T value = mapper.convertValue(map, valueType);
                            valueList.add(value);
                            count++;
                        }
                        break;
                }
            }
        } catch (XMLStreamException e) {
            logger.error(e.getMessage());
        }
        return valueList;
    }

    private static Map attributesToMap(Iterator<Attribute> attributes) {
        Map<String, String> map = new HashMap<>();
        while (attributes.hasNext()) {
            Attribute attr = attributes.next();
            map.put(attr.getName().toString(), attr.getValue());
        }
        return map;
    }
}
