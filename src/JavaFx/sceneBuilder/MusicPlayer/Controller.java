package JavaFx.sceneBuilder.MusicPlayer;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import javax.management.timer.Timer;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;
import java.util.TimerTask;

public class Controller implements Initializable {

    @FXML
    private Pane anchorPane;
    @FXML
    private Label songLabel;
    @FXML
    private Button playButton, pauseButton, resetButton, previousButton, nextButton;
    @FXML
    private ProgressBar songProgressBar;
    @FXML
    private ComboBox<String> speedBox;
    @FXML
    private Slider volumeSlider;

    private Media media;
    private MediaPlayer mediaPlayer;

    // list of all the songs from 'music' package
    private final File mediaDirectory = new File(
            "src/JavaFx/sceneBuilder/MusicPlayer/media");
    private final File[] mediaFiles = mediaDirectory.listFiles();

    private final ArrayList<File> playList = new ArrayList<>();

    private int songCounter;
    private final int[] speeds = {25, 50, 75, 100, 125, 150, 175, 200};

    private Timer timer;
    private TimerTask task;
    private boolean running;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // if there are songs in the 'media' package,
        // add all the songs from the package to the 'playList'
        if (mediaFiles != null) {
            Collections.addAll(playList, mediaFiles);
        }

        media = new Media(playList.get(songCounter).toURI().toString());
        mediaPlayer = new MediaPlayer(media);

        songLabel.setText(playList.get(songCounter).getName());
    }

    public void playMedia() {

    }

    public void pauseMedia() {

    }

    public void resetMedia() {

    }

    public void previousMedia() {

    }

    public void nextMedia() {

    }

    public void changeSpeed() {

    }

    public void beginTimer() {

    }

    public void cancelTimer() {

    }
}
