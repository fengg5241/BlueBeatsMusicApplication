package polytechnic.temasek.bluebeatsmusicapplication.UtilityClasses;

import java.util.ArrayList;

import polytechnic.temasek.bluebeatsmusicapplication.activitygalore.Song;

/**
 * Created by User on 23/7/2017.
 */

public class TheSongCollection2 {
    public ArrayList<Song> AllSong = new ArrayList<Song>();
    public TheSongCollection2() {
        super();
    }

    //public TheSongCollection2(String gen) {
       // establishSongs(gen);
   // }

    private void establishSongs2(String genre){
        if(genre.equals("Jazz")) {
            Song strangeFruit = new Song("S1001", "Strange Fruit - Remastered", "Billie Holiday", "050358b5fd710ef04d982b579f744404ce718093?cid=2afe87a64b0042dabf51f37318616965",
                    3.01, "strangefruit");
            Song mackTheKnife = new Song("S1002", "Mack the Knife - Live", "Ella Fitzgerald", "cd52def28db39a44a5e553b12d4935b4a0cf001d?cid=2afe87a64b0042dabf51f37318616965",
                    5.17, "macktheknife");
            Song  atLast = new Song("S1003", "At Last", "Etta James", "c5b420223cb221b656cbb20664bd86777260578c?cid=2afe87a64b0042dabf51f37318616965",
                    4.77, "atlast");
            AllSong.add(strangeFruit);
            AllSong.add(mackTheKnife);
            AllSong.add(atLast);

        }
        if(genre.equals("Metal")) {
            Song masterOfPuppets = new Song("S1001", "Master of Puppets", "Metallica", "60e6f8dab43f176dd9fb5e795d4e6459bad52e9e?cid=2afe87a64b0042dabf51f37318616965",
                    8.6, "masterofpuppets");
            Song hallowedbtn = new Song("S1002", "Hallowed Be Thy Name", "Iron Maiden", "2207fde6d4ce245267759dc6e1d37e5bff89743f?cid=2afe87a64b0042dabf51f37318616965",
                    7.48, "hallowedbtn");
            Song one = new Song("S1003", "One", "Metallica", "38701233fcbb321f72ee04c7980dee80915d2667?cid=2afe87a64b0042dabf51f37318616965",
                    7.46, "one");
            AllSong.add(masterOfPuppets);
            AllSong.add(hallowedbtn);
            AllSong.add(one);

        }
        if(genre.equals("Electronic")) {
            Song somethingJustLikeThis = new Song("S1001", "Something Just Like This", "The Chainsmokers", "499eefd42a24ec562c464bd7acfad7ed41eb9179?cid=2afe87a64b0042dabf51f37318616965",
                    4.13, "somethingjlt");
            Song itaintme = new Song("S1002", "It Ain't Me", "Kygo ft. Selena Gomez", "14c4f664755de848314b8acafae1f18fcc4f8660?cid=2afe87a64b0042dabf51f37318616965",
                    3.68, "itaintme");
            Song toyou = new Song("S1003", "2U", "David Guetta ft. Justin Bieber", "93ae9a427b479d84be31924be6869d45345cf7d2?cid=2afe87a64b0042dabf51f37318616965",
                    3.25, "2U");
            AllSong.add(somethingJustLikeThis);
            AllSong.add(itaintme);
            AllSong.add(toyou);
        }
    }
}
