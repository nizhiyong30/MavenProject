package cn.test;

import com.google.common.collect.Iterables;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.ListUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.lang3.StringUtils;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.xerial.snappy.Snappy;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by nizy on 2019/1/9.
 */
public class Test {

    public static void main(String[] args) throws Exception {
        String s = "^##^{\"cacheVersion\":0,\"start\":0,\"rows\":10,\"blockData\":{\"tradeItemId\":[681946301,682890430,682912612,675646641,670334806,682687137,620278769,682977822,678171780,671935620],\"image\":[\"/mlcdn/c45406/190811_7434049ga6k4fail1305k78g71fhi_640x960.jpg\",\"/mlcdn/c45406/190920_5k04il01eeeillbeheajj4j1j7451_3333x4999.jpg\",\"/mlcdn/c45406/190921_0a9834aie88k0cld336d53iaea5f8_3332x4999.jpg\",\"/mlcdn/c45406/181212_0jjh89596a20ajbeh3796k7ll74bl_640x960.jpg\",\"/mlcdn/c45406/180720_77i4a5baba18a1h12gd4d337g6g62_640x960.jpg\",\"/mlcdn/c45406/190914_1eb3hh9llddflj0b417fd4b08c9g6_3332x4999.jpg\",\"/mlcdn/c45406/170824_645l795d4e4i84jagja8a8albh79j_640x960.jpg\",\"/mlcdn/c45406/190925_6klla4d261jhf9j1egj44b2b25hg7_3749x4999.jpg\",\"/mlcdn/c45406/190414_5dldh21a28j4a00hc4jhfka0jci2i_640x960.jpg\",\"/mlcdn/c45406/180903_5ekh1ek4ldelc441bce3ak57016g5_640x960.jpg\"],\"acm\":[\"3.ms.1_4_1mk0yb6.0.1297-69421-69436-59064.3fUA4ryPuxQm6.sd_117-c_1_0_530678179_0_0_8-t_3fUA4ryPuxQm6-tx_20000288_0-qid_213941\",\"3.ms.1_4_1ml5fas.0.1297-69421-69436-59064.3fUA4ryPuxQm6.sd_117-c_1_0_530669395_0_0_8-t_3fUA4ryPuxQm6-tx_20000288_0-qid_213941\",\"3.ms.1_4_1ml6dj4.0.1297-69421-69436-59064.3fUA4ryPuxQm6.sd_117-c_1_0_530364992_0_0_8-t_3fUA4ryPuxQm6-tx_20000288_0-qid_213941\",\"3.ms.1_4_1mciwm2.0.1297-69421-69436-59064.3fUA4ryPuxQm6.sd_117-c_1_0_530381617_0_0_8-t_3fUA4ryPuxQm6-tx_20000288_0-qid_213941\",\"3.ms.1_4_1m677c4.0.1297-69421-69436-59064.3fUA4ryPuxQm6.sd_117-c_1_0_530492559_0_0_8-t_3fUA4ryPuxQm6-tx_20000288_0-qid_213941\",\"3.ms.1_4_1mkwpkq.0.1297-69421-69436-59064.3fUA4ryPuxQm6.sd_117-c_1_0_530341818_0_0_8-t_3fUA4ryPuxQm6-tx_20000288_0-qid_213941\",\"3.ms.1_4_1kilgd6.0.1297-69421-69436-59064.3fUA4ryPuxQm6.sd_117-c_1_0_530207787_0_0_8-t_3fUA4ryPuxQm6-tx_20000288_0-qid_213941\",\"3.ms.1_4_1ml965w.0.1297-69421-69436-59064.3fUA4ryPuxQm6.sd_117-c_1_0_529392191_0_0_3-t_3fUA4ryPuxQm6-tx_20000288_0-qid_213941\",\"3.ms.1_4_1mfj5fk.0.1297-69421-69436-59064.3fUA4ryPuxQm6.sd_117-c_1_0_495088255_0_0_3-t_3fUA4ryPuxQm6-tx_20000288_0-qid_213941\",\"3.ms.1_4_1m83tq8.0.1297-69421-69436-59064.3fUA4ryPuxQm6.sd_117-c_1_0_529473150_0_0_8-t_3fUA4ryPuxQm6-tx_20000288_0-qid_213941\"]}}^##^{\"cacheVersion\":0,\"start\":10,\"rows\":10,\"blockData\":{\"tradeItemId\":[671693464,623232115,681523438,677231281,682583561,677414451,676719202,676821370,682858836,622923931],\"image\":[\"/mlcdn/c45406/180828_7c7i6f1642igai5j52fj8f8j2ladi_640x960.jpg\",\"/mlcdn/c45406/170929_012hf03j4e025h70ka0c2g77lfhec_640x960.jpg\",\"/mlcdn/c45406/190723_1aedk6221iga273374jeehfka98j9_640x960.jpg\",\"/mlcdn/c45406/190309_1fejd33jg1l7lh5e3hfl466g78777_640x960.jpg\",\"/mlcdn/c45406/190907_04b22gd5d896jk71f9d10756f4hhj_640x800.jpg\",\"/mlcdn/c45406/190316_683jkhgbi1fkk1hfl177ae9li3ga9_640x959.jpg\",\"/mlcdn/c45406/190217_4e3gc1hid2lhlbb0fe23k707e0a9l_800x1200.jpg\",\"/mlcdn/c45406/190222_72hbek6laf60fi88j8lg3be9adfd9_640x960.jpg\",\"/mlcdn/c45406/190919_1577c5e3jfdgh074b0e6jg4bi4j72_3333x4999.jpg\",\"/mlcdn/c45406/180920_0g77cd1h9fia0hkf09kg9bk6jce7i_640x960.jpg\"],\"acm\":[\"3.ms.1_4_1m7tg14.0.1297-69421-69436-59064.3fUA4ryPuxQm6.sd_117-c_1_0_440058050_0_0_3-t_3fUA4ryPuxQm6-tx_20000288_0-qid_213941\",\"3.ms.1_4_1km41zy.0.1297-69421-69436-59064.3fUA4ryPuxQm6.sd_117-c_1_0_435102409_0_0_3-t_3fUA4ryPuxQm6-tx_20000288_0-qid_213941\",\"3.ms.1_4_1mjitqs.0.1297-69421-69436-59064.3fUA4ryPuxQm6.sd_117-c_1_0_530219226_0_0_8-t_3fUA4ryPuxQm6-tx_20000288_0-qid_213941\",\"3.ms.1_4_1meeu1m.0.1297-69421-69436-59064.3fUA4ryPuxQm6.sd_117-c_1_0_489091796_0_0_3-t_3fUA4ryPuxQm6-tx_20000288_0-qid_213941\",\"3.ms.1_4_1mks9qi.0.1297-69421-69436-59064.3fUA4ryPuxQm6.sd_117-c_1_0_529979915_0_0_8-t_3fUA4ryPuxQm6-tx_20000288_0-qid_213941\",\"3.ms.1_4_1memopq.0.1297-69421-69436-59064.3fUA4ryPuxQm6.sd_117-c_1_0_530553981_0_0_8-t_3fUA4ryPuxQm6-tx_20000288_0-qid_213941\",\"3.ms.1_4_1mdsvss.0.1297-69421-69436-59064.3fUA4ryPuxQm6.sd_117-c_1_0_479802441_0_0_3-t_3fUA4ryPuxQm6-tx_20000288_0-qid_213941\",\"3.ms.1_4_1mdx9gs.0.1297-69421-69436-59064.3fUA4ryPuxQm6.sd_117-c_1_0_529135511_0_0_8-t_3fUA4ryPuxQm6-tx_20000288_0-qid_213941\",\"3.ms.1_4_1ml42jk.0.1297-69421-69436-59064.3fUA4ryPuxQm6.sd_117-c_1_0_530772676_0_0_8-t_3fUA4ryPuxQm6-tx_20000288_0-qid_213941\",\"3.ms.1_4_1klquem.0.1297-69421-69436-59064.3fUA4ryPuxQm6.sd_117-c_1_0_334684487_0_0_3-t_3fUA4ryPuxQm6-tx_20000288_0-qid_213941\"]}}";
        System.out.println(Snappy.compress(s.getBytes()).length);
        System.out.println(s.getBytes().length);
        System.out.println(" ".getBytes());
     List<Integer> list = new ArrayList();
//     list.add(1);
//     list.add(2);
//     list.add(3);
//     list.add(4);
//        System.out.println(list.subList(0, 0));
    }

