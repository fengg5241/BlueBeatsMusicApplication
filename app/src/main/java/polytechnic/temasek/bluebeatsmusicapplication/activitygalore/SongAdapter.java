package polytechnic.temasek.bluebeatsmusicapplication.activitygalore;

import android.content.Context;
import android.content.res.Resources;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import polytechnic.temasek.bluebeatsmusicapplication.R;

/**
 * Created by User on 29/7/2017.
 */

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.MyViewHolder> {

    private TheSongCollection songCollection = new TheSongCollection("");
    private List<Song> songList;
    private Context mContext;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, artist;
        public ImageView songCoverArt;

        public MyViewHolder(View view){
            super(view);
            title = (TextView) view.findViewById(R.id.SongTitle);
            artist = (TextView) view.findViewById(R.id.SongArtist);
            songCoverArt = (ImageView) view.findViewById(R.id.SongCoverArt);
        }
    }

    public SongAdapter(Context mContext, List<Song> songList) {
        this.songList = songList;
        this.mContext = mContext;
    }


    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.songobjview, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Song song = songList.get(position);
        holder.title.setText(song.getSong_Title());
        holder.artist.setText(song.getSong_Artist());
        int id = getResId(song.getCoverArt(), R.drawable.class);

        holder.songCoverArt.setImageResource(id);

    }

    public int getResId(String variableName, Class<?> css) {
        try {
            // lookup field in class
            java.lang.reflect.Field field = css.getField(variableName);
            // always set access when using reflections
            // preventing IllegalAccessException
            field.setAccessible(true);
            // we can use here also Field.get() and do a cast
            // receiver reference is null as it's static field
            return field.getInt(null);
        } catch (Exception e) {
            // rethrow as not found ex
            throw new Resources.NotFoundException(e.getMessage());
        }
    }

    @Override
    public int getItemCount() {
        return songList.size();
    }
}
