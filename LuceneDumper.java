import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexableField;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.HashSet;

public class LuceneDumper {

    public static void main(String[] args) throws IOException {
        Directory indexDir = FSDirectory.open(FileSystems.getDefault().getPath(args[0]));

        HashSet<String> targetKeys = null;
        if (args.length == 2) {
            targetKeys = new HashSet<String>(Files.readAllLines(new File(args[1]).toPath()));
        }
        IndexReader input = DirectoryReader.open(indexDir);

         int maxDoc = input.maxDoc();
         for (int i = 0; i < maxDoc; i++) {
             Document d = input.document(i);
             String id = d.getField("_yz_rk").stringValue();
             if ((targetKeys==null) || targetKeys.contains(id)) {
                 System.out.println("ID:" + id);
                 for (IndexableField f : d.getFields()) {
                     System.out.println("Field:" + f.name() + "|" + f.stringValue());
                 }
             }
         }
    }
}
