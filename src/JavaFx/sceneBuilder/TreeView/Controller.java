package JavaFx.sceneBuilder.TreeView;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private TreeView<String> myTreeView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TreeItem<String> rootItem = new TreeItem<>("Files",
                new ImageView(new Image("JavaFx/sceneBuilder/TreeView/folder.png")));

        TreeItem<String> pictureBranch = new TreeItem<>("Pictures");
        TreeItem<String> videoBranch = new TreeItem<>("Videos");
        TreeItem<String> musicBranch = new TreeItem<>("Music");

        TreeItem<String> pictureLeafItem1 = new TreeItem<>("picture1");
        TreeItem<String> pictureLeafItem2 = new TreeItem<>("picture2");
        TreeItem<String> videoLeafItem1 = new TreeItem<>("video1");
        TreeItem<String> videoLeafItem2 = new TreeItem<>("video2");
        TreeItem<String> musicLeafItem1 = new TreeItem<>("music1");
        TreeItem<String> musicLeafItem2 = new TreeItem<>("music2");

        pictureBranch.getChildren().addAll(pictureLeafItem1, pictureLeafItem2);
        videoBranch.getChildren().addAll(videoLeafItem1, videoLeafItem2);
        musicBranch.getChildren().addAll(musicLeafItem1, musicLeafItem2);

        rootItem.getChildren().addAll(pictureBranch, videoBranch, musicBranch);

        myTreeView.setRoot(rootItem);
    }

    public void selectItem() {

    }
}