    public static boolean isPrime(Long num) {
        Long i;
        for (i = 2L; i < num - 1; i++) {
            if (num % i == 0) {
                break;
            }
        }
        if ((i == num - 1) || (num == 2)) {
            return true;
        } else {
            return false;
        }

    }

    public static void codestastic() throws IOException {
        String path = "/Users/nizhiyong/Downloads/topn_es.txt";
        Pattern pattern1 = Pattern.compile("Cascade:@?(.*)\"");
        int totalLine = 0;
        int codeLine = 0;
        Map<String, Integer> result = new HashMap<>();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(path)),
                    "UTF-8"));
            String lineTxt = null;
            while ((lineTxt = br.readLine()) != null) {
                totalLine++;
                Matcher matcher = pattern1.matcher(lineTxt);
                if (matcher.find()) {
                    String code = matcher.group(1);
                    if (StringUtils.isNotBlank(code)) {
                        codeLine++;
                        Integer count = null;
                        if ((count = result.get(code)) == null) {
                            result.put(code, 1);
                        } else {
                            result.put(code, count + 1);
                        }
                    }
                }
            }
            br.close();
            System.out.println(totalLine);
            System.out.println(codeLine);
            List<Map.Entry<String, Integer>> list = new ArrayList<>(result.entrySet());
            Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    return o2.getValue().compareTo(o1.getValue());
                }
            });
            for (Map.Entry<String, Integer> entry : list) {
                System.out.println(entry.getKey() + "," + entry.getValue());
            }
        } catch (Exception e) {
            System.err.println("read errors :" + e);
        }
    }


}
