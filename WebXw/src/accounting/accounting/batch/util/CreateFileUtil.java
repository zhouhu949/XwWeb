package accounting.batch.util;

import java.io.File;  
import java.io.IOException;  
  
public class CreateFileUtil {  
     
    public static boolean createFile(String destFileName) {  
        File file = new File(destFileName);  
        if(file.exists()) {  
            return false;  
        }  
        if (destFileName.endsWith(File.separator)) {    
            return false;  
        }  
        //判断目标文件所在的目录是否存在  
        if(!file.getParentFile().exists()) {  
            //如果目标文件所在的目录不存在，则创建父目录  
            if(!file.getParentFile().mkdirs()) {
                return false;  
            }  
        }  
        //创建目标文件  
        try {  
            if (file.createNewFile()) {  
                return true;  
            } else {
                return false;  
            }  
        } catch (IOException e) {  
            e.printStackTrace(); 
            return false;  
        }  
    }  
          
    public static boolean createDir(String destDirName) {  
        File dir = new File(destDirName);  
        if (dir.exists()) {  
            return false;  
        }  
        if (!destDirName.endsWith(File.separator)) {  
            destDirName = destDirName + File.separator;  
        }  
        //创建目录  
        if (dir.mkdirs()) {   
            return true;  
        } else {  
            return false;  
        }  
    }  
     
     
    public static String createTempFile(String prefix, String suffix, String dirName) {  
        File tempFile = null;  
        if (dirName == null) {  
            try{  
                //在默认文件夹下创建临时文件  
                tempFile = File.createTempFile(prefix, suffix);  
                //返回临时文件的路径  
                return tempFile.getCanonicalPath();  
            } catch (IOException e) {  
                e.printStackTrace();   
                return null;  
            }  
        } else {  
            File dir = new File(dirName);  
            //如果临时文件所在目录不存在，首先创建  
            if (!dir.exists()) {  
                if (!CreateFileUtil.createDir(dirName)) {  
                    return null;  
                }  
            }  
            try {  
                //在指定目录下创建临时文件  
                tempFile = File.createTempFile(prefix, suffix, dir);  
                return tempFile.getCanonicalPath();  
            } catch (IOException e) {  
                e.printStackTrace();  
                return null;  
            }  
        }  
    }  
     
    public static void main(String[] args) {  
        //创建目录  
        String dirName = "D:/work/temp/temp0/temp1";  
        CreateFileUtil.createDir(dirName);  
        //创建文件  
        String fileName = dirName + "/temp2/tempFile.txt";  
        CreateFileUtil.createFile(fileName);  
        //创建临时文件  
        String prefix = "temp";  
        String suffix = ".txt";  
        for (int i = 0; i < 10; i++) {  
            System.out.println("创建了临时文件："  
                    + CreateFileUtil.createTempFile(prefix, suffix, dirName));  
        }  
        //在默认目录下创建临时文件  
        for (int i = 0; i < 10; i++) {  
            System.out.println("在默认目录下创建了临时文件："  
                    + CreateFileUtil.createTempFile(prefix, suffix, null));  
        }  
    }  
  
}  

