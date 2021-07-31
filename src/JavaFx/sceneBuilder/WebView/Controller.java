package JavaFx.sceneBuilder.WebView;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private WebView myWebView;

    @FXML
    private TextField myTextField;

    private WebEngine engine;
    private WebHistory history;
    private ObservableList<WebHistory.Entry> entries;

    private String homePage;

    private double webZoom;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        engine = myWebView.getEngine();
        homePage = "www.google.com";
        myTextField.setText(homePage);
        webZoom = 1.0;
        loadPage();
    }

    public void loadPage() { engine.load("http://" + myTextField.getText()); }

    public void refreshPage() { engine.reload(); }

    public void displayHistory() {
        for (WebHistory.Entry entry : getHistory()) {
            System.out.printf("URL -> %s\nDate -> %s\n%n", entry.getUrl(), entry.getLastVisitedDate());
        }
    }

    private ObservableList<WebHistory.Entry> getHistory() {
        history = engine.getHistory();
        return history.getEntries();
    }

    private void setMyTextField(ObservableList<WebHistory.Entry> entries) {
        myTextField.setText(entries.get(history.getCurrentIndex()).getUrl());
    }

    public void back() {
        entries = getHistory();
        if (history.getCurrentIndex() > 0) history.go(-1);
        setMyTextField(entries);
    }

    public void forward() {
        entries = getHistory();
        if (history.getCurrentIndex() + 1 != history.getEntries().size()) history.go(1);
        setMyTextField(entries);
    }

    public void executeJS() {
        // also change "myTextField"
        engine.executeScript("window.location = \"https://www.youtube.com\";");
    }

    public void zoomIn() {
        webZoom += 0.25;
        myWebView.setZoom(webZoom);
    }

    public void zoomOut() {
        webZoom -= 0.25;
        myWebView.setZoom(webZoom);
    }
}
