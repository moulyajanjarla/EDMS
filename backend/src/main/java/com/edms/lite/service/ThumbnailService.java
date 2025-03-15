package com.edms.lite.service;
@Service
public class ThumbnailService {

    public byte[] generateThumbnail(MultipartFile file) throws IOException {
        BufferedImage thumbnail = ImageIO.read(file.getInputStream());
        BufferedImage resized = Scalr.resize(thumbnail, Scalr.Method.QUALITY, Scalr.Mode.FIT_TO_WIDTH, 200, 200);
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(resized, "png", baos);
        return baos.toByteArray();
    }
}
