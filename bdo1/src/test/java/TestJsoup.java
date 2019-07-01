import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentLinkedQueue;

@Slf4j
public class TestJsoup {


    @Test
    public void home(){
        Document doc = null;
        try {
            doc = Jsoup.connect("http://en.wikipedia.org/").get();
        } catch (IOException e) {
            e.printStackTrace();
        }


        Elements newsHeadlines = doc.select("#mp-itn b a");
        for (Element headline : newsHeadlines) {
            log.info("{}\n\t{}",
                    headline.attr("title"), headline.absUrl("href"));
        }
    }




    @Test
    public void getAllRecipe() {
        List<CompletableFuture> completableFutureList = new ArrayList<CompletableFuture>();
        ConcurrentLinkedQueue<String> items  = new ConcurrentLinkedQueue<>();

        for (int idx = 0 ; idx < 1000 ; idx++){
            CompletableFuture.runAsync(() -> System.out.println("Run async in completable future " + Thread.currentThread()));
            final int idx_ = idx;
            CompletableFuture<Void> lop = CompletableFuture.supplyAsync(
                    () -> {
                        try {
                            return Jsoup.connect("https://bdocodex.com/us/recipe/" + idx_ + "/").get();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        System.out.println("LOP");
                        return null;
                    }
            )
                    .thenApply(doc -> doc.select("#item_name b"))
                    .thenAccept(elements -> elements.stream().forEach(element -> {
                        log.info("{}\n\t{}", element.text(), "");
                        items.add(element.text());
                    }));
            completableFutureList.add(lop);
        }

        completableFutureList.forEach(CompletableFuture::join);
        int size = items.size();
    }
}
