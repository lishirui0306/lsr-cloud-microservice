package cn.lsr.cloud.common.util;

import cn.lsr.cloud.common.entity.Result;
import cn.lsr.cloud.common.exception.CommonException;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * @Description: 文件工具类
 * @Package: lsr-cloud-microservice
 * @email: Hacker_lsr@126.com
 * @author: lishirui
 **/
public class FileUtil {
    /**
     * 将文件转换为json
     * @param file 文件流
     * @return 返回json数据 可以使用 jsonObject.get("data") 获取到json文件里面的数据
     */
    public static JSONObject fileToJson(MultipartFile file){
        String readJsonFile = null;
        try {
            byte[] bytes = file.getBytes();
            readJsonFile = new String(bytes,"utf-8");
        } catch (IOException e) {
            throw new CommonException("解析Json文件失败！",e);
        }
        return JSON.parseObject(readJsonFile);
    }
    /**
     * 下载文件到客户端ui
     * @param response 返回的数据
     * @param name 文件名
     * @param modelFloder 文件保存的位置，存在jvm同级
     * @param flag 是否删除
     * @return 结果集
     */
    public static Result down(HttpServletResponse response, String name ,String modelFloder , boolean flag){
        Result result = new Result(Result.SUCCESS_CODE);
        String path = System.getProperty("user.dir")+"\\"+modelFloder+"\\"+name+".json";;
        String fileName = path.substring(path.lastIndexOf("/") +1);
        File file = new File(path);
        if (!file.exists()){
            result.setCode(Result.ERROR_CODE);
            result.setMsg("路径有误，或文件不存在！");
            return result;
        }
        try {
            //将文件名称进行编码
            response.setHeader("content-disposition","attachment;filename=" + URLEncoder.encode(fileName,"UTF-8"));
            //response.setContentType("content-type:octet-stream");
            BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file));
            OutputStream outputStream = response.getOutputStream();
            byte[] buffer = new byte[1024];
            int len;
            // 将流中内容写出去
            while ((len = inputStream.read(buffer)) != -1){
                outputStream.write(buffer ,0 , len);
            }
            inputStream.close();
            outputStream.close();
            if (flag){
                deleteFile(path);
            }
        } catch (IOException e) {
            throw new CommonException("创建模型json文件失败！",e);
        }
        return  result;
    }
    /**
     *  根据路径删除指定的目录或文件，无论存在与否
     *@param sPath  要删除的目录或文件
     *@return 删除成功返回 true，否则返回 false。
     */
    public static boolean DeleteFolder(String sPath) {
        boolean flag = false;
        File file = new File(sPath);
        // 判断目录或文件是否存在
        if (!file.exists()) {  // 不存在返回 false
            return flag;
        } else {
            // 判断是否为文件
            if (file.isFile()) {  // 为文件时调用删除文件方法
                return deleteFile(sPath);
            } else {  // 为目录时调用删除目录方法
                return deleteDirectory(sPath);
            }
        }
    }
    /**
     * 删除单个文件
     * @param   sPath    被删除文件的文件名
     * @return 单个文件删除成功返回true，否则返回false
     */
    public static boolean deleteFile(String sPath) {
        boolean flag = false;
        File file = new File(sPath);
        // 路径为文件且不为空则进行删除
        if (file.isFile() && file.exists()) {
            file.delete();
            flag = true;
        }
        return flag;
    }
    /**
     * 删除目录（文件夹）以及目录下的文件
     * @param   sPath 被删除目录的文件路径
     * @return  目录删除成功返回true，否则返回false
     */
    public static boolean deleteDirectory(String sPath) {
        //如果sPath不以文件分隔符结尾，自动添加文件分隔符
        if (!sPath.endsWith(File.separator)) {
            sPath = sPath + File.separator;
        }
        File dirFile = new File(sPath);
        //如果dir对应的文件不存在，或者不是一个目录，则退出
        if (!dirFile.exists() || !dirFile.isDirectory()) {
            return false;
        }
        boolean flag = true;
        //删除文件夹下的所有文件(包括子目录)
        File[] files = dirFile.listFiles();
        for (int i = 0; i < files.length; i++) {
            //删除子文件
            if (files[i].isFile()) {
                flag = deleteFile(files[i].getAbsolutePath());
                if (!flag) break;
            } //删除子目录
            else {
                flag = deleteDirectory(files[i].getAbsolutePath());
                if (!flag) break;
            }
        }
        if (!flag) return false;
        //删除当前目录
        if (dirFile.delete()) {
            return true;
        } else {
            return false;
        }
    }
}
