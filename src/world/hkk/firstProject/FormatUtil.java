package world.hkk.firstProject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author HaoKangkang healthhealthgood@gmail.com
 * @version 2019-05-0717:44
 */
public class FormatUtil {
    public static final String MOVIE_NAME = "影片";
    public static final String PRICE_NAME = "价格";
    public static final String IS_LEND_NAME = "状态";
    public static final String TENANT_NAME = "借阅者";
    public static final String LEND_DATE_NAME = "借出日期";
    public static final String RENT_TIMES_NAME = "借阅次数";

    public static final Map<String,Integer> printWidthMap = new HashMap<>();


    static {
        printWidthMap.put(MOVIE_NAME,20);
        printWidthMap.put(PRICE_NAME,10);
        printWidthMap.put(IS_LEND_NAME,10);
        printWidthMap.put(TENANT_NAME,10);
        printWidthMap.put(LEND_DATE_NAME,14);
        printWidthMap.put(RENT_TIMES_NAME,10);
    }

    private static int getSpaceCount(String string){

        String[] chars = string.split("");
        int totalCount = chars.length;
        int chineseCount = 0;
        for (String s :
                chars) {
            if (s.getBytes().length > 1){
                ++chineseCount;
            }
        }
        if(chineseCount == 0){
            return chars.length;
        }
        int englishCount = totalCount - chineseCount;
        return englishCount + (int)(chineseCount * 1.7) + 1;
    }


    private static void printFormat(String title,String value, boolean isLeftTable){
        int remainWhiteSpace = printWidthMap.get(title) - getSpaceCount(value);
        if(remainWhiteSpace <= 0){
            String[] split = value.split("");
            double ruler = 0;
            int cutIndex = 0;
            for (int i = split.length - 1; i >= 0; i--) {
                if(split[i].getBytes().length > 1){
                    ruler += 1.7;
                }else{
                    ruler += 1;
                }
                if(ruler > -remainWhiteSpace){
                    cutIndex = i;
                    break;
                }
            }
            value = value.substring(0,cutIndex - 3) + "...";
        }
        remainWhiteSpace = printWidthMap.get(title) - getSpaceCount(value);
        if(isLeftTable){
            System.out.print("\t");
        }
        System.out.print(value);
        System.out.printf("%"+remainWhiteSpace+"s","\t");
    }
    
    public static void printFormatTitles(String... titles){
        for (String title :
                titles) {
            printFormat(title,title,false);
        }
    }
    
    public static void printFormatTitleEntries(List<DVD.TitleEntry> list){
        for (DVD.TitleEntry entry :
                list) {
            printFormat(entry.getTitle(), entry.getValue(),false);
        }
    }
}
