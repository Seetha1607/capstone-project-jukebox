create DATABASE IF NOT EXISTS `jukebox`;

USE `jukebox`;


create TABLE IF NOT EXISTS `jukebox`.`song`;
(
  `song_id` int not null primary key auto_increment,
  `song_name` varchar(60) not null,
  `artist_name` varchar(50) not null,
  `genre` varchar(20) not null
  `duration` varchar(25) not null
);

--Inserted song 1:
insert into `jukebox`.`song` (`song_id`, `song_name`, `duration`) VALUES
 ('1', 'Believer', '00:03:36');

--Inserted song 2:
insert into `jukebox`.`song` (`song_id`, `song_name`, `duration`) VALUES
 ('2', 'Dance Monkey', '00:03:29');

--Inserted song 3:
insert into `jukebox`.`song` (`song_id`, `song_name`, `duration`) VALUES
 ('3', 'Girls Like You', '00:04:30');

--Inserted song 4:
insert into `jukebox`.`song` (`song_id`, `song_name`, `duration`) VALUES
 ('4', 'Love Yourself', '00:03:52');

--Inserted song 5:
insert into `jukebox`.`song` (`song_id`, `song_name`, `duration`) VALUES
 ('5', 'Lovely', '00:03:20');

--Inserted song 6:
insert into `jukebox`.`song` (`song_id`, `song_name`, `duration`) VALUES
 ('6', 'Memories', '00:03:15');

--Inserted song 7:
insert into `jukebox`.`song` (`song_id`, `song_name`, `duration`) VALUES
 ('7', 'Payphone', '00:03:56');

--Inserted song 8:
insert into `jukebox`.`song` (`song_id`, `song_name`, `duration`) VALUES
 ('8', 'Perfect', '00:04:39');

--Inserted song 9:
insert into `jukebox`.`song` (`song_id`, `song_name`, `duration`) VALUES
 ('9', 'Senorita', '00:03:11');

--Inserted song 10:
insert into `jukebox`.`song` (`song_id`, `song_name`, `duration`) VALUES
 ('10', 'The Weekend - Blinding lights', '00:03:23');

--Inserted song 11:
insert into `jukebox`.`song` (`song_id`, `song_name`, `duration`) VALUES
 ('11', 'Umbrella', '00:04:39');

--Inserted song 12:
insert into `jukebox`.`song` (`song_id`, `song_name`, `duration`) VALUES ('12', 'Unstoppable', '00:04:06');

--Inserted song 13:
insert into `jukebox`.`song` (`song_id`, `song_name`, `duration`) VALUES
 ('13', 'We Dont Talk Anymore', '00:03:50');

--Inserted song 14:
insert into `jukebox`.`song` (`song_id`, `song_name`, `duration`) VALUES
 ('14', 'What Makes You Beautiful', '00:03:26');

--Inserted song 15:
insert into `jukebox`.`song` (`song_id`, `song_name`, `duration`) VALUES
 ('15', 'Who Says', '00:03:12');

 --Updating table of song:
 update `jukebox`.`song` SET `artist_name` = 'Imagine Dragons', `genre` = 'Pop' where (`song_id` = '1');
 update `jukebox`.`song` SET `artist_name` = 'Tones and I', `genre` = 'Pop' where (`song_id` = '2');
 update `jukebox`.`song` SET `artist_name` = 'Maroon 5', `genre` = 'Soul' where (`song_id` = '3');
