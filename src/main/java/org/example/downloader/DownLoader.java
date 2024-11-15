package org.example.downloader;

import java.io.*;
import java.math.BigDecimal;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.*;

/***
 * 多线程下载器
 *
 * @author Swei
 * @description
 * @date 2024/10/30 10:28
 **/
public class DownLoader {

    private Integer threadNum = 1;

    /***
     * 下载网络文件到本地
     *
     * @description
     * @param
     * @author Swei
     * @date 2024/10/30 10:43
     * @return void
     */
    private void download(String sourceUrl, String tagerDir) {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        InputStream inputStreamAll = null;
        try {
            String fileName = sourceUrl.substring(sourceUrl.lastIndexOf("/") + 1);
            if (!fileName.toLowerCase().contains("png") && !fileName.toLowerCase().contains("jpg")) {
                fileName += ".PNG";
            }
            String fileDir = tagerDir + File.separator + fileName;
            File targetFile = new File(fileDir);
            if (!targetFile.exists()) {
                targetFile.createNewFile();
            }
            URL url = new URL(sourceUrl);
            URLConnection urlConnection = url.openConnection();
            URLConnection urlConnection2 = url.openConnection();
            inputStream = urlConnection.getInputStream();
            inputStreamAll = urlConnection2.getInputStream();
            outputStream = new FileOutputStream(targetFile);
            byte[] buffer = new byte[1024];
            int len = 0;
            int allCount = 0;
            int currentCount = 0;
            //获取文件总大小
            while ((len = inputStreamAll.read(buffer)) != -1) {
                allCount += len;
            }
            System.out.println("[INFO]文件" + fileName + "总大小" + Math.floor(allCount / 1024) + "KB");
            len = 0;
            Thread.sleep(1000);
            while ((len = inputStream.read(buffer)) != -1) {
                currentCount += len;
                //计算下载进度
                BigDecimal aCount = new BigDecimal(currentCount);
                BigDecimal bCount = new BigDecimal(allCount);
                System.out.println("[INFO]文件" + fileName + "下载进度：" + ((aCount.divide(bCount, 2, BigDecimal.ROUND_HALF_UP)).multiply(new BigDecimal(100))) + "%");
                outputStream.write(buffer, 0, len);
            }
            System.out.println("[INFO]文件" + fileName + "下载成功，下载的文件路径:" + fileDir + "（文件大小" + Math.floor(targetFile.length() / 1024) + "KB）");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /***
     * 根据配置源网址批量下载文件
     *
     * @description 启动多线程下载文件
     * @param
     * @author Swei
     * @date 2024/10/30 14:40
     * @return void
     */
    private void multiDownloadFromFile(String sourceFilePath, String tagerDir) {
        BufferedReader reader = null;
        List<String> urls = new ArrayList<>();
        ExecutorService executorService = null;
        try {
            File file = new File(tagerDir);
            if (!file.exists()) {
                file.mkdirs();
            }
            reader = new BufferedReader(new FileReader(sourceFilePath));
            String line = null;
            while ((line = reader.readLine()) != null) {
                urls.add(line);
            }
            if (!urls.isEmpty()) {
                System.out.println("多线程启动！");
                executorService = Executors.newFixedThreadPool(threadNum);
                DownLoader that = this;
                for (String url : urls) {
                    executorService.execute(new Runnable() {
                        @Override
                        public void run() {
                            that.download(url, tagerDir);
                        }
                    });
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (executorService != null) {
                executorService.shutdown();
                System.out.println("多线程关闭！");
            }
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        DownLoader downLoader = new DownLoader();
        String configFliePath = "/Users/sun/Desktop/Work/Source/Other_Codes/Myself/SpringBoot/Study/src";
        Properties properties = new Properties();
        FileReader reader = null;
        try {
            reader = new FileReader(configFliePath + File.separator + "i18n-config.properties");
            properties.load(reader);
            String tagerDir = properties.getProperty("tagret-dir");
            downLoader.threadNum = Integer.parseInt(properties.getProperty("thread-num"));
            downLoader.multiDownloadFromFile(configFliePath + File.separator + "download.txt", tagerDir);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
