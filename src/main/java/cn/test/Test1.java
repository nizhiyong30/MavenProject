package cn.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.xerial.snappy.Snappy;

import java.io.IOException;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by nizy on 2019/4/16.
 */
@Slf4j
public class Test1 {

    public static void main(String[] args) {
        Double d = new Double("0.0000940000027185306");
        System.out.println(d);

        BigDecimal bigDecimal = new BigDecimal(9.40000027185306E-5);
        System.out.println(bigDecimal.toString());
    }

        @Test
        public void test () {
        String s = "{\"app\":\"fashion_show\",\"check\":true,\"cip\":\"10.85.34.236\",\"clientInfo\":\"group:null,app:fashion_show,dev:xiaojun,cip:10.85.34.236\",\"debug\":true,\"dev\":\"xiaojun\",\"did\":\"\",\"exArgs\":\"\",\"expIds\":\"62823\",\"extras\":{\"_t_ctx_msg_\":\"context with empty!\"},\"fcid\":\"\",\"market\":\"MGJ\",\"merge\":false,\"pid\":\"\",\"platform\":\"PC\",\"queries\":[{\"check\":true,\"code\":\"app_cpc_search\",\"divide\":\"default:10\",\"extras\":{\"presentPrice\":\"finalPrice_it\",\"source\":\"17\",\"isOuterCps\":\"false\"},\"filter\":[],\"firstRequest\":true,\"fl\":\"saleThirty_it,actorName,videoId,type,userMarks,shango,activityId,activityPrice,activityTitle,preEnd_it,moreDiscount,price,coverImage,mgj_market_ad,shopId,countLimitNumber,actUserId,liveStatus,tradeItemId,image,titleTags,newBizTag,formVal,explainCover,created,itemMarks,titleTags_ik,searchTag,onShelfTime,_rankscore_,mdDisPercent,similar_group_id,officialRmdDesc,livingURL,promotionPrice,itemExtra,explainClip,finalPrice_it,ppath,explainURL,title,ee_stage,officialRmdTitle,countLimitCutPrice,duration,activityStock,sequenceNo,videoUrl,shopTags_ws,processType,activitySale,groupSale_it,pagani_app,prePrice,showImages,bizExtra,explainId,liveId,mainImage,sale,preStart_it,cfav,endTime,groupSale,ppath_new,actorAvatar\",\"offset\":-1,\"page\":1,\"query\":[\"searchTag:104\",\"wallTestTags:(0)\"],\"rows\":10,\"searchIds\":false,\"uq\":\"气质连衣裙\"}],\"uid\":\"\",\"uuid\":\"\"}";
            s = StringUtils.remove(s, "/");
            System.out.println(s);
        }

        public static void listTest (List list){
            for (Object obj : list) {
                System.out.print(obj + " ");
            }
        }
    }
