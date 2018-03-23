/*
*
* <Your licensing text here>
*
*/
package org.entando.entando.plugins.jpasiabpm.aps.internalservlet.asiabpm;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import static jdk.nashorn.internal.objects.NativeArray.map;
import org.entando.entando.plugins.jpasiabpm.apsadmin.asiabpm.AsiabpmAction;

public class AsiabpmFrontEndAction extends AsiabpmAction {
        
    private File fileUpload;
    private String fileUploadContentType;
    private String fileUploadFileName; 
    
    public String chosen;
    
    public String fileUpload() {
        try {
            System.out.println(">>>\n>>> " + fileUpload.getAbsolutePath() + "\n>>>");
            System.out.println(">>> " + fileUpload.exists());
        } catch (Throwable t) {
            return FAILURE;
        }
        return SUCCESS;
    }
    
      public String choose() {
        try {
            System.out.println(">>>\n>>> SELECTED " + chosen + "\n>>>");
            return SUCCESS;
        } catch (Throwable t) {
            return FAILURE;
        }
    }
    
    public String showOptions() {
        try {
            System.out.println(">>> SHOW OPTIONS");
            return SUCCESS;
        } catch (Throwable t) {
            return FAILURE;
        }
    }
    
    public List<String> getOptions() {
        List<String> list = new ArrayList<>();
        
        try {
            list.add("Opzione 1");
            list.add("Opzione 2");
            list.add("Opzione 3");
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return list;
    }
    
    
    public String getFileUploadContentType() {
        return fileUploadContentType;
    }
    
    public void setFileUploadContentType(String fileUploadContentType) {
        this.fileUploadContentType = fileUploadContentType;
    }
    
    public String getFileUploadFileName() {
        return fileUploadFileName;
    }
    
    public void setFileUploadFileName(String fileUploadFileName) {
        this.fileUploadFileName = fileUploadFileName;
    }
    
    public File getFileUpload() {
        return fileUpload;
    }
    
    public void setFileUpload(File fileUpload) {
        this.fileUpload = fileUpload;
    }

    public String getChosen() {
        return chosen;
    }

    public void setChosen(String chosen) {
        this.chosen = chosen;
    }
    
}
