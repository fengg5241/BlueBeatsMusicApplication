package polytechnic.temasek.bluebeatsmusicapplication.UtilityClasses;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import polytechnic.temasek.bluebeatsmusicapplication.R;

/**
 * Created by User on 19/7/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_song_items, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {



    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imgCoverArt;
        public TextView txtSongArtist;
        public TextView txtSongTitle;

        public ViewHolder(View itemView) {
            super(itemView);

            /*imgCoverArt = (ImageView) itemView.findViewById(R.id.ivCoverArt);
            txtSongArtist = (TextView) itemView.findViewById(R.id.txt_ArtistName);
            txtSongTitle = (TextView) itemView.findViewById(R.id.txt_SongName);*/
        }
    }
}
