/*
 *Author Name : Seetha Lakshmi.G.M
 *Date : 23-09-2022
 *Created With : IntelliJ IDEA Community Edition
 */


package com.niit.jdp.service;

import com.niit.jdp.model.Song;

import java.util.Comparator;
import java.util.List;

public class SongService {
    public List<Song> getSortedNameByOrder(List<Song> songName) {

        Comparator<Song> nameComparator = (((o1, o2) -> String.CASE_INSENSITIVE_ORDER.compare(o1.getSongName(), o2.getSongName())));
        songName.sort(nameComparator);
        for (Song songs : songName)
            songs.getSongName();
        return songName;
    }

}
