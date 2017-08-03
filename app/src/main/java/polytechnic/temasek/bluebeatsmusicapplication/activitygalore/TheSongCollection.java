package polytechnic.temasek.bluebeatsmusicapplication.activitygalore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
/**
 * Created by User on 27/6/2017.
 */

public class TheSongCollection {
    public ArrayList<Song> AllSong = new ArrayList<Song>();
    public TheSongCollection(String language) {establishSongs(language);
    }
    public String songID;


    private void establishSongs(String lang) {
        if (lang.equals("Japanese")) {
            Song rain = new Song("S1001", "Rain", "Sekai no Owari", "e1a29a7b714558e890e1531b0419f5e8c24f32dc?cid=2afe87a64b0042dabf51f37318616965",
                    5.12, "rain");
            Song noWayBack = new Song("S1002", "No Way Back", "AAA", "4a5eea2a638b213c08829428cf2e0957d891122a?cid=2afe87a64b0042dabf51f37318616965"
                    , 3.70, "nowayback");
            Song undecided = new Song("S1003", "Undecided", "UVERWorld", "4439b2d097c9f95fbad95a51a0d6d7c3d9798870?cid=2afe87a64b0042dabf51f37318616965"
            , 4.69, "undecided");
            AllSong.add(rain);
            AllSong.add(noWayBack);
            AllSong.add(undecided);

        }
        else if(lang.equals("French")){
            Song petitPapaNoel = new Song("S1001", "Petit Papa Noël", "Tino Rossi", "3b5eeea6d15ccf62ff50311814305c10231b4c28?cid=2afe87a64b0042dabf51f37318616965",
                    3.11, "petitpapanoel");
            Song lambada = new Song("S1002", "Lambada", "Kaoma Featuring Laolwa Braz", "1e45c08c9bf7021ddfb1f1912d5e3710c6c17539?cid=2afe87a64b0042dabf51f37318616965",
                    3.42, "lambada");
            Song aoVivo = new Song("S1003", "Ao Vivo", "Yannick", "d2f48d9daf5b14191526e85ccbd86fd3054df3fd?cid=2afe87a64b0042dabf51f37318616965", 3.09,
                    "aovivo");
            AllSong.add(petitPapaNoel);
            AllSong.add(lambada);
            AllSong.add(aoVivo);
        }
        else if(lang.equals("Jazz")) {
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
        else if(lang.equals("Metal")) {
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
        else if(lang.equals("Electronic")) {
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
        else if(lang.equals("Gaming")) {
            Song virus = new Song("S1001", "Virus (How About Now)", "Martin Garrix", "5a7979603d07344214683096d6ff6324aab247f3?cid=2afe87a64b0042dabf51f37318616965",
                    4.56, "virus");
            AllSong.add(virus);
        }
        else if(lang.equals("Blues")) {
            Song dancingOMO = new Song("S1001", "Dancing On My Own", "Robyn", "9c677c0244d429f4453bbaff270c1eaffc24be99?cid=2afe87a64b0042dabf51f37318616965",
                    4.81, "domo");
            AllSong.add(dancingOMO);

        }
        else if(lang.equals("Exercise")){
            Song tdyd = new Song("S1001", "天地一鬥 Tian Di Yi Dou", "Jay Chou", "013eec45f97d2dce569a73c6d9b8316c1e97be6c?cid=2afe87a64b0042dabf51f37318616965",
                    3.18, "tdyd");
            AllSong.add(tdyd);
        }
        else if(lang.equals("Witcher")){
            Song lazare = new Song("S1001", "Steel For Humans", "Percival Schuttenbach", "92596cfb0f10314fdd2b948579ad5355cdc64f4a?cid=2afe87a64b0042dabf51f37318616965",
                    1.46, "witcher3soundtrack");
            AllSong.add(lazare);
        }
        else {
            Song theWayYouLookTonight = new Song("S1001",
                    "The Way You Look Tonight", "Michael Bubble", "a5b8972e764025020625bbf9c1c2bbb06e394a60?cid=null",
                    4.39, "michael_buble_collection");

            Song billieJean = new Song("S1002", "Billie Jean", "Michael Jackson", "4eb779428d40d579f14d12a9daf98fc66c7d0be4?cid=null"
                    , 4.54, "billie_jean");

            Song blue2009GabryPonte = new Song("S1003", "Blue 2009 - Gabry Ponte Rmx Radio", "Eiffel 65", "df43d98b012d95c2b381814d40d360991374c7b3?cid=2afe87a64b0042dabf51f37318616965",
                    3.74, "eiffel65blue");
            Song shapeOfYou = new Song("S1004", "Shape of You", "Ed Sheeran", "84462d8e1e4d0f9e5ccd06f0da390f65843774a2?cid=2afe87a64b0042dabf51f37318616965",
                    3.90, "e6a84983ed9b0a04ce633b021329f7df034e7c7c");
            Song petitPapaNoel = new Song("S1005", "Petit Papa Noël", "Tino Rossi", "3b5eeea6d15ccf62ff50311814305c10231b4c28?cid=2afe87a64b0042dabf51f37318616965",
                    3.11, "petitpapanoel");
            Song rain = new Song("S1006", "Rain", "Sekai no Owari", "e1a29a7b714558e890e1531b0419f5e8c24f32dc?cid=2afe87a64b0042dabf51f37318616965",
                    5.12, "rain");
            Song noWayBack = new Song("S1007", "No Way Back", "AAA", "4a5eea2a638b213c08829428cf2e0957d891122a?cid=2afe87a64b0042dabf51f37318616965"
                    , 3.70, "nowayback");
            Song aoVivo = new Song("S1008", "Ao Vivo", "Yannick", "d2f48d9daf5b14191526e85ccbd86fd3054df3fd?cid=2afe87a64b0042dabf51f37318616965", 3.09,
                    "aovivo");
            Song undecided = new Song("S1009", "Undecided", "UVERWorld", "4439b2d097c9f95fbad95a51a0d6d7c3d9798870?cid=2afe87a64b0042dabf51f37318616965"
                    , 4.69, "undecided");
            Song lambada = new Song("S1010", "Lambada", "Kaoma Featuring Laolwa Braz", "1e45c08c9bf7021ddfb1f1912d5e3710c6c17539?cid=2afe87a64b0042dabf51f37318616965",
                    3.42, "lambada");
            Song strangeFruit = new Song("S1011", "Strange Fruit - Remastered", "Billie Holiday", "050358b5fd710ef04d982b579f744404ce718093?cid=2afe87a64b0042dabf51f37318616965",
                    3.01, "strangefruit");
            Song mackTheKnife = new Song("S1012", "Mack the Knife - Live", "Ella Fitzgerald", "cd52def28db39a44a5e553b12d4935b4a0cf001d?cid=2afe87a64b0042dabf51f37318616965",
                    5.17, "macktheknife");
            Song  atLast = new Song("S1013", "At Last", "Etta James", "c5b420223cb221b656cbb20664bd86777260578c?cid=2afe87a64b0042dabf51f37318616965",
                    4.77, "atlast");
            Song masterOfPuppets = new Song("S1014", "Master of Puppets", "Metallica", "60e6f8dab43f176dd9fb5e795d4e6459bad52e9e?cid=2afe87a64b0042dabf51f37318616965",
                    8.6, "masterofpuppets");
            Song hallowedbtn = new Song("S1015", "Hallowed Be Thy Name", "Iron Maiden", "2207fde6d4ce245267759dc6e1d37e5bff89743f?cid=2afe87a64b0042dabf51f37318616965",
                    7.48, "hallowedbtn");
            Song one = new Song("S1016", "One", "Metallica", "38701233fcbb321f72ee04c7980dee80915d2667?cid=2afe87a64b0042dabf51f37318616965",
                    7.46, "one");
            Song somethingJustLikeThis = new Song("S1017", "Something Just Like This", "The Chainsmokers", "499eefd42a24ec562c464bd7acfad7ed41eb9179?cid=2afe87a64b0042dabf51f37318616965",
                    4.13, "somethingjlt");
            Song itaintme = new Song("S1018", "It Ain't Me", "Kygo ft. Selena Gomez", "14c4f664755de848314b8acafae1f18fcc4f8660?cid=2afe87a64b0042dabf51f37318616965",
                    3.68, "itaintme");
            Song toyou = new Song("S1019", "2U", "David Guetta ft. Justin Bieber", "93ae9a427b479d84be31924be6869d45345cf7d2?cid=2afe87a64b0042dabf51f37318616965",
                    3.25, "toyou");
            Song virus = new Song("S1020", "Virus (How About Now)", "Martin Garrix", "5a7979603d07344214683096d6ff6324aab247f3?cid=2afe87a64b0042dabf51f37318616965",
                    4.56, "virus");
            Song dancingOMO = new Song("S1021", "Dancing On My Own", "Robyn", "9c677c0244d429f4453bbaff270c1eaffc24be99?cid=2afe87a64b0042dabf51f37318616965",
                    4.81, "domo");
            Song tdyd = new Song("S1022", "天地一鬥 Tian Di Yi Dou", "Jay Chou", "013eec45f97d2dce569a73c6d9b8316c1e97be6c?cid=2afe87a64b0042dabf51f37318616965",
                    3.18, "tdyd");
            Song lazare = new Song("S1023", "Steel For Humans", "Percival Schuttenbach", "92596cfb0f10314fdd2b948579ad5355cdc64f4a?cid=2afe87a64b0042dabf51f37318616965",
                    1.46, "witcher3soundtrack");


            AllSong.add(theWayYouLookTonight);
            AllSong.add(billieJean);
            AllSong.add(blue2009GabryPonte);
            AllSong.add(shapeOfYou);
            AllSong.add(petitPapaNoel);
            AllSong.add(lambada);
            AllSong.add(aoVivo);
            AllSong.add(rain);
            AllSong.add(noWayBack);
            AllSong.add(undecided);
            AllSong.add(strangeFruit);
            AllSong.add(mackTheKnife);
            AllSong.add(atLast);
            AllSong.add(masterOfPuppets);
            AllSong.add(hallowedbtn);
            AllSong.add(one);
            AllSong.add(somethingJustLikeThis);
            AllSong.add(itaintme);
            AllSong.add(toyou);
            AllSong.add(virus);
            AllSong.add(dancingOMO);
            AllSong.add(tdyd);
            AllSong.add(lazare);
        }

    }


    public Song searchById(String id) {

        Song song = null;

        for (int index = 0; index < AllSong.size(); ++index) {
            song = AllSong.get(index);
            if (song.getSong_ID().equals(id)) {
                return song;
            }
        }
        return song;

    }



    public Song getNextSong(String currentSongId) {

        Song song = null;
        for (int increment = 0; increment < AllSong.size(); increment++) {

            Song tempSong = AllSong.get(increment);
            if (tempSong.getSong_ID().equals(currentSongId) && (increment == AllSong.size() - 1)) {
                song = AllSong.get(0);
            }
            else if (tempSong.getSong_ID().equals(currentSongId) && (increment < AllSong.size() - 1)) {
                song = AllSong.get(increment + 1);
                break;
            }
        }
        return song;

    }

    public Song getPreviousSong(String currentSongId) {

        Song song = null;
        for (int increment = 0; increment < AllSong.size(); increment++) {
            Song tempSong = AllSong.get(increment);
            if (tempSong.getSong_ID().equals(currentSongId) && (increment > 0)) {
                song = AllSong.get(increment - 1);
                break;

            }
        }
        return song;

    }

    public String findTheRandomSongID(){
        Random rand = new Random();
        int number = rand.nextInt(23);
        songID = AllSong.get(number).getSong_ID();
        return songID;
    }

    public Song searchByTitle(String title) {

        Song song = null;

        for (int index = 0; index < AllSong.size(); ++index) {
            song = AllSong.get(index);
            if (song.getSong_Title().equals(title)) {
                return song;
            }
        }
        return song;
    }

    public String repeatCurrentSong(String currentSongId){
        Song song = null;
        String songID = null;
        for (int increment = 0; increment < AllSong.size(); increment++) {
            Song tempSong = AllSong.get(increment);
            if (tempSong.getSong_ID().equals(currentSongId) && (increment < AllSong.size() - 1 )) {
                song = AllSong.get(increment);
                break;
            }
        }
        songID = song.getSong_ID();
        return songID;
    }




    public void randomiseSongs(){
        Collections.shuffle(Arrays.asList(AllSong));
    }


}