update `jukebox`.`song` SET `artist_name` = 'Justin Bieber', `genre` = 'Soul' where (`song_id` = '4');
update `jukebox`.`song` SET `artist_name` = 'Billie Eilish', `genre` = 'Fusion' where (`song_id` = '5');
update `jukebox`.`song` SET `artist_name` = 'Maroon 5', `genre` = 'Fusion' where (`song_id` = '6');
update `jukebox`.`song` SET `artist_name` = 'Maroon 5', `genre` = 'Fusion' where (`song_id` = '7');
update `jukebox`.`song` SET `artist_name` = 'Ed Sheeran', `genre` = 'Fusion' where (`song_id` = '8');
update `jukebox`.`song` SET `artist_name` = 'Camila Cabello', `genre` = 'Soul' where (`song_id` = '9');
update `jukebox`.`song` SET `artist_name` = 'The Weeknd', `genre` = 'Soul' where (`song_id` = '10');
update `jukebox`.`song` SET `artist_name` = 'Rihanna', `genre` = 'Pop' where (`song_id` = '11');
update `jukebox`.`song` SET `artist_name` = 'Sia', `genre` = 'Pop' where (`song_id` = '12');
update `jukebox`.`song` SET `artist_name` = 'Charlin Puth,Selena Gomez', `genre` = 'Soul' where (`song_id` = '13');
update `jukebox`.`song` SET `artist_name` = 'Harry Styles', `genre` = 'Fusion' where (`song_id` = '14');
update `jukebox`.`song` SET `artist_name` = 'Selena Gomez', `genre` = 'Pop' where (`song_id` = '15');

--added song path column table
update `jukebox`.`song` SET `Song path` = 'src/main/resources/songs/Believer-Imagine-Dragons.wav' where (`song_id` = '1');
update `jukebox`.`song` SET `Song path` = 'src/main/resources/songs/Dance-Monkey-Tones-And-I.wav' where (`song_id` = '2');
update `jukebox`.`song` SET `Song path` = 'src/main/resources/songs/Girls-Like-You-Maroon-5-Feat-Cardi-B.wav' where (`song_id` = '3');
update `jukebox`.`song` SET `Song path` = 'src/main/resources/songs/Love-Yourself-Justin-Bieber.wav' where (`song_id` = '4');
update `jukebox`.`song` SET `Song path` = 'src/main/resources/songs/Lovely-Billie-Eilish.wav' where (`song_id` = '5');
update `jukebox`.`song` SET `Song path` = 'src/main/resources/songs/Memories-Maroon-5.wav' where (`song_id` = '6');
update `jukebox`.`song` SET `Song path` = 'src/main/resources/songs/Payphone-Maroon-5-Feat-Wiz-Khalifa.wav' where (`song_id` = '7');
update `jukebox`.`song` SET `Song path` = 'src/main/resources/songs/Perfect-Ed-Sheeran.wav' where (`song_id` = '8');
update `jukebox`.`song` SET `Song path` = 'src/main/resources/songs/Senorita-Camila-Cabello.wav' where (`song_id` = '9');
update `jukebox`.`song` SET `Song path` = 'src/main/resources/songs/The-Weeknd-Blinding-Lights.wav' where (`song_id` = '10');
update `jukebox`.`song` SET `Song path` = 'src/main/resources/songs/Umbrella-Rihanna.wav' where (`song_id` = '11');
update `jukebox`.`song` SET `Song path` = 'src/main/resources/songs/Unstoppable-Sia.wav' where (`song_id` = '12');
update `jukebox`.`song` SET `Song path` = 'src/main/resources/songs/We-Dont-Talk-Anymore-Charlie-Puth-Feat-Selena-Gomez.wav' where (`song_id` = '13');
update `jukebox`.`song` SET `Song path` = 'src/main/resources/songs/What-Makes-You-Beautiful-Harry-Styles.wav' where (`song_id` = '14');
update `jukebox`.`song` SET `Song path` = 'src/main/resources/songs/Who-Says-Selena-Gomez.wav' where (`song_id` = '15');

--Select all details from table:
select * from jukebox.song;

--get song name and duration by song id:
select `song_name`, `duration` FROM `jukebox`.`song` where(`song_id` = ?);

--created a new table called playlist:
create TABLE IF NOT EXISTS `playlist`
(
  `playlist_id` int not null primary key auto_increment,
  `playlist_name` varchar(50) not null,
  `songs` varchar(15) not null
);

