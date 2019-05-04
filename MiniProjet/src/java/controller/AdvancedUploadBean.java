package controller;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.Person;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;
import util.documentUtil;

@ManagedBean
@ViewScoped
public class AdvancedUploadBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<File> documents = new ArrayList<>();
    private StreamedContent streamedContent;

    @PostConstruct
    public void postConstruct() {
        documents = new ArrayList<>(documentUtil.Liste());
    }

    public void upload(FileUploadEvent event) throws IOException {
        UploadedFile uploadedFile = event.getFile();

        File document = documentUtil.Ecrire(uploadedFile.getFileName(), uploadedFile.getContents());
        documents.add(document);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Upload completed", "of document " + document.getName()));
    }

    public void delete_file(String name) {
        for (int i = 0; i < documents.size(); i++) {
            if (name.equals(documents.get(i).getName())) {
                documents.remove(documents.get(i));
            }
        }
    }
//     public void delete(Person test){
//        this.personFacade.remove(test);
//    }

    public List<File> getDocuments() {
        return documents;
    }
//    private Part file; // +getter+setter
//
////public void save() {
////    try (InputStream input = file.getInputStream()) {
////        Files.copy(input, new File(uploads, filename).toPath());
////    }
////    catch (IOException e) {
////        // Show faces message?
////    }
////}
}
