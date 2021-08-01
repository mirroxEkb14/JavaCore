package JavaFx.sceneBuilder.MusicPlayer;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.File;
import java.net.URL;
import java.util.*;

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

        setMediaPlayer();
        setSongLabel();

        // set speed in 'ComboBox'
        for (int speedAmount: speeds) {
            speedBox.getItems().add(speedAmount + "%");
        }
        speedBox.setOnAction(this::changeSpeed);

        // when we use the 'Slider' to change the volume, we call this 'changed' method
        volumeSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                mediaPlayer.setVolume(volumeSlider.getValue() * 0.01);
            }
        });

        songProgressBar.setStyle("-fx-accent: #00FF00;");
    }

    public void playMedia() {
        beginTimer();
        changeSpeed(null);
        mediaPlayer.play();
    }

    public void pauseMedia() {
        cancelTimer();
        mediaPlayer.pause();
    }

    public void resetMedia() {
        songProgressBar.setProgress(0);
        mediaPlayer.seek(Duration.seconds(0.0));
    }

    public void previousMedia() {
        if (songCounter > 0) songCounter--;
        else songCounter = playList.size() - 1;

        mediaPlayer.stop();

        if (running) cancelTimer();

        setMediaPlayer();
        setSongLabel();
        playMedia();
    }

    public void nextMedia() {
        if (songCounter < playList.size() - 1) songCounter++; // play next song
        else songCounter = 0; // if we reached the last song, we go back to the first one

        mediaPlayer.stop();

        if (running) cancelTimer();

        setMediaPlayer();
        setSongLabel();
        playMedia();
    }

    public void changeSpeed(ActionEvent event) {
        if (speedBox.getValue() == null) mediaPlayer.setRate(1);
        else mediaPlayer.setRate(Integer.parseInt(
                speedBox.getValue().substring(0, speedBox.getValue().length() - 1)) * 0.01);
    }

    public void beginTimer() {
        timer = new Timer();
        task = new TimerTask() {
            @Override
            public void run() {
                running = true;
                double current = mediaPlayer.getCurrentTime().toSeconds();
                double end = media.getDuration().toSeconds();
                songProgressBar.setProgress(current / end);

                if (current / end == 1) cancelTimer();
            }
        };

        timer.scheduleAtFixedRate(task, 0, 1000);
    }

    public void cancelTimer() {
        running = false;
        timer.cancel();
    }

    private void setMediaPlayer() {
        media = new Media(playList.get(songCounter).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
    }

    private void setSongLabel() { songLabel.setText(playList.get(songCounter).getName()); }
}
