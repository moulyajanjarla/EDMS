package com.edms.lite.controller;
@RestController
@RequestMapping("/api/thumbnail")
public class ThumbnailController {

    @Autowired
    private ThumbnailService thumbnailService;

    @PostMapping("/generate")
    public ResponseEntity<byte[]> generateThumbnail(@RequestParam("file") MultipartFile file) throws IOException {
        byte[] thumb = thumbnailService.generateThumbnail(file);
        return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(thumb);
    }
}

