import java.util.Arrays;
import java.util.Scanner;

public class Playlist {
    private String[] songs;
    private int songCount;

    public Playlist(int maxSongs) {
        songs = new String[maxSongs];
        songCount = 0;
    }

    public void addSong(String song) {
        if (songCount < songs.length)
            songs[songCount++] = song;
    }

    public String[] getSongs() {
        return Arrays.copyOf(songs, songCount);
    }

    public int getSongCount() {
        return songCount;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter maximum number of songs: ");
        int max = sc.nextInt();
        sc.nextLine();

        Playlist p = new Playlist(max);

        System.out.print("Enter number of songs: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter song " + (i + 1) + ": ");
            p.addSong(sc.nextLine());
        }

        System.out.println("Songs: " + Arrays.toString(p.getSongs()));
        System.out.println("Song count: " + p.getSongCount());
    }
}