--Inserting data into the playlist table:
insert into `jukebox`.`playlist` (`playlist_id`, `playlist_name`, `song`) VALUES ('1', 'Pop playlist', '1');
insert into `jukebox`.`playlist` (`playlist_id`, `playlist_name`, `songs`) VALUES ('2', 'Pop playlist', '2');
insert into `jukebox`.`playlist` (`playlist_id`, `playlist_name`, `songs`) VALUES ('3', 'Pop playlist', '11');
insert into `jukebox`.`playlist` (`playlist_id`, `playlist_name`, `songs`) VALUES ('4', 'Pop playlist', '12');
insert into `jukebox`.`playlist` (`playlist_id`, `playlist_name`, `songs`) VALUES ('5', 'Pop playlist', '15');
insert into `jukebox`.`playlist` (`playlist_id`, `playlist_name`, `songs`) VALUES ('6', 'Soul playlist', '3');
insert into `jukebox`.`playlist` (`playlist_id`, `playlist_name`, `songs`) VALUES ('7', 'Soul playlist', '4');
insert into `jukebox`.`playlist` (`playlist_id`, `playlist_name`, `songs`) VALUES ('8', 'Soul playlist', '9');
insert into `jukebox`.`playlist` (`playlist_id`, `playlist_name`, `songs`) VALUES ('9', 'Soul playlist', '10');
insert into `jukebox`.`playlist` (`playlist_id`, `playlist_name`, `songs`) VALUES ('10', 'Soul playlist', '13');
insert into `jukebox`.`playlist` (`playlist_id`, `playlist_name`, `songs`) VALUES ('11', 'Fusion playlist', '5');
insert into `jukebox`.`playlist` (`playlist_id`, `playlist_name`, `songs`) VALUES ('12', 'Fusion playlist', '6');
insert into `jukebox`.`playlist` (`playlist_id`, `playlist_name`, `songs`) VALUES ('13', 'Fusion playlist', '7');
insert into `jukebox`.`playlist` (`playlist_id`, `playlist_name`, `songs`) VALUES ('14', 'Fusion playlist', '8');
insert into `jukebox`.`playlist` (`playlist_id`, `playlist_name`, `songs`) VALUES ('15', 'Fusion playlist', '14');

update `jukebox`.`playlist` SET `song_name` = 'Imagine Dragons' where (`playlist_id` = '1');
update `jukebox`.`playlist` SET `song_name` = 'Tones and I' where (`playlist_id` = '2');
update `jukebox`.`playlist` SET `song_name` = 'Umbrella' where (`playlist_id` = '3');
update `jukebox`.`playlist` SET `song_name` = 'Unstoppable' where (`playlist_id` = '4');
update `jukebox`.`playlist` SET `song_name` = 'Who Says' where (`playlist_id` = '5');
update `jukebox`.`playlist` SET `song_name` = 'Girls Like You' where (`playlist_id` = '6');
update `jukebox`.`playlist` SET `song_name` = 'Love Yourself' where (`playlist_id` = '7');
update `jukebox`.`playlist` SET `song_name` = 'Senorita' where (`playlist_id` = '8');
update `jukebox`.`playlist` SET `song_name` = 'The Weeknd - Blinding Lights' where (`playlist_id` = '9');
update `jukebox`.`playlist` SET `song_name` = 'We Dont talk Anymore' where (`playlist_id` = '10');
update `jukebox`.`playlist` SET `song_name` = 'Lovely' where (`playlist_id` = '11');
update `jukebox`.`playlist` SET `song_name` = 'Memories' where (`playlist_id` = '12');
update `jukebox`.`playlist` SET `song_name` = 'Payphone' where (`playlist_id` = '13');
update `jukebox`.`playlist` SET `song_name` = 'Perfect' where (`playlist_id` = '14');
update `jukebox`.`playlist` SET `song_name` = 'What Makes You Beautiful' where (`playlist_id` = '15');



--Selecting playlist according to the album name:
select playlist.playlist_id as 'Playlist ID',
       playlist.playlist_name AS 'Playlist Name',
       song.song_name AS 'Song Name'
       FROM playlist
       JOIN song ON (song.song_id = playlist.songs);

--create playlist method:
insert into `jukebox`.`playlist` (playlist_name, song_id,song_name) VALUES ('Favo','12','Unstoppable');

--add new song to the song list:
insert into `jukebox`.`song` (song_name, artist_name,genre,Song_path) VALUES (?,?,?)



