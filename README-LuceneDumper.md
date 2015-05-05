##Prerequisites:
You need the following jar files, which can be obtained via maven repo:

- lucene-backward-codecs-5.1.0.jar
- lucene-core-5.1.0.jar

I suggest putting them in the lib folder

## Compiling

javac -cp "lib/*" LuceneDumper.java

## Execution

java -cp ".:lib/*" LuceneDumper <path_to_data_directory>/yz/<index_name?>/data/index/

For example:

java -cp ".:lib/*" LuceneDumper ~/basho/riak/data/yz/articles/data/index/

By default, LuceneDumper will dump all keys from the provided lucene index.
If you want to find just a subset, you can provide a second parameter, which is
the name of a file contianing keys to dump, one per row.
