package com.example.XMLToBase.db.service;

import com.example.XMLToBase.db.XmlTools.XMLAttributeReader;
import com.example.XMLToBase.db.entity.GarAddressobject;
import com.example.XMLToBase.db.entity.GarAdmHierarchy;
import com.example.XMLToBase.db.entity.GarMunHierarchy;
import com.example.XMLToBase.db.repo.GarAddressobjectRepository;
import com.example.XMLToBase.db.repo.GarAdmHierarchyRepository;
import com.example.XMLToBase.db.repo.GarMunHierarchyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Arrays;
import java.util.List;

@Component
public class GarService {
    private Logger logger = LoggerFactory.getLogger(GarService.class);

    @Value("${gar.path}")
    String garPath;

    @Value("${records.per.iteration}")
    Integer	RECORDS_PER_ITERATION;

    @Value("${mask.addr}")
    String	maskAddr;

    @Value("${mask.adm}")
    String	maskAdm;

    @Value("${mask.mun}")
    String	maskMun;

    GarAddressobjectRepository garAddressobjectRepository;
    GarAdmHierarchyRepository garAdmHierarchyRepository;
    GarMunHierarchyRepository garMunHierarchyRepository;

    public GarService(GarAddressobjectRepository garAddressobjectRepository, GarAdmHierarchyRepository garAdmHierarchyRepository, GarMunHierarchyRepository garMunHierarchyRepository) {
        this.garAddressobjectRepository = garAddressobjectRepository;
        this.garAdmHierarchyRepository = garAdmHierarchyRepository;
        this.garMunHierarchyRepository = garMunHierarchyRepository;
    }

    private List<File> getFiles(File path){
        File[] arrFiles = path.listFiles();
        List<File> lst = Arrays.asList(arrFiles);
        return lst;
    }

    private Boolean isDate(String partPath){
        String regex = "\\d+";
        return  partPath.matches(regex);
    }

    private Boolean isAddr(String fileName){
        if (!fileName.contains(maskAddr)) return false;
        return isDate(fileName.substring(maskAddr.length(),  maskAddr.length() + 8));
    }

    private Boolean isAdm(String fileName){
        if (!fileName.contains(maskAdm)) return false;
        return isDate(fileName.substring(maskAdm.length(),  maskAdm.length() + 8));
    }

    private Boolean isMun(String fileName){
        if (!fileName.contains(maskMun)) return false;
        return isDate(fileName.substring(maskMun.length(),  maskMun.length() + 8));
    }

    private void processAddr(File file){
        logger.info("Start loading " + file.getParent() + "/" + file.getName());
        try (InputStream is = new FileInputStream(file)) {
            XMLAttributeReader xmlReader = new XMLAttributeReader(is, "OBJECT", RECORDS_PER_ITERATION);
            Integer i = 0;
            List<GarAddressobject> list;
            Integer j = 1;
            while (xmlReader.hasNext()) {
                list = xmlReader.getNextPart(GarAddressobject.class);
                garAddressobjectRepository.saveAll(list);
                i += Math.min(RECORDS_PER_ITERATION, list.size());
                if ((i / RECORDS_PER_ITERATION) != j){
                    j = i / RECORDS_PER_ITERATION;
                    logger.info("saved records: " + i);
                }
                list.clear();
            }
            logger.info("saved records: " + i);
            xmlReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void processAdm(File file){
        logger.info("Start loading " + file.getParent() + "/" + file.getName());
        try (InputStream is = new FileInputStream(file)) {
            XMLAttributeReader xmlReader = new XMLAttributeReader(is, "ITEM", RECORDS_PER_ITERATION);
            Integer i = 0;
            List<GarAdmHierarchy> list;
            Integer j = 1;
            while (xmlReader.hasNext()) {
                list = xmlReader.getNextPart(GarAdmHierarchy.class);
                garAdmHierarchyRepository.saveAll(list);
                i += Math.min(RECORDS_PER_ITERATION, list.size());
                if ((i / RECORDS_PER_ITERATION) != j){
                    j = i / RECORDS_PER_ITERATION;
                    logger.info("saved records: " + i);
                }
                list.clear();
            }
            logger.info("saved records: " + i);
            xmlReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void processMun(File file){
        logger.info("Start loading " + file.getParent() + "/" + file.getName());
        try (InputStream is = new FileInputStream(file)) {
            XMLAttributeReader xmlReader = new XMLAttributeReader(is, "ITEM", RECORDS_PER_ITERATION);
            Integer i = 0;
            List<GarMunHierarchy> list;
            Integer j = 1;
            while (xmlReader.hasNext()) {
                list = xmlReader.getNextPart(GarMunHierarchy.class);
                garMunHierarchyRepository.saveAll(list);
                i += Math.min(RECORDS_PER_ITERATION, list.size());
                if ((i / RECORDS_PER_ITERATION) != j){
                    j = i / RECORDS_PER_ITERATION;
                    logger.info("saved records: " + i);
                }
                list.clear();
            }
            logger.info("saved records: " + i);
            xmlReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void processGar(File folder){
        List<File> files = getFiles(folder);
        for (File file : files){
            if (file.isDirectory()) continue;

            if (isAddr(file.getName())){
                processAddr(file);
            }

            if (isAdm(file.getName())){
                processAdm(file);
            }

            if (isMun(file.getName())){
                processMun(file);
            }
        }

    }

    public void loadGar() throws Exception {
        logger.info("Start console application...");

        List<File> folders = getFiles(new File(garPath));

        for (File folder : folders){
            if (!folder.isDirectory()) continue;

            processGar(folder);
        }
    }

}
