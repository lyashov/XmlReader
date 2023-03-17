package com.example.XMLToBase.db.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

@Component
public class ReadZip {
    @PostConstruct
    public void doThis(){
        File tmpFile = null;
        try {
            tmpFile = new File("c://tmp//fias.zip");//File.createTempFile("fias", ".zip");// File.createTempFile("fias", ".zip");
            try (InputStream fileInputStream = new FileInputStream(tmpFile);
                 ZipInputStream zis = new ZipInputStream(fileInputStream)) {
                fillDeltaByZipStream(zis);
            }
        } catch (IOException e) {

        } finally {

        }
    }

        private void fillDeltaByZipStream(ZipInputStream zis) {
            try {
                ZipEntry zipEntry = zis.getNextEntry();
                while (zipEntry != null) {
//                    if ((zipEntry.isDirectory() || (zipEntry.getName().contains("Schemas")))) {
//                        zipEntry = zis.getNextEntry();
//                        continue;
//                    }
//                    String fileName = zipEntry.getName();
//                    if (fileName.contains(HOUSE_FILE) || fileName.contains(ADDR_OBJ_FILE)) {
//                        try {
//                            String resultFileName = ftpManager.uploadDeltaFias(zis, zipEntry, fileName);
//                            if (fileName.contains(HOUSE_FILE)) {
//                                deltaFias.setHouseFileName(resultFileName);
//                            } else {
//                                deltaFias.setAddrObjFileName(resultFileName);
//                            }
//                        } catch (IOException | FtpUploadException e) {
//                            logger.error("DeltaFiasDownloader#getZipFilesByUrl ftp upload error", e);
//                        }
//                    }
                    System.out.println(zipEntry.getName());
                    zipEntry = zis.getNextEntry();
                }
                zis.closeEntry();
                zis.close();
            } catch (IOException e) {

            }
        }

}
