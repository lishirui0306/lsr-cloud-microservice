package cn.lsr.cloud.common.util;

import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Description: 时间工具类
 * @Package: lsr-cloud-microservice
 * @email: Hacker_lsr@126.com
 * @author: lishirui
 **/
public class DateUtil {
    private static final String YYYY_MM_DD_HH_MM_SS_SSS="yyyy-MM-dd HH:mm:ss:SSS";
    //可能的时间格式
    private static final String[] format = {" HH:mm:ss", "yyyy-MM-dd", "yyyyMMdd", "yyyy/MM/dd"};
    //时间匹配正则表达式
    private static final String[] dateRegex = {"^[\\d]{4}+[-]+[\\d]{1,2}+[-]+[\\d]{1,2}$", "\\d{8}", "^[\\d]{4}+[/]+[\\d]{1,2}+[/]+[\\d]{1,2}$"};
    //时间前后分割
    private static String space = "[A-Za-z\\s.]+"; //字母，空格，小数点

    private static String toTwo(String value) {
        return String.format("%02d", Integer.parseInt(value));
    }

    /**
     * 转换时间格式 String 转Date [A-Za-z.]+ 排除其他异常输入格式
     * @param date 时间
     * @return date 时间格式
     */
    public static Date parseDate(String date) {
        Date value = null;
        if (date != null && !date.matches("[A-Za-z.]+")) {
            try {
                date = date.split("[A-Za-z.]+")[0].trim();
                String pre = date.split("[\\s]+")[0];
                if (pre.matches(dateRegex[0])) {
                    value = DateUtils.parseDate(date, format[1], format[1] + format[0]);
                } else if (pre.matches(dateRegex[1])) {
                    value = DateUtils.parseDate(date, format[2], format[2] + format[0]);
                } else if (pre.matches(dateRegex[2])) {
                    value = DateUtils.parseDate(date, format[3], format[3] + format[0]);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return value;
    }

    /**
     * String转换String日期
     * @param date 日期
     * @param type  格式 yyyyMMdd ...
     * @return
     */
    public static String stringToString(String date,String type){
        Date date1 = parseDate(date);
        SimpleDateFormat sdf = new SimpleDateFormat(type);
        return sdf.format(date1);
    }
    /**
     * 时间比较
     * @param s 开始时间
     * @param s1 结束时间
     * @param s3 参数时间
     * @return
     */
    public static boolean comparisonSize(String s ,String s1,String s3){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        try {
            Date date1 = simpleDateFormat.parse(s);
            Date date2 = simpleDateFormat.parse(s1);
            Date date3 = simpleDateFormat.parse(s3);
            if (date3.before(date2)&&(date3.after(date1)||date3.equals(date1))){
                return true;
            }else{
                return false;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("时间比较错误");
    }
    /**
     * 时间+1天
     * @param s
     * @return
     */
    public static String dateAdd(String s) {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        Date d;
        try {
            d = simpleDateFormat.parse(s);
            c.setTime(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //利用Calendar 实现 Date日期+1天   
        c.add(Calendar.DAY_OF_MONTH,1);
        return simpleDateFormat.format(c.getTime());
    }
    /**
     * 时间戳转化为年月日时分秒毫秒
     * @param date 毫秒时间
     * @return
     */
    public static String longToDate(Long date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS_SSS);
        Date date1= new Date(date);
        String s = null;
        s = simpleDateFormat.format(date1);
        return s;
    }
    /**
     * 年月日时分秒毫秒转化为时间戳
     * @param date
     * @return
     */
    public static Long dateToLong(String date){
        SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS_SSS);
        long time = 0;
        try {
            time = sdf.parse(date).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return time;
    }
}
