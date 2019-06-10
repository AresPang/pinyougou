package com.bigshark;

import org.csource.fastdfs.*;

public class Test {
    public static void main(String[] args) throws Exception {
        //1.加载配置文件
        ClientGlobal.init("F:\\Study\\java\\pinyougou\\code\\pinyougou_tech\\pinyougou4_fastdfs\\src\\main\\resources\\fdfs_client.conf");
        //2.创建管理者客户端
        TrackerClient client = new TrackerClient();
        //3.连接管理者服务端
        TrackerServer trackerServer = client.getConnection();
        //4.声明存储服务器
        StorageServer storageServer = null;
        //5.获取存储服务器的客户端对象
        StorageClient storageClient = new StorageClient(trackerServer, storageServer);
        //6.上传文件
        String[] strings = storageClient.upload_file("F:\\Study\\java\\pinyougou\\code\\pinyougou_tech\\pinyougou4_fastdfs\\src\\main\\webapp\\1.jpg", "jpg", null);
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
