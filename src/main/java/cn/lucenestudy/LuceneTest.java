package cn.lucenestudy;

import com.dxy.search.ClinicSearch;
import com.dxy.search.pojo.AuxiliaryDiagnosisSearchResult;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.junit.Test;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LuceneTest {
    @Test
    public void createIndex() throws IOException {
//        //1 创建文档对象
//        Document document = new Document();
//        // 创建并添加字段信息。参数：字段的名称、字段的值、是否存储，这里选Store.YES代表存储到文档列表。Store.NO代表不存储
//        document.add(new StringField("id", "1", Field.Store.YES));
//        // 这里我们title字段需要用TextField，即创建索引又会被分词。StringField会创建索引，但是不会被分词
//        document.add(new TextField("title", "谷歌地图之父跳槽facebook", Field.Store.YES));
//
//        //2 索引目录类,指定索引在硬盘中的位置
//        Directory directory = FSDirectory.open(Paths.get("/Users/nizhiyong/private/Study/lucene/index").toPa);
//        //3 创建分词器对象
//        Analyzer analyzer = new IKAnalyzer();
//        //4 索引写出工具的配置对象
//        IndexWriterConfig conf = new IndexWriterConfig(new StandardAnalyzer());
//        //5 创建索引的写出工具类。参数：索引的目录和配置信息
//        IndexWriter indexWriter = new IndexWriter(directory, conf);
//
//        //6 把文档交给IndexWriter
//        indexWriter.addDocument(document);
//        //7 提交
//        indexWriter.commit();
//        //8 关闭
//        indexWriter.close();
////}
//    }
//
//        // 批量创建索引
//        @Test
//        public void testCreate2 (){
//            // 创建文档的集合
//            List<Document> docs = new ArrayList<>();
//            // 创建文档对象
//            Document document1 = new Document();
//            document1.add(new StringField("id", "1", Field.Store.YES));
//            document1.add(new TextField("title", "谷歌地图之父跳槽facebook", Field.Store.YES));
//            docs.add(document1);
//            // 创建文档对象
//            Document document2 = new Document();
//            document2.add(new StringField("id", "2", Field.Store.YES));
//            document2.add(new TextField("title", "谷歌地图之父加盟FaceBook", Field.Store.YES));
//            docs.add(document2);
//            // 创建文档对象
//            Document document3 = new Document();
//            document3.add(new StringField("id", "3", Field.Store.YES));
//            document3.add(new TextField("title", "谷歌地图创始人拉斯离开谷歌加盟Facebook", Field.Store.YES));
//            docs.add(document3);
//            // 创建文档对象
//            Document document4 = new Document();
//            document4.add(new StringField("id", "4", Field.Store.YES));
//            document4.add(new TextField("title", "谷歌地图之父跳槽Facebook与Wave项目取消有关", Field.Store.YES));
//            docs.add(document4);
//            // 创建文档对象
//            Document document5 = new Document();
//            document5.add(new StringField("id", "5", Field.Store.YES));
//            document5.add(new TextField("title", "谷歌地图之父拉斯加盟社交网站Facebook", Field.Store.YES));
//            docs.add(document5);
//
//            // 索引目录类,指定索引在硬盘中的位置
////        Directory directory = FSDirectory.open(new File("/Users/nizhiyong/study/ElasticSearchStudy/indexAll"));
////        // 引入IK分词器
////        Analyzer analyzer = new IKAnalyzer();
////        // 索引写出工具的配置对象
////        IndexWriterConfig conf = new IndexWriterConfig(Version.LATEST, analyzer);
////        // 设置打开方式：OpenMode.APPEND 会在索引库的基础上追加新索引。OpenMode.CREATE会先清空原来数据，再提交新的索引
////        conf.setOpenMode(IndexWriterConfig.OpenMode.CREATE);
////
////        // 创建索引的写出工具类。参数：索引的目录和配置信息
////        IndexWriter indexWriter = new IndexWriter(directory, conf);
////        // 把文档集合交给IndexWriter
////        indexWriter.addDocuments(docs);
////        // 提交
////        indexWriter.commit();
////        // 关闭
////        indexWriter.close();
        }

    @Test
    public void testSearch() throws Exception {
//        // 索引目录对象
//        Directory directory = FSDirectory.open(Paths.get("/Users/nizhiyong/private/Study/lucene/index"));
//        // 索引读取工具
//        IndexReader reader = DirectoryReader.open(directory);
//        // 索引搜索工具
//        IndexSearcher searcher = new IndexSearcher(reader);
//
//        // 创建查询解析器,两个参数：默认要查询的字段的名称，分词器
//        QueryParser parser = new QueryParser("title", new StandardAnalyzer());
//        // 创建查询对象
//        Query query = parser.parse("谷歌");
//
//        // 搜索数据,两个参数：查询条件对象要查询的最大结果条数
//        // 返回的结果是 按照匹配度排名得分前N名的文档信息（包含查询到的总条数信息、所有符合条件的文档的编号信息）。
//        TopDocs topDocs = searcher.search(query, 10);
//        // 获取总条数
//        System.out.println("本次搜索共找到" + topDocs.totalHits + "条数据");
//        // 获取得分文档对象（ScoreDoc）数组.SocreDoc中包含：文档的编号、文档的得分
//        ScoreDoc[] scoreDocs = topDocs.scoreDocs;
//        for (ScoreDoc scoreDoc : scoreDocs) {
//            // 取出文档编号
//            int docID = scoreDoc.doc;
//            // 根据编号去找文档
//            Document doc = reader.document(docID);
//            System.out.println("id: " + doc.get("id"));
//            System.out.println("title: " + doc.get("title"));
//            // 取出文档得分
//            System.out.println("得分： " + scoreDoc.score);
//        }
    }
//
//    // 高亮显示
//    @Test
//    public void testHighlighter() throws Exception {
//        // 目录对象
//        Directory directory = FSDirectory.open(new File("/Users/nizhiyong/study/ElasticSearchStudy/indexAll"));
//        // 创建读取工具
//        IndexReader reader = DirectoryReader.open(directory);
//        // 创建搜索工具
//        IndexSearcher searcher = new IndexSearcher(reader);
//
//        QueryParser parser = new QueryParser("title", new IKAnalyzer());
//        Query query = parser.parse("谷歌地图");
//
//        // 格式化器
//        Formatter formatter = new SimpleHTMLFormatter("<em>", "</em>");
//        QueryScorer scorer = new QueryScorer(query);
//        // 准备高亮工具
//        Highlighter highlighter = new Highlighter(formatter, scorer);
//        // 搜索
//        TopDocs topDocs = searcher.search(query, 10);
//        System.out.println("本次搜索共" + topDocs.totalHits + "条数据");
//
//        ScoreDoc[] scoreDocs = topDocs.scoreDocs;
//        for (ScoreDoc scoreDoc : scoreDocs) {
//            // 获取文档编号
//            int docID = scoreDoc.doc;
//            Document doc = reader.document(docID);
//            System.out.println("id: " + doc.get("id"));
//
//            String title = doc.get("title");
//            // 用高亮工具处理普通的查询结果,参数：分词器，要高亮的字段的名称，高亮字段的原始值
//            String hTitle = highlighter.getBestFragment(new IKAnalyzer(), "title", title);
//
//            System.out.println("title: " + hTitle);
//            // 获取文档的得分
//            System.out.println("得分：" + scoreDoc.score);
//        }
//
//    }
//}
//

    @Test
    public void test1() {
        ClinicSearch clinicSearch = ClinicSearch.getInstance();
        AuxiliaryDiagnosisSearchResult auxiliaryDiagnosisSearch = clinicSearch.searchAuxiliaryDiagnosis("髋关节", 1 ,10);
        System.out.println(auxiliaryDiagnosisSearch);
    }

    }