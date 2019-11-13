package podcast;

import PodcastDB.FakeDB;
import model.Podcast;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class PodcastData {
    static final String TITLE = "title";
    static final String DESCRIPTION = "description";
    static final String LANGUAGE = "language";
    static final String LINK = "link";
    static final String PUB_DATE = "pubDate";
    static final String DURATION = "duration";
    static final String SUMMARY = "summary";
    static final String ITEM = "item";

    URL url;

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public boolean addAllPodcast() {
        FakeDB db = new FakeDB();
        List<Podcast> podcasts = null;
        try {
            podcasts = dowork();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (XMLStreamException e) {
            e.printStackTrace();
            return false;
        }
        db.addAllPodcast(podcasts);
        return true;
    }

    private List<Podcast> dowork() throws IOException, XMLStreamException {
        List<Podcast> podcastList = new ArrayList<>();
        XMLInputFactory xmlInputFactory = XMLInputFactory.newFactory();
        InputStream stream = url.openStream();
        XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(stream, "UTF-8");

        String description = "";
        String title = "";
        String link = "";
        String language = "";
        String duration = "";
        String summary = "";
        String pubdate = "";
        while (xmlEventReader.hasNext()) {
            XMLEvent xmlEvent = xmlEventReader.nextEvent();
            if (xmlEvent.isStartElement()) {
                String localPart = xmlEvent.asStartElement().getName().getLocalPart();
                xmlEvent = xmlEventReader.nextEvent();
                if (xmlEvent.isEndElement()) {
                    //continue;
                }
                switch (localPart) {
                    case TITLE:
                        title = getData(xmlEvent);
                        break;
                    case DESCRIPTION:
                        description = getData(xmlEvent);
                        break;
                    case LANGUAGE:
                        language = getData(xmlEvent);
                        break;
                    case LINK:
                        link = getData(xmlEvent);
                        break;
                    case SUMMARY:
                        summary = getData(xmlEvent);
                        break;
                    case DURATION:
                        duration = getData(xmlEvent);
                        break;
                    case PUB_DATE:
                        pubdate = getData(xmlEvent);
                        break;

                }
            } else if (xmlEvent.isEndElement()) {
                if (xmlEvent.asEndElement().getName().getLocalPart() == (ITEM)) {
                    Podcast podcast = new Podcast();
                    podcast.setDescription(description);
                    podcast.setLanguage(language);
                    podcast.setLink(link);
                    podcast.setDescription(description);
                    podcast.setTitle(title);
                    podcast.setDuration(duration);
                    podcast.setPubDate(pubdate); //Pubdate Güzel bir mevzu.
                    podcast.setSummary(summary);

                    podcastList.add(podcast);
                    description = "";
                    language = "";
                    link = "";
                    title = "";
                    duration = "";
                    pubdate = "";
                    summary = "";
                }


            }
        }
        return podcastList;
    }

    private String getData(XMLEvent event) {
        String data = "Yokki";

        try {
            data = event.asCharacters().getData();
        } catch (Exception e) {
            //e.printStackTrace();
            return data;
        }
        return data;
    }
}
