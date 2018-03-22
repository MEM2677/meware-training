/*
*
* <Your licensing text here>
*
*/
package org.entando.entando.plugins.jpasiabpm.aps.internalservlet.asiabpm;

import java.io.File;
import org.entando.entando.plugins.jpasiabpm.apsadmin.asiabpm.AsiabpmAction;


public class AsiabpmFrontEndAction extends AsiabpmAction {
    
    
    private File fileUpload;
    private String fileUploadContentType;
    private String fileUploadFileName;
    
    public String fileUpload() {
        try {
            System.out.println(">>>\n>>> " + fileUpload.getAbsolutePath() + "\n>>>");
            System.out.println(">>> " + fileUpload.exists());
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return SUCCESS;
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
    
}
