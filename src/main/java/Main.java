import PodcastDB.FakeDB;
import model.Podcast;
import podcast.PodcastData;

import java.net.MalformedURLException;
import java.net.URL;
import java.security.InvalidParameterException;
import java.util.List;

public class Main {
    public static void main(String[]args)  {
        if(args.length<1){
            throw new InvalidParameterException();
        }
        PodcastData data=new PodcastData();
        //data.setUrl(new  URL("https://feeds.soundcloud.com/users/soundcloud:users:306221874/sounds.rss"));
        try {
            data.setUrl(new URL(args[0]));
        } catch (MalformedURLException e) {
            System.err.println("İnvalid Url (Format)");
        }
        boolean result=data.addAllPodcast();
        FakeDB db=new FakeDB();
        List<Podcast> podcasts=db.getAllPodcast();
        podcasts.forEach(i->{
            System.out.print(i.getTitle());
            System.out.println(" "+i.getDescription());
            System.out.println(" "+i.getLink());
            System.out.println("-------------------------------");

        });
    }
}
