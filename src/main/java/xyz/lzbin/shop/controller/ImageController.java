package xyz.lzbin.shop.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import xyz.lzbin.shop.result.ResultInfo;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;

/**
 * @author lzb
 */
@RestController
public class ImageController {

    @RequestMapping(value = "/image/imageUpload", method = RequestMethod.POST)
    public ResultInfo uploadFile(@RequestParam("file") MultipartFile files,
                                 HttpServletRequest request) {

        String imagePath = null;
        // 文件保存路径
        String fileName = UUID.randomUUID().toString().replace("-","")+".jpg";
        String filePath = "C://tempUpload//"+fileName;
        // 转存文件
        try {
            //保存至服务器
            File file = new File((filePath));
            if(!file.getParentFile().exists()){
                file.mkdirs();
            }
            files.transferTo(file);
            imagePath = "/upload/"+fileName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultInfo.success().data("imgUrl",imagePath);
    }

//    @RequestMapping(value = "/image/imageDelete", method = RequestMethod.POST)
//    public ResultInfo imageDelete(@RequestParam("uuid") String uuid,
//                                  HttpServletRequest request) {
//
//
//        String imagePath = uuid.split("com/")[1];
//        try {
//
//            //从七牛云服务器上删除图片
//            imagePath = QiniuUtil.deleteFile(imagePath);
//            if (imagePath.contains("error")) {
//                throw new RestfulException("删除图片失败");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return ResultInfo.success("");
//    }

}
