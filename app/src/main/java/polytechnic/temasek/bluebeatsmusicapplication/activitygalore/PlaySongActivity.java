package polytechnic.temasek.bluebeatsmusicapplication.activitygalore;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.IOException;
import java.util.Random;


import polytechnic.temasek.bluebeatsmusicapplication.R;
import polytechnic.temasek.bluebeatsmusicapplication.Util.AppUtil;

public class PlaySongActivity extends AppCompatActivity {

    private SeekBar volumeSeekbar = null;
    private AudioManager audioManager;

    private static final String BASE_URL = "https://p.scdn.co/mp3-preview/";

    private String songId = "";
    private String title = "";
    private String artist = "";
    private String fileLink = "";
    private String coverArt = "";
    private String langTitle = "";
    private String genreTitle = "";
    private double songLength;
    private ImageButton shuffle;
    private ImageButton repeat;
    private boolean repeatOn = false;
    private boolean shuffleOn = false;

    private String url = "";

    private MediaPlayer player = null;

    private int musicPosition = 0;
    private ImageButton btnPlayPause;

    private TheSongCollection songCollection1;

    SeekBar seekBar;
    Handler handler;
    Runnable runnable;

    private Handler musicHandler = new Handler();

    public Runnable moveSeekBarThread = new Runnable() {
        public void run() {
            if(player.isPlaying()){

                int mediaPos_new = player.getCurrentPosition();
                int mediaMax_new = player.getDuration();
                seekBar.setMax(mediaMax_new);
                playCycle();
                seekBar.setProgress(mediaPos_new);

                handler.postDelayed(this, 100); //Looping the thread after 0.1 second
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_song);

        btnPlayPause = (ImageButton) findViewById(R.id.btnPlayPause);

        retrieveData();

        songCollection1 = new TheSongCollection(langTitle);

        displaySong(title, artist, coverArt);

        handler = new Handler();
        seekBar = (SeekBar) findViewById(R.id.seekBar);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.mipmap.ic_minimise);

        setSupportActionBar(toolbar);



        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser)
                {
                    player.seekTo(progress);
                    seekBar.setProgress(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }




        });

        shuffle = (ImageButton) findViewById(R.id.shuffleButton);
        repeat = (ImageButton) findViewById(R.id.repeatButton);

        if (shuffleOn) {
            shuffle.setImageResource(R.drawable.unshuffle);
        }

    }

    public void playCycle() {
        seekBar.setProgress(player.getCurrentPosition());
        if (player.isPlaying()){
           /* seekBar.setProgress(player.getCurrentPosition());
            seekBar.setProgress(musicPosition); */
            runnable = new Runnable() {
                @Override
                public void run() {
                    playCycle();
                }
            };
            handler.postDelayed(runnable, 1000);
        }
    }



    public void playOrPauseMusic(View viewObj) {
        if (player == null) {
            preparePlayer();
        }

        if (!player.isPlaying()) {
            if (musicPosition > 0) {
                player.seekTo(musicPosition);
            }
            player.start();
            seekBar.setMax(player.getDuration());
            playCycle();
            seekBar.setProgress(player.getCurrentPosition());

            handler.removeCallbacks(moveSeekBarThread);
            handler.postDelayed(moveSeekBarThread, 100);
            player.seekTo(musicPosition);
            btnPlayPause.setImageResource(R.drawable.pause);
            moveSeekBarThread.run();
            setTitle("Now playing: " + title);
            gracefullyStopWhenMusicEnds();


        } else {
            pauseMusic();
            seekBar.setProgress(musicPosition);
        }
    }

    private void displaySong(String title, String artist, String coverArt) {

        //This is to retrive the song title TextView from the UI screen
        TextView txtTitle = (TextView) findViewById(R.id.txt_SongTitle);

        txtTitle.setText(title);

        TextView txtArtist = (TextView) findViewById(R.id.txt_SongArtist);

        txtArtist.setText(artist);

        ImageView ivCoverArt = (ImageView) findViewById(R.id.iv_Cover_Art);

        int imageId = AppUtil.getImageIdFromDrawable(this, coverArt);

        ivCoverArt.setImageResource(imageId);
        //image view = iv
    }


    private void gracefullyStopWhenMusicEnds() {
        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            //onCompletionListener is a pre-written Android method, Override is to override
            //the android's default coding
            //mediaPlayer = player
            public void onCompletion(MediaPlayer mediaPlayer) {
                playNext(findViewById(R.id.btnNext));
            }


        });

    }

    public void stopActivities() {
        if (player != null) {
            btnPlayPause.setImageResource(R.drawable.play);
            musicPosition = 0;
            //setTitle("Now playing: ");
            handler.removeCallbacks(runnable);
            player.stop();
            player.release();

            player = null;

        }
    }

    private void pauseMusic() {
        player.pause();

        musicPosition = player.getCurrentPosition();

        btnPlayPause.setImageResource(R.drawable.play);
    }

    private void preparePlayer() {
        player = new MediaPlayer();

        try {
            player.setAudioStreamType(AudioManager.STREAM_MUSIC);

            player.setDataSource(url);

            player.prepare();


        } catch (IOException jarrettIsAnError) {
            jarrettIsAnError.printStackTrace();

        }
    }

    private void retrieveData() {
        Bundle songData = this.getIntent().getExtras();
        songId = songData.getString("id");
        title = songData.getString("title");
        artist = songData.getString("artist");
        fileLink = songData.getString("fileLink");
        coverArt = songData.getString("coverArt");
        langTitle = songData.getString("languageTitle");
        try {
            shuffleOn = songData.getBoolean("Random");
        }catch (Exception e){
            shuffleOn = false;
        }finally {

            url = BASE_URL + fileLink;
        }

    }

    public void playPrevious(View view) {
        if (shuffleOn) {
            Random rand = new Random();
            int songSize = songCollection1.AllSong.size();
            songId = songCollection1.AllSong.get(rand.nextInt(songSize)).getSong_ID();
        }
        Song previousSong = songCollection1.getPreviousSong(songId);

        if (previousSong != null) {
            songId = previousSong.getSong_ID();
            title = previousSong.getSong_Title();
            artist = previousSong.getSong_Artist();
            fileLink = previousSong.getFileLink();
            coverArt = previousSong.getCoverArt();

            url = BASE_URL + fileLink;

            displaySong(title, artist, coverArt);

            stopActivities();

            playOrPauseMusic(view); //Ask teacher about this. What is the parameter referring to?

        }

    }

    public void playNext(View view) {
        if (shuffleOn) {
            Random rand = new Random();
            int songSize = songCollection1.AllSong.size();
            songId = songCollection1.AllSong.get(rand.nextInt(songSize)).getSong_ID();
        }

            Song nextSong = songCollection1.getNextSong(songId);

        if (nextSong != null) {
                songId = nextSong.getSong_ID();
                title = nextSong.getSong_Title();
                artist = nextSong.getSong_Artist();
                fileLink = nextSong.getFileLink();
                coverArt = nextSong.getCoverArt();
                url = BASE_URL + fileLink;
            }
            displaySong(title, artist, coverArt);
            stopActivities();
            playOrPauseMusic(view); //What is the parameter referring to?
        }

        public void shuffleOnOff(View view){
            if (!shuffleOn) {
                    shuffleOn = true;
                repeatOn = false;
                shuffle.setImageResource(R.drawable.unshuffle);
            }
            else {
                shuffleOn = false;
                shuffle.setImageResource(R.drawable.shuffle);
            }
        }

        public void repeatOnOff(View view){
            if (!repeatOn) {
                repeat.setImageResource(R.drawable.norepeat);
                player.setLooping(true);
                repeatOn = true;

            }
            else{
                repeat.setImageResource(R.drawable.repeat);
                player.setLooping(false);
                repeatOn = false;
            }
        }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        finish();
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.mipmap.ic_minimise) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }





    }