package com.musicstructureapp.app.musicstructureapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class SongActivity extends AppCompatActivity {
    ArrayList<AdapterItems> listnewsData = new ArrayList<AdapterItems>();
    MyCustomAdapter myadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);
        ListView tvlist = (ListView) findViewById(R.id.tvlist);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle(getResources().getString(R.string.title_activity_song));

        ImageView playlistButton = (ImageView) findViewById(R.id.button_playlist);
        ImageView artistButton = (ImageView) findViewById(R.id.button_artist);
        ImageView albumButton = (ImageView) findViewById(R.id.button_album);
        ImageView downloadButton = (ImageView) findViewById(R.id.button_buy);


        playlistButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentPlaylist = new Intent(view.getContext(), PlaylistActivity.class);
                startActivity(intentPlaylist);
            }
        });

        artistButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentArtist = new Intent(view.getContext(), ArtistActivity.class);
                startActivity(intentArtist);
            }
        });

        albumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentAlbum = new Intent(view.getContext(), AlbumActivity.class);
                startActivity(intentAlbum);
            }
        });

        downloadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentDownload = new Intent(view.getContext(), BuyActivity.class);
                startActivity(intentDownload);
            }
        });


        //add data and view it
        listnewsData.add(new AdapterItems(1, "Birthday", " The Carbonfools"));
        listnewsData.add(new AdapterItems(2, "Bag of Candy", " The Carbonfools"));
        listnewsData.add(new AdapterItems(3, "Busdriver", " The Carbonfools"));

        myadapter = new MyCustomAdapter(listnewsData);
        tvlist.setAdapter(myadapter);
    }

    private class MyCustomAdapter extends BaseAdapter {
        public ArrayList<AdapterItems> listnewsDataAdpater;

        public MyCustomAdapter(ArrayList<AdapterItems> listnewsDataAdpater) {
            this.listnewsDataAdpater = listnewsDataAdpater;
        }


        @Override
        public int getCount() {
            return listnewsDataAdpater.size();
        }

        @Override
        public String getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater mInflater = getLayoutInflater();
            View myView = mInflater.inflate(R.layout.song_item, null);

            final AdapterItems s = listnewsDataAdpater.get(position);

            TextView SongId = (TextView) myView.findViewById(R.id.tvID);
            SongId.setText("ID:" + s.ID);
            TextView SongTitle = (TextView) myView.findViewById(R.id.tvTitle);
            SongTitle.setText(s.Title);
            TextView SongArtist = (TextView) myView.findViewById(R.id.tvArtist);
            SongArtist.setText(s.Artist);
            return myView;
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}